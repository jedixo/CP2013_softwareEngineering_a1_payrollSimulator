package test;

import controll.SalesRecipt;

public class testSalesRecipt {

	public static void main(String[] args) {
		SalesRecipt test = new SalesRecipt(0, "2015-01-01", 600);
		System.out.println("ID: " + test.getId());
		System.out.println("Emp ID: " + test.getEmpId());
		System.out.println("Date: " + test.getDate());
		System.out.println("Amount: " + test.getAmount());
		System.out.println(test.getClass());

	}

}
