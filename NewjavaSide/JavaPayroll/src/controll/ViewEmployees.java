package controll;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ViewEmployees extends JFrame{
	
	public ViewEmployees(ArrayList<Employee> empList) {
		
		JPanel empPanel = new JPanel();
		empPanel.setLayout(new GridLayout(0,3));
		empPanel.add(new JLabel("id:"));
		empPanel.add(new JLabel("First Name:"));
		empPanel.add(new JLabel("Last Name:"));
		for (Employee employee : empList) {
			empPanel.add(new JLabel(String.valueOf(employee.getId())));
			empPanel.add(new JLabel(employee.getFirstName()));
			empPanel.add(new JLabel(employee.getLastName()));
		}
		this.add(empPanel);

		setPreferredSize(new Dimension(260, 160));
		setVisible(true);
		pack();
		setTitle("employees");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}

}
