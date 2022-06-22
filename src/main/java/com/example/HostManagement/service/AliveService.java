package com.example.HostManagement.service;

import com.example.HostManagement.dto.AliveDto;
import com.example.HostManagement.entity.Alive;
import com.example.HostManagement.entity.Hosts;
import com.example.HostManagement.repository.AliveRepository;
import com.example.HostManagement.repository.HostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@RequiredArgsConstructor
public class AliveService {
    private final HostRepository hostRepository;
    private final AliveRepository aliveRepository;
    @Async
    public CompletableFuture<AliveDto> search(String name) {
        InetAddress pingCheck = null;
        String result = "Unreachable";
        Hosts host = hostRepository.findByName(name);
        try {
            pingCheck = InetAddress.getByName(host.getIp());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            if (pingCheck.isReachable(500)) {
                result="Reachable";

            } else {
                result = "Unreachable";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        AliveDto dto = new AliveDto(host.getName(), host.getIp(), result);

        if(aliveRepository.existsByHosts(host)) {
            Alive target = aliveRepository.findByHosts(host);
            target.patch(target);
            aliveRepository.save(target);
        }else{
            Alive alive = new Alive(result, host);
            aliveRepository.save(alive);
        }

        return CompletableFuture.completedFuture(dto);
    }

    public List<Alive> findAll() {
        return aliveRepository.findAll();
    }
}
