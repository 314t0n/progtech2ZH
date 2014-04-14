package pt2zh;

import java.awt.EventQueue;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pt2zh.gui.ZHFrame;
import pt2zh.logic.controllers.AlbumJpaController;
import pt2zh.logic.controllers.ArtistJpaController;
import pt2zh.logic.entities.Album;
import pt2zh.logic.entities.Artist;

public class Main {

    private static final boolean ISFIRST = false;

    public static void main(String[] args) {
        
        if (ISFIRST) {
            EntityManagerFactory emf =
                    Persistence.createEntityManagerFactory(
                    "pt2ZHPU");
            EntityManager em = emf.createEntityManager();
            Artist artist1 = new Artist();
            artist1.setName("Illes");
            Artist artist2 = new Artist();
            artist2.setName("Omega");
            Artist artist3 = new Artist();
            artist3.setName("Metro");
            Artist artist4 = new Artist();
            artist4.setName("Fonograf");
            Artist artist5 = new Artist();
            artist5.setName("Skorpio");
            Artist artist6 = new Artist();
            artist6.setName("Napalm Death");
            Artist artist7 = new Artist();
            artist7.setName("Meshuggah");
            Artist artist8 = new Artist();
            artist8.setName("Dolly Roll");
            
            ArtistJpaController artistJpaController = new ArtistJpaController(emf);
            artistJpaController.create(artist1);
            artistJpaController.create(artist2);
            artistJpaController.create(artist3);
            artistJpaController.create(artist4);
            artistJpaController.create(artist5);
            artistJpaController.create(artist6);
            artistJpaController.create(artist7);
            artistJpaController.create(artist8);
            
            Album album1 = new Album();
            album1.setArtist(artist1);
            album1.setLengthOfAlbum(70);
            album1.setTitle("Illes");
            album1.setYear(1962);
            
            Album album2 = new Album();
            album2.setArtist(artist2);
            album2.setLengthOfAlbum(50);
            album2.setTitle("Red Star");
            album2.setYear(1961);
            
            Album album3 = new Album();
            album3.setArtist(artist3);
            album3.setLengthOfAlbum(30);
            album3.setTitle("");
            album3.setYear(1971);
            
            Album album4 = new Album();
            album4.setArtist(artist7);
            album4.setLengthOfAlbum(73);
            album4.setTitle("Nothing");
            album4.setYear(2001);
            
            Album album5 = new Album();
            album5.setArtist(artist8);
            album5.setLengthOfAlbum(70);
            album5.setTitle("Dolly Roll");
            album5.setYear(1982);
            
            AlbumJpaController albumJpaController = new AlbumJpaController(emf);
            albumJpaController.create(album1);
            albumJpaController.create(album2);
            albumJpaController.create(album3);
            albumJpaController.create(album4);
            albumJpaController.create(album5);
            em.close();
        }
        
         EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ZHFrame().setVisible(true);
            }
        });
    }
}
