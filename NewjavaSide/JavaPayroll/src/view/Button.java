package view;

import java.awt.Color;



import javax.swing.JButton;

@SuppressWarnings("serial")
public class Button extends JButton {
	public static java.awt.Font BOLD = new java.awt.Font("Tahoma",java.awt.Font.BOLD,25);

	
	public Button(String type) {
		if (type.equals("add")) {
			setFont(BOLD);
			setText("+");
			setToolTipText("Add");
			setForeground(Color.GREEN);
		}else if (type.equals("cancel")) {
			setFont(BOLD);
			setText("-");
			setToolTipText("Cancel");
		}else if (type.equals("delete")) {
			setFont(BOLD);
			setText("×");
			setToolTipText("Delete");
			setForeground(Color.magenta);
		}else {
			setText(type);
			setToolTipText(type);
		}
			
	}
}
