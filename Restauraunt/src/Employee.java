
public class Employee {
	
	private double salary;
	private String name, position;
	
	public Employee()	{
		this("");
	}
	public Employee(String name) {
		this(name,0);
	}
	public Employee(String name, double salary) {
		this(name,0,"");
	}
	public Employee(String name, double salary, String position) {
		setSalary(salary);
		setName(name);
		setPosition(position);
		
	}
	
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getPosition() {return position;}
	public void setPosition(String position) {this.position = position;}
	public double getSalary() {return salary;}
	public void setSalary(double salary) {this.salary = salary;}
	
	
}
