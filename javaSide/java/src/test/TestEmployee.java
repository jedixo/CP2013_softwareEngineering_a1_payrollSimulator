package test;

import controll.Employee;
import controll.MD5;

public class TestEmployee {

	public static void main(String[] args) {
		Employee test = new Employee("TestFirst", "TestLast");
		test.setAddress("testAddress");
		test.setCommissionRate(100);
		test.setPassword(MD5.hash("Test"));
		test.setPayDelivery(1);
		test.setPayType(1);
		test.setUnion("testUnion");
		test.setSalary(100);
		test.setUserLevel(1);
		
		System.out.println("First Name: " + test.getFirstName());
		System.out.println("Last Name: " + test.getLastName());
		System.out.println("Address: " + test.getAddress());
		System.out.println("Commision Rate: " + test.getCommisionRateFloat());
		System.out.println("Password: " + test.getPasswordMD5("lA7*wL7!"));
		System.out.println("Delivery Type: " + test.getPayDelivery());
		System.out.println("pay Type: " + test.getPayType());
		System.out.println("Union: " + test.getUnion());
		System.out.println("Salary: " + test.getSalary());
		System.out.println("User Level: " + test.getUserLevel());
		System.out.println(test.getClass());

		
		
		
		
		
	}

}
