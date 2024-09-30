package com.spotify66_times.services;


import com.spotify66_times.entity.Playlist;


import com.spotify66_times.entity.Song;
import com.spotify66_times.exception.SongException;
import com.spotify66_times.exception.UserException;
import jakarta.transaction.Transactional;

import java.util.List;

public interface PlaylistService {

    String getPlaylistName(String email) throws UserException;
    @Transactional
    Playlist addSong(int song_id, String email) throws Exception;
    List<Song> getSongs(String email) throws UserException;


    @Transactional
    Playlist removeSong(int song_id, String email) throws SongException, UserException;

    String renamePlaylist(String email, String playlist_name) throws UserException;
    Playlist clearPlaylist(String email) throws UserException;


}
