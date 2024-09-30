package com.spotify66_times.repo;

import com.spotify66_times.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface SongRepo extends JpaRepository<Song,Integer> {
    public Optional<Song>  findByTitle(String title);
    
}
