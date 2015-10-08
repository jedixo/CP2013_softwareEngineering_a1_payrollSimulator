package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import controll.Database;
import controll.EmpList;
import controll.Employee;

@SuppressWarnings("serial")
public class ModEmployee extends JDialog {
	
	private JTextField address, union, employees;
	private EmpList empList;
	private Employee employee;
	private JSpinner salary, commisionRate;
	private JComboBox<String> payType, payDelivery;
	
	private List<String> payTypes = Arrays.asList("Hourly rate", "Monthly salary", "Comission");
	private List<String> deliveryTypes = Arrays.asList("mail", "held", "direct deposite");


	public ModEmployee(final EmpList empList, final Database empDatabase, final EmpList empList2) {
	this.empList = empList;
	JPanel modPanel = new JPanel();
	modPanel.setLayout(new GridLayout(0,2,2,2));
	modPanel.add(new JLabel("Employee:"));
	employees = new JTextField();
	for (Employee employee : empList) {
		String first = employee.getFirstName();
		String last = employee.getLastName();
		String name = first +" "+ last;
		employees.setText(name);;
	}
	employees.setEnabled(false);
	modPanel.add(employees);
	modPanel.add(new JLabel("Address:"));
	address = new JTextField();
	modPanel.add(address);
	modPanel.add(new JLabel("Pay Type:"));
	payType = new JComboBox<String>();
	for (String type : payTypes) {
		payType.addItem(type);
	}
	payType.addItemListener(new ItemListener() {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getItem().toString().equals("Comission")) {
				commisionRate(true);
			}else {
				commisionRate(false);
			}
			
		}

		
	});
	modPanel.add(payType);
	modPanel.add(new JLabel("Pay Delivery:"));
	payDelivery = new JComboBox<String>();
	for (String delivery : deliveryTypes) {
		payDelivery.addItem(delivery);
	}
	modPanel.add(payDelivery);
	modPanel.add(new JLabel("Union:"));
	union = new JTextField();
	modPanel.add(union);
	modPanel.add(new JLabel("Salary:"));
	salary = new JSpinner();
	salary.setModel(new SpinnerNumberModel(0,0,10000,1));
	modPanel.add(salary);
	modPanel.add(new JLabel("Commision Rate:"));
	commisionRate = new JSpinner();
	commisionRate.setEnabled(false);
	commisionRate.setModel(new SpinnerNumberModel(0,0,100,1));
	modPanel.add(commisionRate);
	JPanel actionPanel = new JPanel();
	actionPanel.setLayout(new GridLayout(0,2));
	JButton addButton = new JButton("Update");
	addButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			employee.setAddress(address.getText());
			String type = (String) payType.getSelectedItem();
			for (int i = 0; i < payTypes.size(); i++) {
				if (payTypes.get(i).equals(type)) {
					employee.setPayType(i);
				}
			}
			type = (String) payDelivery.getSelectedItem();
			for (int i = 0; i < deliveryTypes.size(); i++) {
				if (deliveryTypes.get(i).equals(type)) {
					employee.setPayDelivery(i);
				}
			}
			employee.setUnion(union.getText());
			employee.setSalary((int) salary.getValue());
			employee.setCommissionRate((int) ((float)commisionRate.getValue()));
			empDatabase.updateEmp(employee);
			close();
		}
	});
	JButton deleteButton = new JButton("Delete");
	deleteButton.setForeground(new Color(255,0,0));
	deleteButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			for (int i = 0; i < empList2.size(); i++) {
				if (empList2.get(i).getId() == employee.getId()) {
					int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + employee.getFirstName() + " " + employee.getLastName() + " permanently?", 
							"Are you sure?", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
							empDatabase.deleteEmp(employee.getId());
							empList2.remove(i);
							
					}
					
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
	setResizable(false);
	setTitle("Edit Employee");
	pack();
	setModal(true);
	setVisible(true);
	}
	
	private void getPreviousDetails(String string) {
		String[] nameStr = string.split("\\s+");
		
		for (Employee employee : empList) {
			if (employee.getFirstName().equals(nameStr[0]) && employee.getLastName().equals(nameStr[1])) {
				this.employee = employee;
				address.setText(employee.getAddress());
				payType.setSelectedIndex(employee.getPayType());
				payDelivery.setSelectedIndex(employee.getPayDelivery());
				union.setText(employee.getUnion());
				salary.setValue((Integer)employee.getSalary());	
				commisionRate.setValue((Float)employee.getCommisionRateFloat());
			}
		}
		
	}
	
	private void commisionRate(boolean isActive) {
		commisionRate.setEnabled(isActive);
	}
	
	private void close() {
		this.dispose();
		
	}

}