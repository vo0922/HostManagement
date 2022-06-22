package com.example.HostManagement.api;

import com.example.HostManagement.dto.AliveDto;
import com.example.HostManagement.entity.Alive;
import com.example.HostManagement.service.AliveService;
import com.example.HostManagement.service.HostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@RestController
@RequiredArgsConstructor
public class AliveApi {
    private final AliveService aliveService;
    private final HostService hostService;

    @GetMapping("/api/alive/{name}")
    public Future<AliveDto> search(@PathVariable String name) {
        return aliveService.search(name);
    }

    @GetMapping("api/alive/all")
    public List<Alive> searchAll() {
        hostService.searchAll();
        return aliveService.findAll();
    }
}
