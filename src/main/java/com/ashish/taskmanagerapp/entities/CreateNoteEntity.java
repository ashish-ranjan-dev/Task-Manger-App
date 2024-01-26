package com.ashish.taskmanagerapp.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateNoteEntity {
    private Integer id;
    private String title;
    private String description;
}
