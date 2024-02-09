package com.taru.tasks.controller;

import com.taru.tasks.dto.ResponseDTO;
import com.taru.tasks.dto.TaskDTO;
import com.taru.tasks.service.TaskService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@AllArgsConstructor
@RequestMapping(path = "/api/task", produces = {MediaType.APPLICATION_JSON_VALUE})
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createTask(@Valid @RequestBody TaskDTO taskDTO) {

        taskService.createTask(taskDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO("201", "Task created successfully!"));
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable("taskId") Long taskId) {

        TaskDTO response = taskService.getTaskById(taskId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTTasks() {

        List<TaskDTO> response = taskService.getAllTasks();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PutMapping("/{taskId}/update")
    public ResponseEntity<TaskDTO> updateUserByUsername(@Valid @RequestBody TaskDTO taskDTO,
                                                        @PathVariable("taskId") Long taskId) {

        TaskDTO response = taskService.updateTaskById(taskId, taskDTO);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @DeleteMapping("/{taskId}/delete")
    public ResponseEntity<ResponseDTO> deleteTaskById(@PathVariable("taskId") Long taskId) {

        taskService.deleteTaskById(taskId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDTO("200", "Task deleted successfully!"));
    }
}