package view;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import controll.Database;
import controll.Employee;

@SuppressWarnings("serial")
public class ViewEmployees extends JFrame{
	private EmpPanel empPanel;
	private ArrayList<Employee> empList;
	private Database empDatabase;
	private JButton addButton;
	private JButton modButton;
	private JScrollPane ScrollPane;
	
	public ViewEmployees(ArrayList<Employee> empList, Database empDatabase) {
		this.empList = empList;
		this.empDatabase = empDatabase;
		
		empPanel = new EmpPanel(empList);
		addButton = new JButton("Add");
		modButton = new JButton("Modify");
		empPanel.add(addButton);
		empPanel.add(modButton);
		ScrollPane = new JScrollPane(empPanel);
		this.add(ScrollPane, BorderLayout.CENTER);
		update();
		setPreferredSize(new Dimension(905, 561));
		pack();
		setTitle("employees");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	}

	private void update() {
		this.remove(ScrollPane);
		this.remove(addButton);
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
		ScrollPane = new JScrollPane(empPanel);
		this.add(ScrollPane, BorderLayout.CENTER);
		this.setVisible(true);
		
	}

}
