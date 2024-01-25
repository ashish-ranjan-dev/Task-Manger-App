package com.ashish.taskmanagerapp.services;

import com.ashish.taskmanagerapp.entities.CreateTaskEntity;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private static int id = 1;

    public CreateTaskEntity createTask(String title,String details,String date){
        CreateTaskEntity createTaskEntity = new CreateTaskEntity(id,title,details,date);
        id++;
        return  createTaskEntity;
    }
}
