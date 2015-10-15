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
		//implement commisioned emp
		
	}

	private void calculatePayForMonthlyEmp(EmpList monthlyEmp) {
		if (currentDay.equals(endOfMonth)) {
			for (Employee emp : monthlyEmp) {
				payEmp(emp.getSalary(), emp);
			}
		}
	}

	private void calculatePayForHourlyEmp(EmpList hourlyEmp, TimeCardList tcList) {
		if (currentDay.equals(endOfWeek)) {
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

	private void payEmp(int amount, Employee emp) {
		// 0 = mail, 1 = held, 2 = direct deposit
		if (emp.getPayDelivery() == 0) {
			mailPay(emp.getFirstName(), emp.getLastName(), emp.getAddress(), amount);
		}else if (emp.getPayDelivery() == 1) {
			database.addPayHeld(emp.getId(),amount);
		}else {
			depositePay(emp.getFirstName(), emp.getLastName(), amount);
		}
		
	}

	private void depositePay(String firstName, String lastName, int amount) {
		// interface for payByDeposite to be extended once implemented
		System.out.println("Deposite to: | " + firstName + " | " + lastName +  " | $" + amount);		
	}

	private void mailPay(String firstName, String lastName, String address, int amount) {
		// interface for payByMail to be extended once implemented
		System.out.println("Mail to: | " + firstName + " | " + lastName + " | " + address + " | $" + amount);
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
