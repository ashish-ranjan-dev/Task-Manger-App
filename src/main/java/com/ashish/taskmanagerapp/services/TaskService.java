package com.ashish.taskmanagerapp.services;

import com.ashish.taskmanagerapp.entities.CreateTaskEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TaskService {

    private static int id = 1;

    private final ArrayList<CreateTaskEntity> taskEntities = new ArrayList<>();

    public CreateTaskEntity createTask(String title,String details,String deadline){
        CreateTaskEntity createTaskEntity = new CreateTaskEntity(id,title,details,deadline,false);
        taskEntities.add(createTaskEntity);
        id++;
        return  createTaskEntity;
    }

    public ArrayList<CreateTaskEntity> getAllTasks(){
        return taskEntities;
    }

    public  CreateTaskEntity getTaskById(Integer id){
        for(CreateTaskEntity task:taskEntities){
            if(task.getId()==id){
                return task;
            }
        }
        return null;
    }
}
