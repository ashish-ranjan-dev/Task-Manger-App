package com.ashish.taskmanagerapp.services;

import com.ashish.taskmanagerapp.entities.CreateTaskEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@Service
public class TaskService {

    private static int id = 1;

    private final ArrayList<CreateTaskEntity> taskEntities = new ArrayList<>();

    private final SimpleDateFormat deadlineFormatter = new SimpleDateFormat("yyyy-MM-dd");

    public CreateTaskEntity createTask(String title,String details,String deadline) throws ParseException {
        CreateTaskEntity createTaskEntity = new CreateTaskEntity(id,title,details,deadlineFormatter.parse(deadline),false);
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

    public CreateTaskEntity updateTaskById(Integer id,String details,String deadline,Boolean completed) throws ParseException {
        CreateTaskEntity taskEntity = getTaskById(id);
        if(taskEntity==null)return null;

        if(details!=null){
            taskEntity.setDetails(details);
        }
        if(deadline!=null){
            taskEntity.setDeadline(deadlineFormatter.parse(deadline));
        }
        if(completed!=null){
            taskEntity.setCompleted(completed);
        }

        return  taskEntity;
    }
}
