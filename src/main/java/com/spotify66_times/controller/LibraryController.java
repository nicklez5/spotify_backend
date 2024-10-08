package com.spotify66_times.controller;


import com.spotify66_times.entity.Library;

import com.spotify66_times.exception.LibraryException;
import com.spotify66_times.exception.SongException;
import com.spotify66_times.exception.UserException;
import com.spotify66_times.services.LibraryService;
import com.spotify66_times.services.SongService;

import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/library")
public class LibraryController {

    private final LibraryService libraryService;
    private final SongService songService;
    public LibraryController(LibraryService libraryService, SongService songService) {
        this.libraryService = libraryService;
        this.songService = songService;
    }




    @Transactional
    @PostMapping("/addSong/{id}")
    public ResponseEntity<Library> addSong(@RequestParam("title") String title, @RequestParam("email") String email) throws SongException, UserException {
        Library lib1 = libraryService.addSong(this.songService.getSong(title,email), email);
        return ResponseEntity.ok(lib1);

    }
    @Transactional
    @DeleteMapping("/deleteSong/{id}")
    public ResponseEntity<Library> deleteSong(@PathVariable("id") int id, @RequestParam("email") String email) throws SongException, UserException {
        Library lib1 = libraryService.deleteSong(this.songService.getSong(id,email), email);
        return ResponseEntity.ok(lib1);


    }

    @Transactional
    @GetMapping("/info")
    public ResponseEntity<Library> getLibrary(@RequestParam("email") String email) throws  LibraryException {
        Library lib1 = libraryService.getLibrary(email);
        return ResponseEntity.ok(lib1);
    }
    @Transactional
    @DeleteMapping("/clear")
    public ResponseEntity<Library> clearLibrary(@RequestParam("email") String email) throws  LibraryException {
        Library lib1 =  libraryService.clearLibrary(email);
        return ResponseEntity.ok(lib1);
    }

}

