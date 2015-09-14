package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controll.Database;
import controll.Employee;

@SuppressWarnings("serial")
public class AddEmployee extends JDialog {
	private JTextField firstName, lastName, address, payType, payDelivery, union, salary;

	
	public AddEmployee(final ArrayList<Employee> empList, final Database empDatabase) {
		JPanel addPanel = new JPanel();
		addPanel.setLayout(new GridLayout(0,2,2,2));
		addPanel.add(new JLabel("First Name:"));
		firstName = new JTextField();
		addPanel.add(firstName);
		addPanel.add(new JLabel("Last Name:"));
		lastName = new JTextField();
		addPanel.add(lastName);
		addPanel.add(new JLabel("Address:"));
		address = new JTextField();
		addPanel.add(address);
		addPanel.add(new JLabel("Pay Type:"));
		payType = new JTextField();
		addPanel.add(payType);
		addPanel.add(new JLabel("Pay Delivery:"));
		payDelivery = new JTextField();
		addPanel.add(payDelivery);
		addPanel.add(new JLabel("Union:"));
		union = new JTextField();
		addPanel.add(union);
		addPanel.add(new JLabel("Salary:"));
		salary = new JTextField();
		addPanel.add(salary);
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Employee employee = new Employee(firstName.getText(), lastName.getText());
				employee.setAddress(address.getText());
				employee.setPayType(Integer.parseInt(payType.getText()));
				employee.setPayDelivery(Integer.parseInt(payDelivery.getText()));
				employee.setUnion(union.getText());
				employee.setSalary(Integer.parseInt(salary.getText()));
				employee.setId(empList.get(empList.size() - 1).getId() + 1);
				empList.add(employee);
				empDatabase.addEmpData(employee);
				
				//System.out.println(empList.get(empList.size() - 1).getFirstName());
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

		
		addPanel.add(addButton);
		addPanel.add(closeButton);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		add(addPanel);
		setLocationRelativeTo(null);
		setPreferredSize(new Dimension(400, 300));
		setTitle("Add Employee");
		
		pack();
		setModal(true);
		setVisible(true);
	}
	private void close() {
		this.dispose();
		
	}

}