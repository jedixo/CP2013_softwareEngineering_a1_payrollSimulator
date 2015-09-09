package view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import sun.security.util.Length;

public class MainDisplay extends JPanel{

	public JButton[] buttons;
	private List<String> events = Arrays.asList("Add Employee","Delete employee","Update Employee",
			"View Employees","Post timecard","post receipt","post union service charge","run payroll");
	
	public MainDisplay() {
		
		int i = 0;
		buttons = new JButton[events.size()];
		for (String element : events) {
			JButton btn = new JButton();
			btn.setActionCommand(element);
			btn.setText(element);
			buttons[i] = btn;
			this.add(buttons[i]);
			i++;
			
			
		}
	}
	
	public void addButtonHandler(ActionListener listener) {
		for (int j = 0; j < buttons.length; ++j) {
			buttons[j].addActionListener(listener);
		}
	}

}
