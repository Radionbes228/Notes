package com.radionJavaJunior.Notes.entity.repositories;

import com.radionJavaJunior.Notes.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<NoteEntity, Long> {
    void deleteById(Long id);
}
