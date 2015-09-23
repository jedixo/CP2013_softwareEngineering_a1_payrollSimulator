package view;

import java.awt.Font;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MainLabel extends JLabel {
	
	private final Font BOLD = new Font(this.getFont().getFontName(), Font.BOLD, this.getFont().getSize());
	private final Font NORMAL = new Font(this.getFont().getFontName(), Font.PLAIN, this.getFont().getSize());

	public MainLabel(String string) {
		setText(string);
		setFont(NORMAL);
	}
	
	public MainLabel(String string, String weight) {
		setText(string);
		if (weight.equals("BOLD")) {
			setFont(BOLD);
		}
	}
	
	public void setWeight(String weight) {
		if (weight.equals("BOLD")) {
			setFont(BOLD);
		} else {
			setFont(NORMAL);
		}
		
	}

}
