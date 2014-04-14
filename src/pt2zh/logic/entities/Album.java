/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt2zh.logic.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author darkdawn
 */
@Entity
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    private String title;
    private Integer lengthOfAlbum;
    private Integer yearOfAlbum;
    @OneToOne
    private Artist artist;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLengthOfAlbum() {
        return lengthOfAlbum;
    }

    public void setLengthOfAlbum(Integer lengthOfAlbum) {
        this.lengthOfAlbum = lengthOfAlbum;
    }

    public Integer getYear() {
        return yearOfAlbum;
    }

    public void setYear(Integer year) {
        this.yearOfAlbum = year;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Album{" + "id=" + id + ", title=" + title + ", lengthOfAlbum=" + lengthOfAlbum + ", year=" + yearOfAlbum + ", artist=" + artist + '}';
    }
}
