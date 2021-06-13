package com.deepsingh44.blogspot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.deepsingh44.blogspot.model.Note;
import com.deepsingh44.blogspot.service.NoteService;

@Controller
public class NoteController {

	@Autowired
	private NoteService noteService;

	@GetMapping("/")
	public String mainPage() {
		return "index";
	}

	@GetMapping("/addnote")
	public String addNotePage(Note note) {
		return "addnote";
	}

	@PostMapping("/note")
	public String addNote(Note note, Model model) {
		if (noteService.addNote(note) > 0) {
			model.addAttribute("msg", "Succefully Note Added");
		} else {
			model.addAttribute("msg", "Note Added Failed");
		}
		return "addnote";
	}

	@GetMapping("/list")
	public String getAllNotes(Model model) {
		model.addAttribute("notes", noteService.getAllNotes());
		return "notelist";
	}

	@GetMapping("/edit/{id}")
	public String updateForm(@PathVariable int id, Model model) {
		model.addAttribute("note", noteService.getNoteById(id));
		return "update";
	}

	@PostMapping("/updatenote")
	public String updateNote(Note note) {
		noteService.updateNote(note);
		return "redirect:/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteNote(@PathVariable int id) {
		Note note=noteService.getNoteById(id);
		noteService.delete(note);
		return "redirect:/list";
	}

}
