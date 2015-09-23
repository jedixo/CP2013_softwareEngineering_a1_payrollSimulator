package view;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controll.Database;
import controll.EmpList;

@SuppressWarnings("serial")
public class ViewEmployees extends JFrame{
	private EmpList empList;
	
	private EmpPanel empPanel;
	private JButton addButton;
	private JButton modButton;
	private JScrollPane ScrollPane;
	
	public ViewEmployees(final EmpList empList, final Database empDatabase) {
		this.empList = empList;
		
		empPanel = new EmpPanel(empList);
		ScrollPane = new JScrollPane(empPanel);
		addButton = new JButton("Add");
		modButton = new JButton("Modify");
		empPanel.add(addButton);
		empPanel.add(modButton);
		add(ScrollPane, BorderLayout.CENTER);
		
		
		JPanel buttonPanel = new JPanel();
			
			
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
		
		buttonPanel.add(addButton);
		buttonPanel.add(modButton);
		add(buttonPanel, BorderLayout.SOUTH);
		
		update();
		
		setPreferredSize(new Dimension(800, 600));
		setResizable(false);
		pack();
		setTitle("employees");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}

	private void update() {
		remove(ScrollPane);
		
		empPanel = new EmpPanel(empList);
		ScrollPane = new JScrollPane(empPanel);
	
		add(ScrollPane, BorderLayout.CENTER);

		setVisible(true);
		
	}

}
