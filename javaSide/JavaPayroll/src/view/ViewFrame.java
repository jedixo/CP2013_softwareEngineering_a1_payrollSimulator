package view;

//TODO:
// move menubar outside of viewFrame
// add adding sales recipts
// fix sorting mucking up double clicks

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
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
import controll.RunPayroll;
import controll.SalesRecipts;
import controll.TimeCardList;

@SuppressWarnings("serial")
public class ViewFrame extends JDialog{
	private JMenuBar menubar;
	private EmpList empList;
	private TimeCardList tcList, ogTcList;
	private SalesRecipts salesRecipts, ogSrList;
	private TcPanel tcPanel;
	private SrPanel srPanel;
	private int type;
	private EmpPanel empPanel;
	private Button addButton, modButton;
	private JScrollPane ScrollPane;
	private Database database;
	private JPanel buttonPanel;
	private JTableHeader header;
	public int exitStatus = 0;
	private boolean isAdmin;
	
	//emp view master constructor
	public ViewFrame(final EmpList empList, final Database database, TimeCardList tcList, SalesRecipts salesRecipts, boolean isAdmin) {
		this.isAdmin = isAdmin;
		type = 0;
		this.tcList = tcList;
		this.database = database;
		this.empList = empList;
		this.salesRecipts = salesRecipts;
		empPanel = new EmpPanel();
		header = empPanel.header;
		add(header, BorderLayout.PAGE_START);
		ScrollPane = new JScrollPane(empPanel);
		if (isAdmin) {
			buttonPanel = new JPanel();
			add(buttonPanel, BorderLayout.SOUTH);
		}
		add(ScrollPane, BorderLayout.CENTER);
		setTitle("View Employees");
		initaliseCommonComponents();
		
	}
	//tc view
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
	
	public ViewFrame(SalesRecipts srList, Database database, EmpList empList) {
		type = 4;
		this.empList = empList;
		this.database = database;
		this.salesRecipts = srList;
		srPanel = new SrPanel();
		header = srPanel.header;
		add(header, BorderLayout.PAGE_START);
		ScrollPane = new JScrollPane(srPanel);
		buttonPanel = new JPanel();
		add(buttonPanel);
		add(ScrollPane,BorderLayout.CENTER);
		setTitle("View Sales Recipts");
		initaliseCommonComponents();
	}
	
	//for  focused tc view
	public ViewFrame(TimeCardList focusedEmp, Database database2,
			EmpList focusedEmpList, TimeCardList tcList) {
		
		this(focusedEmp,database2,focusedEmpList);
		this.ogTcList = tcList;
		type = 3;
		initaliseCommonComponents();
	}

	// for focused sr view
	public ViewFrame(SalesRecipts focusedSrList, Database database2,
			EmpList focusedEmpList, SalesRecipts salesRecipts2) {
		
		this(focusedSrList,database2,focusedEmpList);
		this.ogSrList = salesRecipts2;
		type = 5;
		initaliseCommonComponents();
		
		
	}
	private void initaliseCommonComponents() {
		remove(ScrollPane);
		if (isAdmin) {
			remove(buttonPanel);
		}
		remove(header);
		menubar = setupMenu();
		setJMenuBar(menubar);
		
		if (isAdmin) {
			JPanel buttonPanel = new JPanel();

			addButton = new Button("add");
			addButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (type == 0) {
						new AddEmployee(empList, database);
					} else if (type == 3){
						new AddTimeCard(tcList, database, empList, 1,ogTcList);
					} else if (type == 4){
						new AddSalesRecipt(salesRecipts, database, empList, 0, null);
					} else if (type == 5){
						new AddSalesRecipt(salesRecipts, database, empList, 1, ogSrList);
					} else {
						new AddTimeCard(tcList, database, empList, 0, null);
					}
					initaliseCommonComponents();	
				}
			});
			buttonPanel.add(addButton);
			if (type == 0) {
			
				modButton = new Button("Modify");
				addButton.setText("Add");
				addButton.setFont(modButton.getFont());
				addButton.setForeground(Color.BLACK);
				modButton.addActionListener(new ActionListener() {
			
					@Override
					public void actionPerformed(ActionEvent e) {

						if (empPanel.getRowSelected() == -1){
							JOptionPane.showMessageDialog(null, "No Employee selected, Please select an Employee to edit", "No Selection", JOptionPane.OK_OPTION);
						}else {
							EmpList selectedEmp = new EmpList();
							for (Employee emp : empList) {
								if (emp.getId() == empPanel.getEmpSelected()) {
									selectedEmp.add(emp);
								}
							}
							if (selectedEmp.size() != 0) {	
								new ModEmployee(selectedEmp, database, empList);
							}
						}
						initaliseCommonComponents();	
					}
				});
				buttonPanel.add(modButton);
			}
			add(buttonPanel, BorderLayout.SOUTH);
		
		
		if (type == 0) {
			empPanel = new EmpPanel(empList,tcList,database,salesRecipts);
			header = empPanel.header;
			ScrollPane = new JScrollPane(empPanel);
			setPreferredSize(new Dimension(840,400));
		} else if (type == 4 || type == 5){
			srPanel = new SrPanel(salesRecipts,empList);
			header = srPanel.header;
			ScrollPane = new JScrollPane(srPanel);
			setPreferredSize(new Dimension(440,300));
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
		setModal(true);
		setVisible(true);
	}

	private JMenuBar setupMenu() {
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu(" File ");
		JMenuItem logOut = new JMenuItem(" Log off ");
		logOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				exitStatus = 1;
				close();
			}
		});
		file.add(logOut);
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
			JMenuItem viewSr = new JMenuItem("View Sales Recipts");
			viewSr.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					EmpList commisionedEmpList = new EmpList();
					for (Employee emp : empList) {
						if (emp.getPayType() == 2) {
							commisionedEmpList.add(emp);
						}
					}
					new ViewFrame(salesRecipts, database, commisionedEmpList);
				}
			});
			view.add(viewSr);
			menubar.add(view);
			
			JMenu action = new JMenu(" Actions ");
			JMenuItem runPayroll = new JMenuItem("Run Payroll");
			runPayroll.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new RunPayroll(empList,tcList,salesRecipts, database);
				}
			});
			action.add(runPayroll);
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
