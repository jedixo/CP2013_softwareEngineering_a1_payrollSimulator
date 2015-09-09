import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import com.sun.prism.paint.Stop;

import controll.Database;
import view.MainDisplay;
import view.MainFrame;


public class app {
	
	public static MainFrame mainFrame;
	private static Database database;
	private static MainDisplay mainDisplay;
	

	public static void main(String[] args) {
		mainDisplay = new MainDisplay();
		mainFrame = new MainFrame(mainDisplay);
		
		
		
		mainFrame.addMenuHandler(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				switch (e.getActionCommand()) {
				case "Exit":
					mainFrame.dispose();
					break;
				}
			}
		
		
		});
	}

}
