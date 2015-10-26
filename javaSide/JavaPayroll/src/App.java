


import javax.swing.UIManager;

import controll.Database;
import controll.EmpList;
import controll.SalesRecipts;
import controll.TimeCardList;
import view.LoadingBar;
import view.LoginWindow;
import view.ViewFrame;


public class App {
	
	private static final String HOST = "sql6.freemysqlhosting.net/sql689509";
	private static final String USERNAME = "sql689509";
	private static final String PASSWORD = "lA7*wL7!";
	private ViewFrame viewframe;
	private static Database database;
	private static EmpList empList;
	private static TimeCardList timeCardList;
	private static SalesRecipts salesRecipts;
	private LoadingBar load;
	
	public App(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch (Exception e){}
		
		load = new LoadingBar("Connecting");
		load.updateBar(25,"Connecting");
		database = new Database(HOST, USERNAME, PASSWORD);
		if (database.isConnected) {
			load.updateBar(50,"Querying Employees");
			empList = new EmpList(database.getTable("employees"));
			initaliseUi();
		} else {
			load.dispose();
			System.exit(0);
		}

	}

	private void initaliseUi() {
		
		if (load.isVisible() == false) {
			load = new LoadingBar("Logging in");
			load.updateBar(60, "Logging in");
		} else {
			load.updateBar(60, "Logging in");
		}
			
		LoginWindow login = new LoginWindow(empList);
		if (login.isLoggedIn()) {
			
			load.updateBar(75,"Querying Timecards");
			timeCardList = new TimeCardList(database.getTable("time_card"));
			load.updateBar(100,"Loading UI");
			salesRecipts = new SalesRecipts(database.getTable("sales_recipts"));
			load.dispose();
				viewframe = new ViewFrame(empList, database, timeCardList, salesRecipts, login.isAdmin());
			if (viewframe.exitStatus == 0)
				System.exit(0);
			else {
				initaliseUi();
			}

		} else {
			load.dispose();
			System.exit(0);
		}
			}

	public static void main(String[] args) {
		new App();
	}


}
