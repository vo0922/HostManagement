package com.example.HostManagement.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AliveDto {
    private String name;
    private String ip;
    private String state;
}
