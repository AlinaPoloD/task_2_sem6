package com.example.task_2_sem6.controller;

import com.example.task_2_sem6.model.Note;
import com.example.task_2_sem6.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@AllArgsConstructor
public class NoteController {



        private final NoteService noteService;

        @GetMapping()
        public List<Note> getAllNote(){

            return noteService.getAllNotes();
        }
    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        Note createdNote = noteService.addNote(note);
        return ResponseEntity.ok(createdNote);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note note) {
        try {  Note updateNote = noteService.changeNote(id, note);
        return new ResponseEntity<>(note, HttpStatus.OK);
    } catch (RuntimeException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.noContent().build();
    }

    }

