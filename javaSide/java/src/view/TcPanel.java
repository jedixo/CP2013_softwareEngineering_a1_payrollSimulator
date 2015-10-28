package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.table.JTableHeader;

import controll.EmpList;
import controll.Employee;
import controll.TimeCardList;
import controll.Timecard;

@SuppressWarnings("serial")
public class TcPanel extends JPanel{
	
	private String[] columNames = {"Id:","Employee:","Date:","Hours:"};
	public JTableHeader header;
	public TcPanel(){
		header = new JTableHeader();
	}
	
	public TcPanel(TimeCardList tcList, EmpList empList) {
		viewTable table = new viewTable(columNames);
		
		for (Timecard timecard : tcList) {
			Object[] temp = {timecard.getId(),getEmpName(timecard.getEmpId(),empList),timecard.getDate(),timecard.getHours()};
			table.addRow(temp);
		}
		
		setLayout(new BorderLayout());
		header = table.getTableHeader();
		add(table,BorderLayout.CENTER);
	
	
	
	}

	private String getEmpName(int empId, EmpList empList) {
		String name = "";
		for (Employee emp : empList) {
			
			if (emp.getId() == empId) {
				name = emp.getFirstName() + " " + emp.getLastName();
			}
		}
		return name;

		
	}

}
