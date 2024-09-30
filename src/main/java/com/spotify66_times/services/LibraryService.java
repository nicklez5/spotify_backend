package com.spotify66_times.services;

import com.spotify66_times.entity.Library;
import com.spotify66_times.entity.Song;
import com.spotify66_times.exception.LibraryException;
import com.spotify66_times.exception.SongException;
import com.spotify66_times.exception.UserException;

public interface LibraryService {

    Library addSong(Song song1, String email) throws SongException, UserException;
    Library deleteSong(Song song1, String email) throws SongException, UserException;
    Library getLibrary(String email) throws LibraryException;
    Library clearLibrary(String email) throws LibraryException;


}
