package controll;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RunPayroll {
	private String currentDay;
	private String endOfMonth;
	private String endOfWeek;
	private Database database;
	
	public RunPayroll(EmpList empList, TimeCardList tcList, SalesRecipts salesRecipts, Database database) {
		this.database = database;
		setDates();
		// unsure how to calculate if biweekly or not
		EmpList hourlyEmp = new EmpList();
		EmpList monthlyEmp = new EmpList();
		EmpList commisionEmp = new EmpList();
		for (Employee emp : empList){
			if (emp.getPayType() == 0) {
				hourlyEmp.add(emp);
			} else if (emp.getPayType() == 1) {
				monthlyEmp.add(emp);
			} else {
				commisionEmp.add(emp);
			}
		}
		calculatePayForHourlyEmp(hourlyEmp, tcList);
		calculatePayForMonthlyEmp(monthlyEmp);
		calculatePayForCommision(commisionEmp, salesRecipts);
		
	}

	private void calculatePayForCommision(EmpList commisionEmp,
			SalesRecipts salesRecipts) {
		//if (currentDay.equals(endOfWeek)) {	// this is wrong, should be fortnightly
		if(true) { // for demonstration purposes
			for (Employee emp : commisionEmp) {
				float srTally = 0;
				for (SalesRecipt sr : salesRecipts) {
					if (emp.getId() == sr.getEmpId()) {
						srTally += sr.getAmount();
					}
				}
				float amount = emp.getSalary() + ((emp.getCommisionRateFloat()/100) * srTally);
				payEmp(amount, emp);
			}
		}
	}

	private void calculatePayForMonthlyEmp(EmpList monthlyEmp) {
		//if (currentDay.equals(endOfMonth)) {
		if (true) {
			for (Employee emp : monthlyEmp) {
				payEmp(emp.getSalary(), emp);
			}
		}
	}

	private void calculatePayForHourlyEmp(EmpList hourlyEmp, TimeCardList tcList) {
		
		//if (currentDay.equals(endOfWeek)) {
		if (true) {
			for (Employee emp : hourlyEmp){
				int hoursWorked = 0;
				for (Timecard tc : tcList) {
					if (emp.getId() == tc.getEmpId()) {
						hoursWorked += tc.getHours();
					}
				}
				int amount = emp.getSalary() * hoursWorked;
				payEmp(amount, emp);
			}
		}
	}

	private void payEmp(float amount, Employee emp) {
		// 0 = mail, 1 = held, 2 = direct deposit
		if (emp.getPayDelivery() == 0) {
			database.addMailPay(emp.getFirstName(), emp.getLastName(), emp.getAddress(), amount, emp.getId(), currentDay);
		}else if (emp.getPayDelivery() == 1) {
			database.addPayHeld(emp.getId(),amount, currentDay);
		}else {
			database.addDepositePay(emp.getFirstName(), emp.getLastName(), amount, emp.getId(), currentDay);
		}
		
	}

	private void setDates() {
		Calendar cal = Calendar.getInstance();
		Date dte = cal.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
		currentDay = format.format(dte);
		
		for (int i = 0; i < 7; i++) {
			cal.add(Calendar.DATE, i);
			format = new SimpleDateFormat("EEE");
			endOfWeek = format.format(cal.getTime());
			if (endOfWeek.equals("Fri")){
				format = new SimpleDateFormat("yyy-MM-dd");
				endOfWeek = format.format(cal.getTime());
				break;
			}
		}
		
		cal = Calendar.getInstance();
		cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
		dte = cal.getTime();
		format = new SimpleDateFormat("yyy-MM-dd");
		endOfMonth = format.format(dte);
	}

}
