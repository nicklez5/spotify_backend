package com.spotify66_times.services;

import com.spotify66_times.entity.Library;
import com.spotify66_times.entity.Song;
import com.spotify66_times.entity.User;


import com.spotify66_times.exception.LibraryException;
import com.spotify66_times.exception.SongException;
import com.spotify66_times.exception.UserException;
import com.spotify66_times.repo.LibraryRepo;

import com.spotify66_times.repo.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class LibraryImpl implements LibraryService {


    private final UserRepository userRepo;

    private final LibraryRepo libraryRepo;


    
    public LibraryImpl(UserRepository userRepo, LibraryRepo libraryRepo)  {
        this.userRepo = userRepo;
        this.libraryRepo = libraryRepo;
    }


    @Transactional
    public Library addSong(Song song1,String email) throws SongException, UserException {

        User user1 = userRepo.findByEmail(email).get();
        if (song1 != null) {
            if (user1.getLibrary() != null) {
                user1.getLibrary().addSong(song1, email);
                userRepo.save(user1);
                return user1.getLibrary();
            }

        } else {
            throw new SongException("File corrupted");
        }
        return null;
    }

    @Transactional
    public Library deleteSong(Song song1, String email) throws SongException, UserException {
        User user1 = userRepo.findByEmail(email).get();
        if (song1 != null) {
            if (user1.getLibrary() != null) {
                user1.getLibrary().removeSong(song1);
                userRepo.save(user1);
                return user1.getLibrary();
            } else {
                throw new SongException("Library corrupted");
            }

        } else {
            throw new SongException("song does not exist");
        }


    }



    public Library getLibrary(String email) throws LibraryException {
        User user1 = userRepo.findByEmail(email).get();
        if(user1.getLibrary() == null){
            throw new LibraryException("Library is null");
        }else{
            return user1.getLibrary();
        }
    }

    @Transactional
    public Library clearLibrary(String email) throws LibraryException {
        User user1 = userRepo.findByEmail(email).get();
            if(user1.getLibrary() == null) {
                throw new LibraryException("Library is null");
            }else {
                Library library = user1.getLibrary();
                libraryRepo.delete(library);
                return user1.getLibrary();

            }
    }

}
