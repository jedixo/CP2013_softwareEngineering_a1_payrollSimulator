package controll;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class viewTable extends JTable{
	
	private static final long serialVersionUID = 1L;


	public viewTable(String[] columNames) {
		super(new DefaultTableModel(columNames, 0));
		setFillsViewportHeight(true);
		setAutoCreateRowSorter(true);
		
		}

	public boolean isCellEditable(int row, int column) {                
            return false;  
    }
	
	public void addRow(Object[] ary) {
		DefaultTableModel model = (DefaultTableModel) getModel();
		model.addRow(ary);
		
	}

}
