package com.ashish.taskmanagerapp.dtos;

import com.ashish.taskmanagerapp.entities.CreateNoteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseDto {
    private int id;

    private String title;

    private String details;

    private Date deadline;

    private Boolean completed;

    private List<CreateNoteEntity> notes;
}
