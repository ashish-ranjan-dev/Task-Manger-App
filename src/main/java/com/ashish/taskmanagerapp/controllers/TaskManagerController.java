package com.ashish.taskmanagerapp.controllers;

import com.ashish.taskmanagerapp.dtos.CreateTaskDto;
import com.ashish.taskmanagerapp.entities.CreateTaskEntity;
import com.ashish.taskmanagerapp.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/task")
public class TaskManagerController {

    private final TaskService taskService;

    public TaskManagerController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/info")
    public String isServerAlive(){
        return "Server Alive!";
    }

    /**
     * create task api -> POST -> localhost:4000/task
     * receives createTaskDto and sends appropriate response
     */
    @PostMapping(value = "")
    public ResponseEntity<CreateTaskEntity> createTask(@RequestBody CreateTaskDto createTaskReq){
        CreateTaskEntity response = taskService.createTask(createTaskReq.getTitle(), createTaskReq.getDetails(), createTaskReq.getDate());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * get all tasks api -> GET -> localhost:4000/task
     */

    /**
     * get all tasks by task-id -> GET -> localhost:4000/task/{taskId}
     */

}
