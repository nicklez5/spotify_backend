package com.spotify66_times.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spotify66_times.entity.Playlist;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepo extends JpaRepository<Playlist, Integer> {
    Playlist findByPlaylistName(String playlist_name);
}
