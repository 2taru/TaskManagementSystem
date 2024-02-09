package com.taru.tasks.controller;

import com.taru.tasks.dto.ErrorResponseDTO;
import com.taru.tasks.dto.ResponseDTO;
import com.taru.tasks.dto.TaskDTO;
import com.taru.tasks.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for Task in TaskManager",
        description = "CRUD REST APIs in TaskManager to CREATE, UPDATE, GET AND DELETE tasks"
)
@RestController
@Validated
@AllArgsConstructor
@RequestMapping(path = "/api/task", produces = {MediaType.APPLICATION_JSON_VALUE})
public class TaskController {

    private final TaskService taskService;

    @Operation(
            summary = "Create Task REST API",
            description = "REST API to create new Tasks inside TaskManager"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTP Status BAD_REQUEST",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP INTERNAL_SERVER_ERROR",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    })
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createTask(@Valid @RequestBody TaskDTO taskDTO) {

        taskService.createTask(taskDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO("201", "Task created successfully!"));
    }

    @Operation(
            summary = "Get Task Details REST API",
            description = "REST API to get task information based on taskId"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "HTTP Status NOT_FOUND",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status INTERNAL_SERVER_ERROR",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    })
    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable("taskId") Long taskId) {

        TaskDTO response = taskService.getTaskById(taskId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @Operation(
            summary = "Get list of all Tasks Details REST API",
            description = "REST API to get list of all tasks information"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status INTERNAL_SERVER_ERROR",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    })
    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTTasks() {

        List<TaskDTO> response = taskService.getAllTasks();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @Operation(
            summary = "Update Task Details REST API",
            description = "REST API for updating task information based on taskId"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "HTTP Status NOT_FOUND",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status INTERNAL_SERVER_ERROR",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    })
    @PutMapping("/{taskId}/update")
    public ResponseEntity<TaskDTO> updateUserByUsername(@Valid @RequestBody TaskDTO taskDTO,
                                                        @PathVariable("taskId") Long taskId) {

        TaskDTO response = taskService.updateTaskById(taskId, taskDTO);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @Operation(
            summary = "Delete Task REST API",
            description = "REST API for deleting task information based on taskId"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "HTTP Status NOT_FOUND",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status INTERNAL_SERVER_ERROR",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    })
    @DeleteMapping("/{taskId}/delete")
    public ResponseEntity<ResponseDTO> deleteTaskById(@PathVariable("taskId") Long taskId) {

        taskService.deleteTaskById(taskId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDTO("200", "Task deleted successfully!"));
    }
}