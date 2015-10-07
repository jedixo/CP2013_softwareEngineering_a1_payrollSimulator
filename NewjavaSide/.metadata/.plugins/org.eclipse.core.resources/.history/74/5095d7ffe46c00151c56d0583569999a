package view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;


;
@SuppressWarnings("serial")
public class MainDisplay extends JPanel{

	public JButton[] buttons;
	private List<String> events = Arrays.asList(
			"Employees","Timecards","Post Receipt","Post Union Service Charge","Run Payroll");
	
	public MainDisplay() {
		
		setLayout(new GridLayout(2, 4, 4, 4));
		
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
