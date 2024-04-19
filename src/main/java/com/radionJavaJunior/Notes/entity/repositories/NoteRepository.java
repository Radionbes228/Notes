package com.radionJavaJunior.Notes.entity.repositories;

import com.radionJavaJunior.Notes.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface NoteRepository extends JpaRepository<NoteEntity, Long> {
    void deleteById(Long id);
}
