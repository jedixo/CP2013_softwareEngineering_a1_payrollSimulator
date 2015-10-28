package controll;
import view.ViewFrame;


public class UserFrame {

	public int exitStatus;

	public UserFrame(Employee empLoggedIn, TimeCardList timeCardList,
			SalesRecipts salesRecipts, Database database) {
		int empType = empLoggedIn.getPayType();
		if (empType == 0) {
			//hourly
			EmpList focus = new EmpList();
			focus.add(empLoggedIn);
			TimeCardList focusedEmp = new TimeCardList();
			for (Timecard tc : timeCardList){
				if (tc.getEmpId() == empLoggedIn.getId()) {
					focusedEmp.add(tc);
				}
			}
			new ViewFrame(focusedEmp, database, focus, timeCardList);
		} else if (empType == 2) {
			EmpList focus = new EmpList();
			focus.add(empLoggedIn);
			SalesRecipts srfocused = new SalesRecipts();
			for (SalesRecipt tc : salesRecipts){
				if (tc.getEmpId() == empLoggedIn.getId()) {
					srfocused.add(tc);
				}
			}
			new ViewFrame(srfocused, database, focus, salesRecipts);
			
		} else {
			// monthly emp doesnt do anything
		}
	}

}
