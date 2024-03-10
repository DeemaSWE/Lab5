package com.example.lab5.EventSystem.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Event {

    private String id;
    private String description;
    private int capacity;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime startDate;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime endDate;

}
