package org.bansikah.serverappbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bansikah.serverappbackend.enumeration.Status;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Server {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "IP Address cannot be empty")
    private String ipAddress;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotEmpty(message = "Memory cannot be empty")
    private String memory;

    @NotEmpty(message = "Type cannot be empty")
    private String type;

    @NotEmpty(message = "Image URL cannot be empty")
    private String imageUrl;

    private Status status;


}
