package controll;


public class Timecard extends AbstractPayrollObject{
	
	private int id, empId;
	private String date, empName;
	private float hours;

	public Timecard(int id, int empId, String date, float hours, EmpList empList) {
		this.id = id;
		this.empId = empId;
		this.date = date;
		this.hours = hours;
		for (Employee emp : empList) {
			if (emp.getId() == empId) {
				empName = emp.getFirstName() + " " + emp.getLastName();
			}
		}
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
	
	@Override
	public Object[] toArray(){
		Object[] ary = {id,empName,date,hours};
		return ary;
		
	}
	
}
