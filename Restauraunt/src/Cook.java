
public class Cook extends Employee {
	
	// Instance Variables
	private double bonus;
	
	// Constructors
	public Cook() {
		this("");
	}
	public Cook(String name) {
		this(name, 0.0);
	}
	public Cook(String name, double salary) {
		this(name,salary,-1);
	}
	public Cook(String name, double salary,int empNum) {
		this(name,salary,empNum,0.0);
	}
	public Cook(String name, double salary,int empNum, double bonus) {
		super(name, salary,empNum, EmployeeType.COOK);
		setBonus(bonus);
	}
	
	
	public double getTotSalary() 		{	return getBonus() + getSalary();}
	// Getters and Setters
	public double getBonus() 			{	return bonus;					}
	public void setBonus(double tips) 	{	this.bonus = tips;				}
}
