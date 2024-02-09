package com.taru.tasks.dto;

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
public class TaskDTO {

    private Long taskId;

    @NotEmpty(message = "Username can not be a null or empty")
    @Size(min = 5, max = 30, message = "The length of the username should be between 5 and 30")
    private String assignedTo;

    @NotEmpty(message = "Title can not be a null or empty")
    @Size(min = 5, max = 100, message = "The length of the title should be between 5 and 100")
    private String title;

    @NotEmpty(message = "Description can not be a null or empty")
    @Size(min = 5, max = 256, message = "The length of the description should be between 5 and 256")
    private String description;

    @Future(message = "Due date must be in the future")
    @NonNull
    private LocalDateTime dueDate;

    @Positive(message = "Priority must be greater than zero")
    private Integer priority;

    @NotEmpty(message = "Status can not be a null or empty")
    @Size(min = 3, max = 20, message = "The length of the status should be between 3 and 20")
    private String status;
}
