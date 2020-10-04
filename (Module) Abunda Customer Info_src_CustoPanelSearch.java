import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class CustoPanelSearch extends JPanel implements KeyListener{
    JLabel lblSearch;
    JTextField txtSearch;

    public CustoPanelSearch() {
        lblSearch=new JLabel("Search");
        txtSearch=new JTextField(13);
        setLayout(new FlowLayout(FlowLayout.LEFT,2,1));
        add(lblSearch);
        add(txtSearch);
        txtSearch.addKeyListener(this);
    }

    public void keyTyped(KeyEvent e) { }
    public void keyPressed(KeyEvent e) { }

    public void keyReleased(KeyEvent e) {
        if(e.getSource().equals(txtSearch)){
            String search=txtSearch.getText();
            CustoPanelTable.tblSort=new TableRowSorter(CustoPanelTable.modelCustomer);
            CustoPanelTable.tblCustomer.setRowSorter(CustoPanelTable.tblSort);
            CustoPanelTable.tblSort.setRowFilter(RowFilter.regexFilter(search, 0,1));
        }
    }
}
