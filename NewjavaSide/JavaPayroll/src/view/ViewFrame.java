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
import controll.TimeCardList;

@SuppressWarnings("serial")
public class ViewFrame extends JFrame{
	private EmpList empList;
	private TimeCardList tcList;
	private TcPanel tcPanel;
	private int type;
	private EmpPanel empPanel;
	private JButton addButton, modButton;
	private JScrollPane ScrollPane;
	private Database database;
	private JPanel buttonPanel;
	
	public ViewFrame(final EmpList empList, final Database database) {
		type = 0;
		this.database = database;
		this.empList = empList;
		empPanel = new EmpPanel(empList);
		ScrollPane = new JScrollPane(empPanel);
		buttonPanel = new JPanel();
		add(buttonPanel);
		add(ScrollPane, BorderLayout.CENTER);
		
		initaliseCommonComponents();
		
	}

	public ViewFrame(TimeCardList timeCardList, Database database, EmpList empList) {
		type = 1;
		this.empList = empList;
		this.database = database;
		this.tcList = timeCardList;
		tcPanel = new TcPanel();
		ScrollPane = new JScrollPane(tcPanel);
		buttonPanel = new JPanel();
		add(buttonPanel);
		add(ScrollPane, BorderLayout.CENTER);
	
		initaliseCommonComponents();
	}

	private void initaliseCommonComponents() {
		remove(ScrollPane);
		remove(buttonPanel);
		
		JPanel buttonPanel = new JPanel();

		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				if (type == 0) {
					new AddEmployee(empList, database);
				} else {
					new AddTimeCard(tcList, database, empList);
				}
				initaliseCommonComponents();	
			}
		});
		buttonPanel.add(addButton);
		if (type == 0) {
			modButton = new JButton("Modify");
			modButton.addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {

					new ModEmployee(empList, database);
					initaliseCommonComponents();	
				}
			});
			buttonPanel.add(modButton);
		}
		add(buttonPanel, BorderLayout.SOUTH);
		
		
		if (type == 0) {
			empPanel = new EmpPanel(empList);
			ScrollPane = new JScrollPane(empPanel);
		} else {
			tcPanel = new TcPanel(tcList,empList);
			ScrollPane = new JScrollPane(tcPanel);
		}
		
		
		add(ScrollPane, BorderLayout.CENTER);
	//	setPreferredSize(new Dimension(840, 600));
		setLocationRelativeTo(null);
		setResizable(false);
		setMinimumSize(new Dimension(840,0));
		pack();
		setTitle("View Data");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setVisible(true);
	}

}
