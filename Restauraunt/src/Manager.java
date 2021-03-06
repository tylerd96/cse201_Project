
public class Manager extends Employee{
	
	//Instance variables
	private double bonus;
	
	// Constructors
	public Manager() {
		this("");
	}
	public Manager(String name) {
		this(name, 0.0);
	}
	public Manager(String name, double salary) {
		this(name,salary,-1);
	}
	public Manager(String name, double salary, int empNum) {
		this(name,salary,empNum,0.0);
	}
	public Manager(String name, double salary, int empNum, double bonus) {
		super(name, salary, empNum, EmployeeType.MANAGER);
		setBonus(bonus);
	}
	
	
	
	
	public double getTotSalary() 		{	return getBonus() + getSalary();		}
	// Getters and setters
	public double getBonus() 			{	return bonus;							}
	public void setBonus(double bonus) 	{	this.bonus = bonus;						}
	
}
