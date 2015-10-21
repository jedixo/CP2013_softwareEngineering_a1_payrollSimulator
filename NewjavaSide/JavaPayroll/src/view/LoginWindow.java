package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controll.EmpList;
import controll.Employee;

@SuppressWarnings("serial")
public class LoginWindow extends JDialog {
	private boolean loggedIn = false;
	private JTextField name, password;

	public LoginWindow(final EmpList empList) {
		final JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2,2,2));
		panel.add(new JLabel("    Name:"));
		name = new JTextField();
		panel.add(name);
		panel.add(new JLabel("    Password:"));
		password = new JTextField();
		panel.add(password);
		JButton ok = new JButton("Ok");
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (name.getText().equals("admin")) {
					loggedIn = true;
					setVisible(false);
					
				} else {
					String[] nameStr = name.getText().split("\\s+");
					int error = 0;
					for (Employee emp : empList) {
						if (emp.getFirstName().equals(nameStr[0]) && emp.getLastName().equals(nameStr[1])) {
							if (emp.matchPassword(password.getText())) {
								loggedIn = true;
								error = 0;
								setVisible(false);
								
								break;
							} else {
								error = 2;
								break;
							}
						} else {
							error = 1;
						}
					}
					if (error == 1) {
						incorrectName();
					} else if (error == 2) {
						incorrectPassword();
					}
				}
			}

			
		});
		panel.add(ok);
		JButton close = new JButton("Cancel");
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		panel.add(close);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		add(panel);
		setLocationRelativeTo(null);
		setPreferredSize(new Dimension(200, 100));
		setTitle("Login");
		setResizable(false);		
		pack();
		setModal(true);
		setVisible(true);
	}

	
	
	private void incorrectPassword() {
		JOptionPane.showMessageDialog(null, "An invalid password was entered", "Input Error", JOptionPane.OK_OPTION);
		password.setText("");
	}
	
	private void incorrectName() {
		JOptionPane.showMessageDialog(null, "An invalid name was entered", "Input Error", JOptionPane.OK_OPTION);
		password.setText("");
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}

}
