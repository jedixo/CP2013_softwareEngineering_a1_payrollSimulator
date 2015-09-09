package controll;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ViewEmployees extends JFrame{
	
	public ViewEmployees(ResultSet rs) {
		
		try {
			JPanel empPanel = new JPanel();
			empPanel.setLayout(new GridLayout(0,3));
			empPanel.add(new JLabel("id:"));
			empPanel.add(new JLabel("First Name:"));
			empPanel.add(new JLabel("Last Name:"));
			while (rs.next()){
				empPanel.add(new JLabel(rs.getString("id")));
				empPanel.add(new JLabel(rs.getString("first_name")));
				empPanel.add(new JLabel(rs.getString("last_name")));
			}
			this.add(empPanel);
			System.out.println("panel open");
		}catch (Exception e) {
			System.out.println("error");
			
		}
		setPreferredSize(new Dimension(260, 160));
		setVisible(true);
		pack();
		setTitle("employees");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}

}