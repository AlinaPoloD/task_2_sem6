package com.example.task_2_sem6.service;

import com.example.task_2_sem6.Repository.NoteRepository;
import com.example.task_2_sem6.model.Note;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/*		1. Добавление задачи.
		2. Просмотр всех задач.
3. Просмотр задач по статусу (например, "завершена", "в процессе", "не начата").
		4. Изменение статуса задачи.
5. Удаление задачи.*/

@Service
@AllArgsConstructor
public class NoteService {
    private final NoteRepository repository;

    public List<Note> getAllNotes() {

        return repository.findAll();
    }
    public Note addNote(Note note){
    return repository.save(note);

    }
    public void deleteNote(Long id){
        repository.deleteById(id);
    }
    public Note changeNote(Long id, Note note){
        Optional<Note> optionalNote =repository.findById(id);
        if (optionalNote.isPresent()){
            Note changeNote = optionalNote.get();
            changeNote.setTitle(note.getTitle());
            changeNote.setDescription(note.getDescription());
            return repository.save(changeNote);

        }
        else {
            throw new IllegalArgumentException("Task not found by Id");
        }


    }







}



