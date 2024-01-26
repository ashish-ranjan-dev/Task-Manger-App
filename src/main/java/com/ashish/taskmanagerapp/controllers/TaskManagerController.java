package com.ashish.taskmanagerapp.controllers;

import com.ashish.taskmanagerapp.dtos.CreateTaskDto;
import com.ashish.taskmanagerapp.dtos.ErrorResponseDto;
import com.ashish.taskmanagerapp.dtos.UpdateTaskDto;
import com.ashish.taskmanagerapp.entities.CreateTaskEntity;
import com.ashish.taskmanagerapp.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;

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
    public ResponseEntity<CreateTaskEntity> createTask(@RequestBody CreateTaskDto createTaskReq) throws ParseException {
        CreateTaskEntity response = taskService.createTask(createTaskReq.getTitle(), createTaskReq.getDetails(), createTaskReq.getDeadline());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * get all tasks api -> GET -> localhost:4000/task
     */
    @GetMapping(value = "")
    public ResponseEntity<ArrayList<CreateTaskEntity>> getAllTasks(){
        ArrayList<CreateTaskEntity> response = taskService.getAllTasks();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    /**
     * get all tasks by task-id -> GET -> localhost:4000/task/{taskId}
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<CreateTaskEntity> getTaskById(@PathVariable(value = "id") Integer id){
        CreateTaskEntity response = taskService.getTaskById(id);
        if(response==null){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    /**
     * updates a given task by id -> Patch -> localhost:4000/task/{id}
     *
     * @param id
     * @param updateTaskReq
     * @return
     * @throws ParseException
     */
    @PatchMapping(value = "/{id}")
    public ResponseEntity<CreateTaskEntity> updateTaskById(@PathVariable(value = "id") Integer id,@RequestBody UpdateTaskDto updateTaskReq) throws ParseException {
        CreateTaskEntity response = taskService.updateTaskById(id, updateTaskReq.getDetails(), updateTaskReq.getDeadline(),updateTaskReq.getCompleted());
        if(response==null){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto>
    handleErrors(Exception e){
        if(e instanceof ParseException){
            return ResponseEntity.badRequest().body(new ErrorResponseDto("Invalid Date Format"));
        }
        e.printStackTrace();
        return ResponseEntity.internalServerError().body(new ErrorResponseDto("Internal Server Error"));
    }

}
