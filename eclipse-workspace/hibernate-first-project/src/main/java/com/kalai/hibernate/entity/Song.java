package com.kalai.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "song")
//@NamedQueries({
//    @NamedQuery(name = "getAllId", query = "select s.id from song s"),
//    @NamedQuery(name = "getAllName", query = "select s.name from song s")
//})
//@NamedQuery(name = "getAllId", query = "select s.id from song s")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "singer")
    private String artist;

    public Song() {

    }

    public Song(int id, String name, String artist) {
        this.id = id;
        this.name = name;
        this.artist = artist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {

        return "Song [id=" + id + ", name=" + name + ", artist=" + artist + "]";
    }

}
