package com.radionJavaJunior.Notes.contrioller;

import com.radionJavaJunior.Notes.service.NoteService;
import com.radionJavaJunior.Notes.entity.NoteEntity;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@Controller
@AllArgsConstructor
public class NoteController {

    private NoteService noteService;

    @GetMapping("/home")
    public String home(Model model){
        Iterable<NoteEntity> noteEntityList = noteService.findAll();
        model.addAttribute("notes", noteEntityList);
        return "TTT";
    }

    @PostMapping("/home")
    public String createNote(@Valid NoteEntity noteEntity, Model model){
        try {
            noteService.create(noteEntity);
            return "redirect:/home";
        }catch (Exception e){
            model.addAttribute("exception", "Такая запись уже есть");
            return home(model);
        }
    }

    @GetMapping("/info/{id}")
    public String infoNote(@PathVariable("id") Long id, Model model){
        model.addAttribute("noteInfo", noteService.findById(id));
        return "info_Note";
    }


    @PostMapping("/up")
    public String update(NoteEntity noteEntity){
        noteService.update(noteEntity, Instant.now());
        return "redirect:/home";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        noteService.delete(id);
        return "redirect:/home";
    }
}
