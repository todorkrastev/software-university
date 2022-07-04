package com.spotifyplaylist.model.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class User extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "users_songs",
            joinColumns = @JoinColumn(name = "fk_user"),
            inverseJoinColumns = @JoinColumn(name = "fk_song"))
    private Set<Song> playlist;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<Song> getPlaylist() {
        return playlist;
    }

    public User setPlaylist(Set<Song> playlist) {
        this.playlist = playlist;
        return this;
    }

    public boolean addSongToPlaylist(Song song) {
        if (this.getPlaylist().stream().noneMatch(s -> s.getId().equals(song.getId()))) {
            this.getPlaylist().add(song);
            song.getUsers().add(this);
            return true;
        }

        return false;
    }

    public boolean removeSongFromPlaylist(Song song) {
        if (this.getPlaylist().stream().anyMatch(s -> s.getId().equals(song.getId()))) {
            this.playlist.remove(song);
            song.getUsers().remove(this);
            return true;
        }

        return false;
    }

    public boolean deleteAllSongFromPlaylist() {
        if (this.getPlaylist().size() > 0) {
            this.getPlaylist()
                    .forEach(song -> song.getUsers().removeIf(u -> u.getId().equals(this.getId())));
            this.getPlaylist().clear();
            return true;
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId().equals(user.getId())
                && getUsername().equals(user.getUsername())
                && getPassword().equals(user.getPassword())
                && getEmail().equals(user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getPassword(), getEmail());
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + getUsername() + '\'' +
                ", email='" + getEmail() + '\'' +
                '}';
    }
}
