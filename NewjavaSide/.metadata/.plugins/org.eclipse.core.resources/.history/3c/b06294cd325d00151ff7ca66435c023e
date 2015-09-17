package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import controll.Database;
import controll.Employee;

@SuppressWarnings("serial")
public class ViewEmployees extends JFrame{
	private EmpPanel empPanel;
	private ArrayList<Employee> empList;
	private Database empDatabase;
	private JButton addButton;
	private JButton deleteButton;
	private JButton modButton;
	
	public ViewEmployees(ArrayList<Employee> empList, Database empDatabase) {
		this.empList = empList;
		this.empDatabase = empDatabase;
		
		empPanel = new EmpPanel(empList);
		addButton = new JButton("Add");
		modButton = new JButton("Modify");
		deleteButton = new JButton("Delete");
		empPanel.add(addButton);
		empPanel.add(modButton);
		empPanel.add(deleteButton);
		this.add(empPanel);
		update();

		pack();
		setTitle("employees");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	}

	private void update() {
		this.remove(empPanel);
		this.remove(addButton);
		this.remove(deleteButton);
		this.remove(modButton);
		empPanel = new EmpPanel(empList);
		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddEmployee(empList, empDatabase);
				update();	
			}
		});
		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			new DelEmployee(empList, empDatabase);
				update();	
			}
		});
		modButton = new JButton("Modify");
		modButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ModEmployee(empList, empDatabase);
				update();	
			}
		});
		
		empPanel.add(addButton);
		empPanel.add(modButton);
		empPanel.add(deleteButton);
		this.add(empPanel);
		this.setVisible(true);
		
	}

}
