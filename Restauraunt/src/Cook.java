
public class Cook extends Employee {
	private double tips;
	
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
	public Cook(String name, double salary,int empNum, double tips) {
		super(name, salary,empNum, EmployeeType.COOK);
		setTips(tips);
	}
	
	
	public double getTotSalary() 		{	return getTips() + getSalary();	}
	public double getTips() 			{	return tips;					}
	public void setTips(double tips) 	{	this.tips = tips;				}
}
