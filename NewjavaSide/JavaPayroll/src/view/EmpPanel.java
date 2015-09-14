package view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controll.Employee;

public class EmpPanel extends JPanel{

	public EmpPanel(ArrayList<Employee> empList) {
		this.setLayout(new GridLayout(0,8,12,2));
		this.add(new JLabel("id:"));
		this.add(new JLabel("First Name:"));
		this.add(new JLabel("Last Name:"));
		this.add(new JLabel("Address:"));
		this.add(new JLabel("pay Type:"));
		this.add(new JLabel("Pay Delivery:"));
		this.add(new JLabel("Union:"));
		this.add(new JLabel("Salary:"));
		for (Employee employee : empList) {
			this.add(new JLabel(String.valueOf(employee.getId())));
			this.add(new JLabel(employee.getFirstName()));
			this.add(new JLabel(employee.getLastName()));
			this.add(new JLabel(employee.getAddress()));
			this.add(new JLabel(String.valueOf(employee.getPayType())));
			this.add(new JLabel(String.valueOf(employee.getPayDelivery())));
			this.add(new JLabel(employee.getUnion()));
			this.add(new JLabel(String.valueOf(employee.getSalary())));
			
		}	
	}
	

}
