package com.example.HostManagement.api;

import com.example.HostManagement.dto.HostsDto;
import com.example.HostManagement.entity.Hosts;
import com.example.HostManagement.service.HostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class HostApi {
    private final HostService hostService;

    @PostMapping("/api/host")
    public void create(@RequestBody HostsDto hostsDto) {
        hostService.create(hostsDto);
    }
    @GetMapping("/api/host/{name}")
    public Hosts search(@PathVariable String name) {
        return hostService.search(name);
    }
    @PatchMapping("/api/host")
    public Hosts patch(@RequestBody HostsDto hostsDto) { return hostService.patch(hostsDto); }
    @DeleteMapping("/api/host/{id}")
    public Hosts delete(@PathVariable Long id) {
        return hostService.delete(id);
    }

}
