


import javax.swing.UIManager;

import controll.Database;
import controll.EmpList;
import controll.TimeCardList;
import view.LoadingBar;
import view.ViewFrame;


public class app {
	
	private static Database database;
	public static EmpList empList;
	private static TimeCardList timeCardList;
	
	

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch (Exception e){}
		
		LoadingBar load = new LoadingBar("Connecting");
		load.updateBar(25,"Connecting");
		database = new Database("sql6.freemysqlhosting.net/sql689509", "sql689509",
				"lA7*wL7!");
		if (database.isConnected) {
			load.updateBar(50,"Querying Employees");
			empList = new EmpList(database.getTable("employees"));
			load.updateBar(75,"Querying Timecards");
			timeCardList = new TimeCardList(database.getTable("time_card"));
			load.updateBar(100,"Loading UI");
			load.dispose();
			new ViewFrame(empList, database, timeCardList);
		} else {
			load.dispose();
		}
	}

}
