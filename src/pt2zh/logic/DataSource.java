package pt2zh.logic;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pt2zh.logic.controllers.AlbumJpaController;

public class DataSource {
     private final AlbumJpaController albumJpaController;
  

    private DataSource() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pt2ZHPU");
        this.albumJpaController = new AlbumJpaController(emf);
    }

    public AlbumJpaController getAlbumJpaController() {
        return albumJpaController;
    }

    private static class DataSourceHandler {

        public static final DataSource INSTANCE = new DataSource();
    }

    public static DataSource getInstance() {
        return DataSourceHandler.INSTANCE;
    }

}
