package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import controll.EmpList;
import controll.TimeCardList;
import controll.Timecard;
import controll.viewTable;

@SuppressWarnings("serial")
public class TcPanel extends JPanel{
	
	private String[] columNames = {"Id:","Employee:","Date:","Hours:"};
	
	public TcPanel(){}
	
	public TcPanel(TimeCardList tcList, EmpList empList) {
		viewTable table = new viewTable(columNames);
		
		
		
		for (Timecard timecard : tcList) {
			
			table.addRow(timecard);
			
			
		}
		table.setFillsViewportHeight(true);
		
		
		setLayout(new BorderLayout());
		add(table.getTableHeader(), BorderLayout.PAGE_START);
		
		add(table,BorderLayout.CENTER);
	
	
	
	}

}
