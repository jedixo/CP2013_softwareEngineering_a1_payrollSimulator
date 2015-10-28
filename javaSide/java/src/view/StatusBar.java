package view;

import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class StatusBar extends JPanel {
	
	private JPanel sec1, sec2, sec3;
	
	public StatusBar() {
		setBorder(new BevelBorder(BevelBorder.LOWERED));
		setLayout(new GridLayout(0, 3));
		
		sec1 = new JPanel();
		sec1.setLayout(new GridLayout(1,3));
		add(sec1);

		sec2 = new JPanel();
		sec2.setLayout(new GridLayout(1,3));
		add(sec2);

		sec3 = new JPanel();
		sec3.setLayout(new GridLayout(1,3));
		add(sec3);
		
	
	}
	public void addsec1(JComponent component) {
		sec1.add(component);
	}
	public void addsec2(JComponent component) {
		sec2.add(component);
	}
	public void addsec3(JComponent component) {
		sec3.add(component);
	}
}
