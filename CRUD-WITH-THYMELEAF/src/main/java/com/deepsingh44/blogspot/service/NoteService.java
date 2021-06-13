package com.deepsingh44.blogspot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepsingh44.blogspot.dao.NoteRepository;
import com.deepsingh44.blogspot.model.Note;

@Service
public class NoteService {
	@Autowired
	private NoteRepository noteRepository;

	public int addNote(Note note) {
		int i = 0;
		noteRepository.save(note);
		return i = 1;
	}

	public List<Note> getAllNotes() {
		return noteRepository.findAll();
	}

	public Note getNoteById(int id) {
		return noteRepository.findById(id).get();
	}

	public int updateNote(Note note) {
		int i = 0;
		noteRepository.save(note);
		return i = 1;
	}

	public int delete(Note note) {
		int i = 0;
		noteRepository.delete(note);
		return i = 1;
	}

}
