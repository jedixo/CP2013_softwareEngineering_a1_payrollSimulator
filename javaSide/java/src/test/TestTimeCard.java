package test;

import controll.Timecard;

public class TestTimeCard {

	public static void main(String[] args) {
		Timecard test = new Timecard(0, 0, "2015-01-01", 100);
		System.out.println("ID: " + test.getId());
		System.out.println("Emp ID: " + test.getEmpId());
		System.out.println("Date: " + test.getDate());
		System.out.println("Hours: " + test.getHours());
		System.out.println(test.getClass());
	}

}
