package com.example.task_2_sem6.Repository;


import com.example.task_2_sem6.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {


}
