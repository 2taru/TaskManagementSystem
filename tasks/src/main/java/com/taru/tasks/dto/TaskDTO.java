package com.taru.tasks.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Schema(
        name = "Task",
        description = "Scheme for storing task information"
)
public class TaskDTO {

    private Long taskId;

    @Schema(
            description = "Username of the user assigned to this task", example = "john-doe34"
    )
    @NotEmpty(message = "Username can not be a null or empty")
    @Size(min = 5, max = 30, message = "The length of the username should be between 5 and 30")
    private String assignedTo;

    @Schema(
            description = "Task title", example = "Create Service layer for Tasks"
    )
    @NotEmpty(message = "Title can not be a null or empty")
    @Size(min = 5, max = 100, message = "The length of the title should be between 5 and 100")
    private String title;

    @Schema(
            description = "Task description", example = "Create Service layer for Tasks to perform CRUD operations with business logic"
    )
    @NotEmpty(message = "Description can not be a null or empty")
    @Size(min = 5, max = 256, message = "The length of the description should be between 5 and 256")
    private String description;

    @Schema(
            description = "The date by which the task must be completed", example = "2024-02-09T20:39:25"
    )
    @Future(message = "Due date must be in the future")
    @NonNull
    private LocalDateTime dueDate;

    @Schema(
            description = "Priority of task (the bigger the priority, the faster the task should be done)", example = "2"
    )
    @Positive(message = "Priority must be greater than zero")
    private Integer priority;

    @Schema(
            description = "Task status ('TODO', 'In Progress' etc.)", example = "Done"
    )
    @NotEmpty(message = "Status can not be a null or empty")
    @Size(min = 3, max = 20, message = "The length of the status should be between 3 and 20")
    private String status;
}
