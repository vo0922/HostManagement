package com.example.HostManagement.repository;

import com.example.HostManagement.entity.Hosts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HostRepository extends JpaRepository<Hosts, Long> {
    long count();
    boolean existsByName(String name);
    boolean existsByIp(String ip);
    Hosts findByName(String name);
}
