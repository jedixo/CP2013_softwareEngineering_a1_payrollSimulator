package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.JTableHeader;

import controll.Database;
import controll.viewTable;

@SuppressWarnings("serial")
public class ViewPay extends JDialog {
	
	private String[] columNames = {"Date","First Name", "Last Name", "Amount"};
	private JTableHeader header;
	private float total = 0;
	
	public ViewPay(Database database) {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		viewTable table = new viewTable(columNames);
		panel.add(table,BorderLayout.CENTER);
		header = table.getTableHeader();
		add(header,BorderLayout.PAGE_START);
		JScrollPane scroll = new JScrollPane(panel);
		add(scroll,BorderLayout.CENTER);
		
		ResultSet dbTable = database.getTable("direct_pay");
		try {
			while (dbTable.next()) {
				Object[] temp = {dbTable.getString("date"),dbTable.getString("firstName"),dbTable.getString("lastName"),"$" + dbTable.getFloat("amount")};
				table.addRow(temp);
				total += dbTable.getFloat("amount");
			}
		}catch (Exception e){}
		dbTable = database.getTable("mail_pay");
		try {
			while (dbTable.next()) {
				Object[] temp = {dbTable.getString("date"),dbTable.getString("firstName"),dbTable.getString("lastName"),"$" + dbTable.getFloat("amount")};
				table.addRow(temp);
				total += dbTable.getFloat("amount");
			}
		}catch (Exception e){}
		dbTable = database.getTable("held_pay");
		try {
			while (dbTable.next()) {
				Object[] temp = {dbTable.getString("date"),dbTable.getString("firstName"),dbTable.getString("lastName"),"$" + dbTable.getFloat("amount")};
				table.addRow(temp);
				total += dbTable.getFloat("amount");
			}
		}catch (Exception e){}
		
		StatusBar statusbar = new StatusBar();
		statusbar.addsec1(new JLabel("Total Pay:"));
		statusbar.addsec1(new JLabel("$" + total));
		add(statusbar,BorderLayout.SOUTH);
		
		
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu(" File ");
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		file.add(exit);
		menubar.add(file);
		setJMenuBar(menubar);
		
		setPreferredSize(new Dimension(440,300));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setModal(true);
		setTitle("Pay roll");
		pack();
		setVisible(true);
		
		
		
	}

}
