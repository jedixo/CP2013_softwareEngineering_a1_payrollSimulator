package controll;


public class Timecard{
	
	private int id, empId;
	private String date;
	private float hours;

	public Timecard(int id, int empId, String date, float hours) {
		this.id = id;
		this.empId = empId;
		this.date = date;
		this.hours = hours;
		
	}

	public Timecard(int empId2, String dateString, float f) {
		id = (int) Math.random();
		this.empId = empId2;
		this.date = dateString;
		this.hours = f;
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

	public float getHours() {
		return hours;
	}

	public void setHours(float hours) {
		this.hours = hours;
	}
	


	
}
