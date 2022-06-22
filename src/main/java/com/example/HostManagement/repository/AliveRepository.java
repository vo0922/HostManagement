package com.example.HostManagement.repository;

import com.example.HostManagement.entity.Alive;
import com.example.HostManagement.entity.Hosts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AliveRepository extends JpaRepository<Alive, Long> {
    boolean existsByHosts(Hosts hosts);
    Alive findByHosts(Hosts hosts);
}
