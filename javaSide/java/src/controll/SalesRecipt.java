package controll;

public class SalesRecipt {
	
	private int id, empId;
	private String date;
	private float amount;

	public SalesRecipt(int int1, int int2, String string, float float1) {
		this.id = int1;
		this.empId = int2;
		this.date = string;
		this.amount = float1;
	}

	public SalesRecipt(int empId2, String dateString, float f) {
		id = 0;
		this.empId = empId2;
		this.date = dateString;
		this.amount = f;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	

}
