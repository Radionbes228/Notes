package com.radion.Java.Junior.Notes.service;

import com.radionJavaJunior.Notes.service.NoteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.radionJavaJunior.Notes.entity.NoteEntity;
import com.radionJavaJunior.Notes.entity.repositories.NoteRepository;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class NoteServiceTest {

    @Mock
    private NoteRepository noteRepository;
    @InjectMocks
    private NoteService noteService;
    @Test
    public void findAllIsNotNullAndSize(){
        List<NoteEntity> notes = getNotes();
        Mockito.when(noteRepository.findAll()).thenReturn(notes);

        Assertions.assertNotNull(notes, () -> "Элементы отсутствуют!");
        Assertions.assertEquals(2, noteService.findAll().size(), () -> "Количество элементов не совпадает!");
    }
    @Test
    public void isNotNullForCreateNote(){
        NoteEntity noteEntity = new NoteEntity();
        Mockito.when(noteRepository.save(noteEntity)).thenReturn(noteEntity);

        Assertions.assertNotNull(noteService.create(noteEntity), () -> "Элемент не создался!");
    }

    @Test
    public void findByIdIsNotNull(){
        List<NoteEntity> notes = getNotes();
        Long id = 2L;

        Mockito.when(noteRepository.findById(id)).thenReturn(findForId(notes,id));

        Assertions.assertNotNull(noteService.findById(id), () -> "Элемента нету в базе данных!");
    }

    private Optional<NoteEntity> findForId(List<NoteEntity> noteEntities, Long id){
        for (NoteEntity noteEntity : noteEntities) {
            if (noteEntity.getId().equals(id)) return Optional.of(noteEntity);
        }
        return Optional.empty();
    }

    private List<NoteEntity> getNotes(){
        NoteEntity noteEntity1 = new NoteEntity();
        noteEntity1.setId(1L);
        noteEntity1.setTitle("First");

        NoteEntity noteEntity2 = new NoteEntity();
        noteEntity2.setId(2L);
        noteEntity2.setTitle("Second");

        return List.of(noteEntity1, noteEntity2);
    }
}
