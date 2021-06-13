package com.deepsingh44.blogspot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deepsingh44.blogspot.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

}
