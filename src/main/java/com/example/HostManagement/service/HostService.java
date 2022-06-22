package com.example.HostManagement.service;

import com.example.HostManagement.annotation.TimeTrace;
import com.example.HostManagement.dto.HostsDto;
import com.example.HostManagement.entity.Hosts;
import com.example.HostManagement.repository.HostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HostService {
    private final HostRepository hostRepository;
    private final AliveService aliveService;

    @Transactional
    public Hosts create(HostsDto dto) {
        Hosts hosts = new Hosts(dto.getName(), dto.getIp());
        if (hostRepository.existsByName(dto.getName()) || hostRepository.existsByIp(dto.getIp()) || hostRepository.count() >= 100){
            throw new RuntimeException("이미 가입되어 있는 호스트입니다.");
        } else {
            hostRepository.save(hosts);
        }
        return hosts;
    }

    @Transactional
    public Hosts search(String name) {
        return hostRepository.findByName(name);
    }

    @Transactional
    public Hosts patch(HostsDto dto) {
        Hosts host = new Hosts(dto.getName(), dto.getIp());
        Hosts target = hostRepository.findById(dto.getId()).orElse(null);
        target.patch(host);
        return hostRepository.save(target);
    }

    @Transactional
    public Hosts delete(Long id) {
        Hosts hosts = hostRepository.findById(id).orElse(null);
        hostRepository.delete(hosts);
        return hosts;
    }

    @TimeTrace
    public void searchAll() {
        List<Hosts> hosts = hostRepository.findAll();

        hosts.stream()
                .map(dto -> aliveService.search(dto.getName()))
                .collect(Collectors.toList());
    }
}
