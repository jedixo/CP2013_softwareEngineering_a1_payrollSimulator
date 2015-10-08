package view;

//todo:
// make it so you can modify a selected emp i guess???
// move menubar outside of viewFrame
// sales receipt on commisioned employee

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.JTableHeader;

import controll.Database;
import controll.EmpList;
import controll.Employee;
import controll.TimeCardList;

@SuppressWarnings("serial")
public class ViewFrame extends JFrame{
	private JMenuBar menubar;
	private EmpList empList;
	private TimeCardList tcList, ogTcList;
	private TcPanel tcPanel;
	private int type;
	private EmpPanel empPanel;
	private JButton addButton, modButton;
	private JScrollPane ScrollPane;
	private Database database;
	private JPanel buttonPanel;
	private JTableHeader header;
	
	public ViewFrame(final EmpList empList, final Database database, TimeCardList tcList) {
		
		type = 0;
		this.tcList = tcList;
		this.database = database;
		this.empList = empList;
		empPanel = new EmpPanel();
		header = empPanel.header;
		add(header, BorderLayout.PAGE_START);
		ScrollPane = new JScrollPane(empPanel);
		buttonPanel = new JPanel();
		add(buttonPanel);
		add(ScrollPane, BorderLayout.CENTER);
		setTitle("View Employees");
		initaliseCommonComponents();
		
	}

	public ViewFrame(TimeCardList timeCardList, Database database, EmpList empList) {
		type = 1;
		this.empList = empList;
		this.database = database;
		this.tcList = timeCardList;
		tcPanel = new TcPanel();
		header = tcPanel.header;
		add(header, BorderLayout.PAGE_START);
		ScrollPane = new JScrollPane(tcPanel);
		buttonPanel = new JPanel();
		add(buttonPanel);
		add(ScrollPane, BorderLayout.CENTER);
		setTitle("View Timecards");
		initaliseCommonComponents();
	}

	public ViewFrame(TimeCardList focusedEmp, Database database2,
			EmpList focusedEmpList, TimeCardList tcList) {
		
		this(focusedEmp,database2,focusedEmpList);
		this.ogTcList = tcList;
		type = 3;
		initaliseCommonComponents();
	}

	private void initaliseCommonComponents() {
		remove(ScrollPane);
		remove(buttonPanel);
		remove(header);
		remove(getMenuBar());
		menubar = setupMenu();
		setJMenuBar(menubar);
		
		
		JPanel buttonPanel = new JPanel();

		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				if (type == 0) {
					new AddEmployee(empList, database);
				} else if (type == 3){
					new AddTimeCard(tcList, database, empList, 1,ogTcList);
				} else {
					new AddTimeCard(tcList, database, empList, 0, null);
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

					if (empPanel.getRowSelected() == -1){
						JOptionPane.showMessageDialog(null, "No Employee selected, Please select an Employee to edit", "No Selection", JOptionPane.OK_OPTION);
					}else {
						for (Employee emp : empList) {
							if (emp.getId() == empPanel.getEmpSelected()) {
								EmpList selectedEmp = new EmpList();
								selectedEmp.add(emp);
								new ModEmployee(selectedEmp, database);
							}
						}
					}
					initaliseCommonComponents();	
				}
			});
			buttonPanel.add(modButton);
		}
		add(buttonPanel, BorderLayout.SOUTH);
		
		
		if (type == 0) {
			empPanel = new EmpPanel(empList,tcList,database);
			header = empPanel.header;
			ScrollPane = new JScrollPane(empPanel);
			setPreferredSize(new Dimension(840,400));
		} else {
			tcPanel = new TcPanel(tcList,empList);
			header = tcPanel.header;
			ScrollPane = new JScrollPane(tcPanel);
			setPreferredSize(new Dimension(440,300));
		}
		
		add(header, BorderLayout.PAGE_START);
		add(ScrollPane, BorderLayout.CENTER);
		setResizable(false);
		
		pack();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private JMenuBar setupMenu() {
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu(" File ");
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		menubar.add(file);
		file.add(exit);
		if (type == 0) {
			JMenu view = new JMenu(" View ");
			JMenuItem viewTc = new JMenuItem("View All Timecards");
			viewTc.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					EmpList hourlyEmpList = new EmpList();
					for (Employee emp : empList) {
						if (emp.getPayType() == 0) {
							hourlyEmpList.add(emp);
						}
					}
					
					new ViewFrame(tcList, database, hourlyEmpList);
				}
			});
			view.add(viewTc);
			menubar.add(view);
			
			JMenu action = new JMenu(" Actions ");
			JMenuItem runPayroll = new JMenuItem("Run Payroll");
			action.add(runPayroll);
			JMenuItem postReceipt = new JMenuItem("Post Receipt");
			action.add(postReceipt);
			JMenuItem unionServiceCharge = new JMenuItem("Post Union Service Charge");
			action.add(unionServiceCharge);
			menubar.add(action);
		}
		
		return menubar;
	}
	
	private void close() {
		this.dispose();
	}

}
