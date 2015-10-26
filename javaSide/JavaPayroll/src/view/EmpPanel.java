package view;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;




import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import controll.Database;
import controll.EmpList;
import controll.Employee;
import controll.SalesRecipt;
import controll.SalesRecipts;
import controll.TimeCardList;
import controll.Timecard;
import controll.viewTable;

@SuppressWarnings("serial")
public class EmpPanel extends JPanel{
	
	private List<String> payTypes = Arrays.asList("Hourly rate", "Monthly salary", "Comission");
	private List<String> deliveryTypes = Arrays.asList("mail", "held", "direct deposite");
	private String[] columNames = {"Id:","First Name:","Last Name:","Address:",
			"Pay Type:","Pay Delivery:","Union:","Rate:","Salary:","Commision Rate:"};
	public JTableHeader header;
	private int rowSelected = -1;
	private int empSelected;
	
	public EmpPanel(final EmpList empList, final TimeCardList tcList, final Database database, final SalesRecipts salesRecipts) {
		
		final viewTable table = new viewTable(columNames);
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				JTable target = (JTable)e.getSource();
				int row = target.getSelectedRow();
				rowSelected = row;
				if (row != -1) {
					int empId = (int)table.getModel().getValueAt(row, 0);
					empSelected = empId;
					if (e.getClickCount() == 2) {
						TimeCardList focusedEmp = new TimeCardList();
						EmpList focusedEmpList = new EmpList();
						SalesRecipts focusedSrList = new SalesRecipts();
						for (Employee emp : empList) {
							if (emp.getId() == empId) {
								focusedEmpList.add(emp);
							}
						}
						for (Timecard tc : tcList){
							if (tc.getEmpId() == empId) {
								focusedEmp.add(tc);
							}
						}
						for (SalesRecipt sr : salesRecipts) {
							if (sr.getEmpId() == empId) {
								focusedSrList.add(sr);
							}
							
						}
						
						if (focusedEmpList.get(0).getPayType() == 0) {
							new ViewFrame(focusedEmp, database, focusedEmpList, tcList);
						}else if (focusedEmpList.get(0).getPayType() == 2) {
							new ViewFrame(focusedSrList, database, focusedEmpList, salesRecipts);
						}
					}
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
		});
		
		for (Employee emp : empList) {
			
			if (emp.getPayType()== 1) {
				Object[] temp = {emp.getId(),emp.firstName,emp.lastName,emp.getAddress(),getPayTypeString(emp.getPayType()),getPayDelevieryTypeString(emp.getPayDelivery())
					,emp.getUnion(),null,emp.getSalary(),null};
				table.addRow(temp);
			} else if (emp.getPayType() == 0) {
				Object[] temp = {emp.getId(),emp.firstName,emp.lastName,emp.getAddress(),getPayTypeString(emp.getPayType()),getPayDelevieryTypeString(emp.getPayDelivery())
						,emp.getUnion(),emp.getSalary(),null,null};
					table.addRow(temp);
			} else {
				Object[] temp = {emp.getId(),emp.firstName,emp.lastName,emp.getAddress(),getPayTypeString(emp.getPayType()),getPayDelevieryTypeString(emp.getPayDelivery())
						,emp.getUnion(),null,null,emp.getCommissionRateString()};
					table.addRow(temp);
			}
		}
		setLayout(new BorderLayout());
		header = table.getTableHeader();
		
		add(table,BorderLayout.CENTER);
	}


	public EmpPanel() {
		header = new JTableHeader();
	}


	private String getPayDelevieryTypeString(int payDelivery) {
		return deliveryTypes.get(payDelivery);
	}


	private String getPayTypeString(int payType) {
		return payTypes.get(payType);
	}
	
	public int getRowSelected() {
		return rowSelected;
	}
	public int getEmpSelected() {
		return empSelected;
	}
	
	
	

}
