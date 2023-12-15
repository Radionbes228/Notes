package com.radionJavaJunior.Notes.service;

import com.radionJavaJunior.Notes.entity.NoteEntity;
import com.radionJavaJunior.Notes.entity.repositories.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@AllArgsConstructor
public class NoteService {

    private NoteRepository noteRepository;

    public void create(NoteEntity noteEntity){
        noteEntity.setCreateAt(Instant.now());
        noteRepository.save(noteEntity);
    }

    public List<NoteEntity> findAll(){
        return noteRepository.findAll();
    }
    public void update(NoteEntity noteEntity, Instant instant){
        noteEntity.setUpdateAt(instant);
        noteEntity.setDescription(noteEntity.getDescription());
        noteRepository.save(noteEntity);
    }
    public NoteEntity findById(Long id){
        return noteRepository.findById(id).orElse(null);
    }
    public void delete(Long id) {
        noteRepository.deleteById(id);
    }
}
