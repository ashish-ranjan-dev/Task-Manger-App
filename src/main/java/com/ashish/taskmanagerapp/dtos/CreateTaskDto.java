package com.ashish.taskmanagerapp.dtos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTaskDto {
    private String title;

    private String details;

    private String deadline;
}
