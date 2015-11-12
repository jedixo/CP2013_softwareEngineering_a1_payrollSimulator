import javax.swing.JOptionPane;
import javax.swing.UIManager;
import controll.Database;
import controll.EmpList;
import controll.Employee;
import controll.SalesRecipt;
import controll.SalesRecipts;
import controll.TimeCardList;
import controll.Timecard;
import view.LoadingBar;
import view.LoginWindow;
import view.ViewFrame;


public class App {
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
		
		JOptionPane.showMessageDialog(null, "NOTE: Database has been shutdown. In order to maintain"
				+ " the database for this \nproject I had to respond to an email from "
				+ "the database providers every week \nI am ceasing to do this as of: "
				+ "12/11/2015 \nI have attempted to it convert to work offline, select cancel at the login window"
				+ "\nand the database wont save anything, or may produce an error, "
				+ "online code can be\nfound as appOnline.java, if you want to use it but this will by the final version.\nThank You - Jake Dixon", "Database Shutdown", JOptionPane.QUESTION_MESSAGE);

		
		load = new LoadingBar("Connecting");
		load.updateBar(25,"Connecting");
		database = new Database();
		load.updateBar(50,"Querying Employees");
		empList = new EmpList();
		Employee emp = new Employee("first", "last");
		empList.add(emp);
		emp = new Employee("seccond", "last");
		emp.setPayType(2);
		emp.setId(1);
		empList.add(emp);
		initaliseUi();
	}

	private void initaliseUi() {
		if (load.isVisible() == false) {
			load = new LoadingBar("Logging in");
			load.updateBar(60, "Logging in");
		} else {
			load.updateBar(60, "Logging in");
		}
		new LoginWindow(empList); //too demonstrate functionality
		if (true) {	
			load.updateBar(75,"Querying Timecards");
			timeCardList = new TimeCardList();
			Timecard tc = new Timecard(0, "2015-11-12", 20);
			timeCardList.add(tc);
			load.updateBar(100,"Loading UI");
			salesRecipts = new SalesRecipts();
			SalesRecipt sr = new SalesRecipt(1, "2015-11-12", 200);
			salesRecipts.add(sr);
			load.dispose();
			viewframe = new ViewFrame(empList, database, timeCardList, salesRecipts);
			if (viewframe.exitStatus == 0)
				System.exit(0);
			else {
				initaliseUi();
			}
		}
	}

	public static void main(String[] args) {
		new App();
	}
}
