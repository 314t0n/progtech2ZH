package pt2zh.gui.tablemodels;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pt2zh.logic.DataSource;
import pt2zh.logic.entities.Album;

public class AlbumTableModel extends AbstractTableModel {

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 1) {
            return true;
        }
        return super.isCellEditable(rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Long id = (long) getValueAt(rowIndex, 0);
        System.out.println(id);

        if (columnIndex == 1) {
            try {
                Album album = items.get(rowIndex);
                System.out.println(album);
                album.setTitle((String) aValue);
                dataSource.getAlbumJpaController().edit(album);
                fireTableDataChanged();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
    private final String[] fieldNames = {
        "id", "cím", "év", "hossz", "előadó"
    };

    @Override
    public String getColumnName(int column) {
        return fieldNames[column];
    }
    private DataSource dataSource;
    private List<Album> items;

    public AlbumTableModel() {
        items = new ArrayList();
        try {
            dataSource = DataSource.getInstance();
            items = DataSource.getInstance().getAlbumJpaController().findAlbumEntities();
            System.out.println(items);
        } catch (ExceptionInInitializerError ex) {
            System.out.println("Driver beállítás ...");
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public int getRowCount() {
        return dataSource.getAlbumJpaController().getAlbumCount();
    }

    @Override
    public int getColumnCount() {
        return fieldNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Album album = items.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return album.getId();
            case 1:
                return album.getTitle();
            case 2:
                return album.getYear();
            case 3:
                return album.getLengthOfAlbum();
            case 4:
                return album.getArtist().getName();
            default:
                return null;
        }
    }
}
