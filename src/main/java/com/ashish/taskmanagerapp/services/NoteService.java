package com.ashish.taskmanagerapp.services;

import com.ashish.taskmanagerapp.entities.CreateNoteEntity;
import com.ashish.taskmanagerapp.entities.CreateTaskEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
public class NoteService {
    private final TaskService taskService;
    private static int id = 1;

    HashMap<Integer,TaskNotesHolder> taskNotesMapper = new HashMap<>();

    public NoteService(TaskService taskService) {
        this.taskService = taskService;
    }

    class TaskNotesHolder{
        private int nodeId = 1;
        private ArrayList<CreateNoteEntity> notes = new ArrayList<>();
    }

    public CreateNoteEntity createNote(Integer taskId,String title,String description){
        CreateTaskEntity task = taskService.getTaskById(taskId);
        if(task==null)return null;
        if(taskNotesMapper.get(taskId)==null){
            taskNotesMapper.put(taskId,new TaskNotesHolder());
        }
        TaskNotesHolder taskNotesHolder = taskNotesMapper.get(taskId);
        CreateNoteEntity note = new CreateNoteEntity(taskNotesHolder.nodeId,title,description);
        taskNotesHolder.notes.add(note);
        taskNotesHolder.nodeId++;
        return note;
    }

    public List<CreateNoteEntity> getAllNotes(Integer taskId){
        CreateTaskEntity task = taskService.getTaskById(taskId);
        if(task==null)return null;
        if(taskNotesMapper.get(taskId)==null){
            taskNotesMapper.put(taskId,new TaskNotesHolder());
        }
        return taskNotesMapper.get(taskId).notes;
    }

    public CreateNoteEntity getNoteById(Integer taskId,Integer noteId){
        CreateTaskEntity task = taskService.getTaskById(taskId);
        if(task==null)return null;
        if(taskNotesMapper.get(taskId)==null){
            taskNotesMapper.put(taskId,new TaskNotesHolder());
        }
        List<CreateNoteEntity> notes =  taskNotesMapper.get(taskId).notes;
        for(CreateNoteEntity note:notes){
            if(Objects.equals(note.getId(), noteId)){
                return note;
            }
        }
        return null;
    }
}
