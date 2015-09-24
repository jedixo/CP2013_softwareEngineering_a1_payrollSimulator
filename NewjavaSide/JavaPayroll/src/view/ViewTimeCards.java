package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import controll.Database;
import controll.TimeCardList;

@SuppressWarnings("serial")
public class ViewTimeCards extends JFrame{
	
	private TimeCardList timeCardList;
	private TcPanel tcPanel;
	private JButton addButton;
	private JButton modButton;
	private JScrollPane scrollPane;

	public ViewTimeCards(TimeCardList timeCardList, Database database) {
		this.timeCardList = timeCardList;
		
		tcPanel = new TcPanel(timeCardList);
		ScrollPane = new JScrollPane();
	}

}
