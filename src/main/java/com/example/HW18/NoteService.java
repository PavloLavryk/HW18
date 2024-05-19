package com.example.HW18;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public Note create(Note note) {
        return noteRepository.save(note);
    }

    public Optional<Note> getById(Long id) {
        return noteRepository.findById(id);
    }

    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    public Note update(Long id, Note noteDetails) {
        Note note = noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));
        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());
        return noteRepository.save(note);
    }

    public void delete(Long id) {
        Note note = noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));
        noteRepository.delete(note);
    }
}
