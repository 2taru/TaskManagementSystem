package com.taru.tasks.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDTO {

    private String assignedTo;

    private String title;

    private String description;

    private LocalDateTime dueDate;

    private Integer priority;

    private String status;
}
