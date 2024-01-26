package com.ashish.taskmanagerapp.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Date;

@EntityScan
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTaskEntity {
    private int id;

    private String title;

    private String details;

    private Date deadline;

    private Boolean completed;
}
