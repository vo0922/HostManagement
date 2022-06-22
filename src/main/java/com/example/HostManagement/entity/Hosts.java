package com.example.HostManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Hosts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String ip;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime lastupdatedDate;

    public Hosts(String name, String ip) {
        this.name = name;
        this.ip = ip;
    }

    public void patch(Hosts hosts) {
        if (hosts.name != null) {
            this.name = hosts.name;
        }
        if (hosts.ip != null) {
            this.ip = hosts.ip;
        }
    }
}
