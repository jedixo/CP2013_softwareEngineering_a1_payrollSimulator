

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
		database = new Database("sql6.freemysqlhosting.net/sql689509", "sql689509",
				"lA7*wL7!");
		
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
		
		mainDisplay.addButtonHandler(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
				
				switch (e.getActionCommand()) {
				case "View Employees":
					database.printEmployees();
				}
				//Object value = shell.evaluate("System.out.println('hello');");
			}
		});
		
	}

}
