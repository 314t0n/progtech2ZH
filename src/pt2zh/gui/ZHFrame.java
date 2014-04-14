
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

public class ZHFrame extends JFrame {
    
    private final AlbumTableModel albumTableModel;
    private final TableRowSorter<AlbumTableModel> albumSorter;

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
        albumTableModel = new AlbumTableModel();
        albumSorter = new TableRowSorter<>(albumTableModel);
        albumTable.setRowSorter(albumSorter);
        albumTable.setModel(albumTableModel);
       
        getContentPane().add(new JScrollPane(albumTable), BorderLayout.CENTER);
      
    }
    
    
    
}
