
package pt2zh.gui;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.TableRowSorter;
import pt2zh.gui.tablemodels.AlbumTableModel;
import pt2zh.gui.tablemodels.GenericTableModel;
import pt2zh.logic.GenericDAO;
import pt2zh.logic.entities.Album;

public class ZHFrame extends JFrame {
    
    private final GenericTableModel<Album, GenericDAO<Album>> albumTableModel;
    private final TableRowSorter<GenericTableModel<Album, GenericDAO<Album>>> albumSorter;

    public ZHFrame() throws HeadlessException {
        
        setTitle("Éles ZH");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(40, 60);
        setSize(700, 300);
        setLayout(new BorderLayout());
        JToolBar jToolBar = new JToolBar();
        
        getContentPane().add(jToolBar, BorderLayout.NORTH);
        JTable albumTable = new JTable();
        
        String[] fi =  {"nev","lakossag","terulte","vars","asd"};
        albumTableModel = new GenericTableModel(new GenericDAO(Album.class), Album.getPropertyNames());
        albumSorter = new TableRowSorter<>(albumTableModel);
        
        albumTableModel.setColumnEditAble(2);
        
        albumTable.setRowSorter(albumSorter);
        albumTable.setModel(albumTableModel);
       
        getContentPane().add(new JScrollPane(albumTable), BorderLayout.CENTER);
      
    }
    
    
    
}
