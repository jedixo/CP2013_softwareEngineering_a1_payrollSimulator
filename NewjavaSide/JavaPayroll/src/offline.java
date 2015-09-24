

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

import controll.Database;
import controll.EmpList;
import controll.Employee;
import view.LoadingBar;
import view.MainDisplay;
import view.MainFrame;
import view.ViewEmployees;


public class offline {
	
	public static MainFrame mainFrame;
	public static Database empDatabase;
	public static MainDisplay mainDisplay;
	public static EmpList empList;
	

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch (Exception e){}
		
		LoadingBar load = new LoadingBar("Connecting");
		if (true) {
			empDatabase = null;
			load.updateBar(50,"Querying Database");
			empList = new EmpList();
			empList.add(new Employee("JAkE", "Dixon"));
			load.updateBar(100,"Loading UI");
			load.dispose();
		
			mainDisplay = new MainDisplay();
		
			mainDisplay.addButtonHandler(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(e.getActionCommand());
				
					switch (e.getActionCommand()) {
					case "Employees":
						new ViewEmployees(empList, empDatabase);
						break;
					}
				}
			});
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

}