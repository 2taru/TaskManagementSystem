package com.taru.tasks.mapper;

import com.taru.tasks.dto.TaskDTO;
import com.taru.tasks.entity.Task;

public class TaskMapper {

    public static TaskDTO mapToDto(Task task) {

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTaskId(task.getTaskId());
        taskDTO.setAssignedTo(task.getAssignedTo());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setDueDate(task.getDueDate());
        taskDTO.setPriority(task.getPriority());
        taskDTO.setStatus(task.getStatus());
        return taskDTO;
    }

    public static Task mapToEntity(TaskDTO taskDTO) {

        Task task = new Task();
        task.setAssignedTo(taskDTO.getAssignedTo());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        task.setPriority(taskDTO.getPriority());
        task.setStatus(taskDTO.getStatus());
        return task;

    }
}
