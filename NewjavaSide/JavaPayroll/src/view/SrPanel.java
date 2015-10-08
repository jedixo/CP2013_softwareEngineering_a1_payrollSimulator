package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.table.JTableHeader;

import controll.EmpList;
import controll.Employee;
import controll.SalesRecipt;
import controll.SalesRecipts;
import controll.viewTable;

@SuppressWarnings("serial")
public class SrPanel extends JPanel{
	
	private String[] columNames = {"Id:","Employee:","Date:","Amount:"};
	public JTableHeader header;
	
	public SrPanel() {
		header = new JTableHeader();
	}

	public SrPanel(SalesRecipts salesRecipts, EmpList empList) {
		viewTable table = new viewTable(columNames);
		
		for (SalesRecipt sr : salesRecipts) {
			Object[] temp = {sr.getId(),getEmpName(sr.getEmpId(),empList),sr.getDate(),sr.getAmount()};
			table.addRow(temp);
		}
		
		setLayout(new BorderLayout());
		header = table.getTableHeader();
		add(table,BorderLayout.CENTER);
	}

	private Object getEmpName(int empId, EmpList empList) {
		String name = "";
		for (Employee emp : empList) {
			
			if (emp.getId() == empId) {
				name = emp.getFirstName() + " " + emp.getLastName();
			}
		}
		return name;

		
	}

}
