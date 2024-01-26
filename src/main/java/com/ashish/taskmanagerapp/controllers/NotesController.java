package com.ashish.taskmanagerapp.controllers;

import com.ashish.taskmanagerapp.dtos.CreateNoteDto;
import com.ashish.taskmanagerapp.entities.CreateNoteEntity;
import com.ashish.taskmanagerapp.services.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/task/{taskId}/notes")
public class NotesController {

    private final NoteService noteService;

    public NotesController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping(value = "")
    public ResponseEntity<CreateNoteEntity> createNote(@PathVariable(value = "taskId") Integer taskId, @RequestBody CreateNoteDto createNoteDto){
        CreateNoteEntity note = noteService.createNote(taskId, createNoteDto.getTitle(), createNoteDto.getDescription());

        return new ResponseEntity<>(note, HttpStatus.CREATED);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<CreateNoteEntity>> getAllNotes(@PathVariable(value = "taskId") Integer taskId){
        List<CreateNoteEntity> notes = noteService.getAllNotes(taskId);
        return ResponseEntity.ok(notes);
    }

    @GetMapping(value = "/{noteId}")
    public ResponseEntity<CreateNoteEntity> getNoteById(@PathVariable(value = "taskId")Integer taskId,@PathVariable(value = "noteId")Integer noteId){
        CreateNoteEntity note = noteService.getNoteById(taskId,noteId);
        if(note==null)return ResponseEntity.notFound().build();
        return ResponseEntity.ok(note);
    }
}
