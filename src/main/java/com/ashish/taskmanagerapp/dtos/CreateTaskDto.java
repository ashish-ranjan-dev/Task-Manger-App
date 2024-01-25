package com.ashish.taskmanagerapp.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTaskDto {
    private String title;

    private String details;

    private String date;
}
