package com.spotify66_times.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang.builder.ToStringBuilder;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private int id;

    private String title;
    private String artist;
    private String fileDownloadUri;
    private String fileName;


    public Song(String title, String artist, String fileDownloadUri) {
        this.title = title;
        this.artist = artist;
        this.fileDownloadUri = fileDownloadUri;
        this.fileName = fileDownloadUri.substring(fileDownloadUri.lastIndexOf("/") + 1);

    }



    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}