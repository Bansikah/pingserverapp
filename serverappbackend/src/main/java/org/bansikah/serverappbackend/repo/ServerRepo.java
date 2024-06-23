package org.bansikah.serverappbackend.repo;

import org.bansikah.serverappbackend.enumeration.Status;
import org.bansikah.serverappbackend.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerRepo extends JpaRepository<Server,Long> {
    Server findByIpAddress(String ipAddress);
}
