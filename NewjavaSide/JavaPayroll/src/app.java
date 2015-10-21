


import javax.swing.UIManager;

import controll.Database;
import controll.EmpList;
import controll.SalesRecipts;
import controll.TimeCardList;
import view.LoadingBar;
import view.LoginWindow;
import view.ViewFrame;


public class app {
	
	private static final String HOST = "sql6.freemysqlhosting.net/sql689509";
	private static final String USERNAME = "sql689509";
	private static final String PASSWORD = "lA7*wL7!";
	
	private static Database database;
	private static EmpList empList;
	private static TimeCardList timeCardList;
	private static SalesRecipts salesRecipts;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch (Exception e){}
		
		LoadingBar load = new LoadingBar("Connecting");
		load.updateBar(25,"Connecting");
		database = new Database(HOST, USERNAME, PASSWORD);
		if (database.isConnected) {
			load.updateBar(50,"Querying Employees");
			empList = new EmpList(database.getTable("employees"));
			LoginWindow login = new LoginWindow(empList);
			if (login.isLoggedIn()) {
				load.updateBar(75,"Querying Timecards");
				timeCardList = new TimeCardList(database.getTable("time_card"));
				load.updateBar(100,"Loading UI");
				salesRecipts = new SalesRecipts(database.getTable("sales_recipts"));
				load.dispose();
				new ViewFrame(empList, database, timeCardList, salesRecipts);
			} else {
				load.dispose();
			}
		} else {
			load.dispose();
		}
	}

}
