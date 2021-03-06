
public class Hostess extends Employee {
	
	// Instance Variables
	private double tips;
	
	// Concstructors
	public Hostess() {
		this("");
	}
	public Hostess(String name) {
		this(name, 0.0);
	}
	public Hostess(String name, double salary) {
		this(name, salary,-1);
	}
	public Hostess(String name, double salary,int empNum) {
		this(name,salary,empNum, 0.0);
	}
	public Hostess(String name, double salary,int empNum, double tips) {
		super(name, salary,empNum, EmployeeType.HOSTESS);
		setTips(tips);
	}
	
	
	public double getTotSalary() 		{	return getTips() + getSalary();	}
	// Getters and Setters
	public double getTips() 			{	return tips;					}
	public void setTips(double tips) 	{	this.tips = tips;				}
	
	
}
