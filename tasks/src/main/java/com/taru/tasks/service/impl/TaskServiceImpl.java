package com.taru.tasks.service.impl;

import com.taru.tasks.dto.TaskDTO;
import com.taru.tasks.entity.Task;
import com.taru.tasks.exception.ResourceNotFoundException;
import com.taru.tasks.mapper.TaskMapper;
import com.taru.tasks.repository.TaskRepository;
import com.taru.tasks.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public void createTask(TaskDTO taskDTO) {

        Task task = TaskMapper.mapToEntity(taskDTO);

        //TODO
        //Check if username is valid

        taskRepository.save(task);

    }

    @Override
    public TaskDTO getTaskById(long taskId) {

        Task task = taskRepository.findById(taskId).orElseThrow(
                () -> new ResourceNotFoundException("Task", "taskId", taskId + "")
        );

        return TaskMapper.mapToDto(task);
    }

    @Override
    public List<TaskDTO> getAllTasks() {

        List<Task> tasks = taskRepository.findAll();

        return tasks.stream()
                .map(TaskMapper::mapToDto)
                .toList();
    }

    @Override
    public TaskDTO updateTaskById(long taskId, TaskDTO taskDTO) {

        Task task = taskRepository.findById(taskId).orElseThrow(
                () -> new ResourceNotFoundException("Task", "taskId", taskId + "")
        );

        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        task.setPriority(taskDTO.getPriority());
        task.setStatus(taskDTO.getStatus());

        Task updatedTask = taskRepository.save(task);
        return TaskMapper.mapToDto(updatedTask);
    }

    @Override
    public void deleteTaskById(long taskId) {

        taskRepository.deleteById(taskId);
    }
}
