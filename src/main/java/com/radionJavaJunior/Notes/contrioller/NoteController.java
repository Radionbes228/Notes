package com.radionJavaJunior.Notes.contrioller;

import com.radionJavaJunior.Notes.service.NoteService;
import com.radionJavaJunior.Notes.entity.NoteEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/note")
public class NoteController {

    private NoteService noteService;

    @GetMapping("/homePageGet")
    public String home(Model model){
        List<NoteEntity> noteEntityList = noteService.findAll();
        model.addAttribute("notes", noteEntityList);
        return "TTT";
    }

    @PostMapping("/homePagePost")
    public String createNote(NoteEntity noteEntity){
        noteService.create(noteEntity);
        return "redirect:/note/homePageGet";
    }


    @GetMapping("/info/{id}")
    public String infoNote(@PathVariable("id") Long id, Model model){
        model.addAttribute("noteInfo", noteService.findById(id));
        return "info_Note";
    }


    @PostMapping("/up")
    public String update(NoteEntity noteEntity){
        noteService.update(noteEntity, Instant.now());
        return "redirect:/note/homePageGet";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        noteService.delete(id);
        return "redirect:/note/homePageGet";
    }

}
