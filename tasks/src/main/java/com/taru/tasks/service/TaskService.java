package com.taru.tasks.service;


import com.taru.tasks.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    void createTask(TaskDTO taskDTO);

    TaskDTO getTaskById(long taskId);

    List<TaskDTO> getAllTasks();

    TaskDTO updateTaskById(long taskId, TaskDTO taskDTO);

    void deleteTaskById(long taskId);

}