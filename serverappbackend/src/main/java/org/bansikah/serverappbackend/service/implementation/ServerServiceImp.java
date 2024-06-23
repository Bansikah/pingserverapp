package org.bansikah.serverappbackend.service.implementation;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.bansikah.serverappbackend.model.Server;
import org.bansikah.serverappbackend.repo.ServerRepo;
import org.bansikah.serverappbackend.service.ServerService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Random;

import static org.bansikah.serverappbackend.enumeration.Status.SERVER_DOWN;
import static org.bansikah.serverappbackend.enumeration.Status.SERVER_UP;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImp implements ServerService {

    private final ServerRepo serverRepo;
    @Override
    public Server createServer(Server server) {
        log.info("Saving new server: {}", server.getName());
        server.setImageUrl(setServerImageUrl());
        return serverRepo.save(server);
    }

    //Todo come back to this and modify
    private String setServerImageUrl() {
        String[] imageNames = {"server1.png", "server2.jpg", "server3.png", "server4.png", "server5.png", "server6.png", "server7.png"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("server/image/" + imageNames[new Random().nextInt(6)]).toUriString();
    }


    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Pinging server IP: {}", ipAddress);
        Server server = serverRepo.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
       server.setStatus(address.isReachable(10000) ? SERVER_UP : SERVER_DOWN);
       serverRepo.save(server);
        return server;
    }

    @Override
    public Collection<Server> list(int limit) {
        log.info("Searching for all servers...");
        return serverRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Server get(Long id) {
        log.info("Searching servers by id: {}", id);
        return serverRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Server not found with id: " + id));
    }
    /*@Override
    public Server get(Long id) {
        log.info("Searching servers by id: {}", id);
        return serverRepo.findById(id).get();
    }*/

    @Override
    public Server update(Server server) {
        log.info("Updating server: {}", server.getName());
        return serverRepo.save(server);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting Server by id: {}", id);
       serverRepo.deleteById(id);
       return Boolean.TRUE;
    }

    private Boolean isReachable(String ipAddress,int port, int timeOut) {
       try {
        try (Socket socket = new Socket()){
            socket.connect(new InetSocketAddress(ipAddress,port), timeOut);
        }
        return Boolean.TRUE;
        } catch (IOException e) {
           return Boolean.FALSE;
       }
    }
}
