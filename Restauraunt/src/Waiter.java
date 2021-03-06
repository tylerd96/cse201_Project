
public class Waiter extends Employee {
	
	// Instance variables
	private double tips;
	
	// Constructors
	public Waiter() {
		this("");
	}
	public Waiter(String name) {
		this(name, 0.0);
	}
	public Waiter(String name, double salary) {
		this(name, salary, -1);
	}
	public Waiter(String name, double salary, int empNum) {
		this(name,salary,empNum,0.0);
	}
	public Waiter(String name, double salary,int empNum, double tips) {
		super(name, salary,empNum, EmployeeType.WAITER);
		setTips(tips);
	}
	
	
	
	public double getTotSalary() 		{	return getTips() + getSalary();	}
	// Getters and Setters
	public double getTips() 			{	return tips;					}
	public void setTips(double tips) 	{	this.tips = tips;				}
}
