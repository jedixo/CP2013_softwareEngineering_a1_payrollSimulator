package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controll.Database;
import controll.Employee;

@SuppressWarnings("serial")
public class ModEmployee extends JDialog {
	
	private JComboBox<String> employees;
	private JTextField address, payType, payDelivery, union, salary;
	private ArrayList<Employee> empList;
	private Employee employee;

	public ModEmployee(final ArrayList<Employee> empList, final Database empDatabase) {
	this.empList = empList;
	JPanel modPanel = new JPanel();
	modPanel.setLayout(new GridLayout(0,2,2,2));
	modPanel.add(new JLabel("Employee:"));
	employees = new JComboBox<>();
	for (Employee employee : empList) {
		String first = employee.getFirstName();
		String last = employee.getLastName();
		String name = first +" "+ last;
		employees.addItem(name);
	}
	employees.addItemListener(new ItemListener() {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				
				getPreviousDetails(e.getItem().toString());
			}
			
		}


	});
	
	modPanel.add(employees);
	modPanel.add(new JLabel("Address:"));
	address = new JTextField();
	modPanel.add(address);
	modPanel.add(new JLabel("Pay Type:"));
	payType = new JTextField();
	modPanel.add(payType);
	modPanel.add(new JLabel("Pay Delivery:"));
	payDelivery = new JTextField();
	modPanel.add(payDelivery);
	modPanel.add(new JLabel("Union:"));
	union = new JTextField();
	modPanel.add(union);
	modPanel.add(new JLabel("Salary:"));
	salary = new JTextField();
	modPanel.add(salary);
	JPanel actionPanel = new JPanel();
	actionPanel.setLayout(new GridLayout(0,2));
	JButton addButton = new JButton("Update");
	addButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			employee.setAddress(address.getText());
			employee.setPayType(Integer.parseInt(payType.getText()));
			employee.setPayDelivery(Integer.parseInt(payDelivery.getText()));
			employee.setUnion(union.getText());
			employee.setSalary(Integer.parseInt(salary.getText()));
			empDatabase.updateEmp(employee);
			close();
		}
	});
	JButton deleteButton = new JButton("Delete");
	deleteButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < empList.size(); i++) {
				if (empList.get(i).getId() == employee.getId()) {
					empList.remove(i);
					empDatabase.deleteEmp(employee.getId());
				}
			}
			
			close();
		}
	});
	JButton closeButton = new JButton("Cancel");
	closeButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			close();
			
		}
	});
	actionPanel.add(addButton);
	actionPanel.add(deleteButton);
	modPanel.add(actionPanel);
	modPanel.add(closeButton);
	getPreviousDetails(empList.get(0).getFirstName() + " " + empList.get(0).getLastName());
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	add(modPanel);
	setLocationRelativeTo(null);
	setPreferredSize(new Dimension(400, 300));
	setTitle("Edit Employee");
	pack();
	setModal(true);
	setVisible(true);
	}
	
	private void getPreviousDetails(String string) {
		String[] nameStr = string.split("\\s+");
		System.out.println(nameStr[0] + nameStr[1]);
		
		for (Employee employee : empList) {
			if (employee.getFirstName().equals(nameStr[0]) && employee.getLastName().equals(nameStr[1])) {
				this.employee = employee;
				address.setText(employee.getAddress());
				payType.setText(employee.getPayType() + "");
				payDelivery.setText(employee.getPayDelivery() + "");
				union.setText(employee.getUnion());
				salary.setText(employee.getSalary() + "");				
			}
		}
		
	}
	private void close() {
		this.dispose();
		
	}

}
