
public class BusBoy extends Employee {
	
	private double tips;
	
	public BusBoy() {
		this("");
	}
	public BusBoy(String name) {
		this(name, 0.0);
	}
	public BusBoy(String name, double salary) {
		this(name,salary,-1);
	}
	public BusBoy(String name, double salary,int empNum) {
		this(name,salary,empNum,0.0);
	}
	public BusBoy(String name, double salary,int empNum, double tips) {
		super(name, salary,empNum, EmployeeType.BUSBOY);
		setTips(tips);
	}
	
	
	public double getTotSalary() 		{	return getTips() + getSalary();	}
	public double getTips() 			{	return tips;					}
	public void setTips(double tips) 	{	this.tips = tips;				}
}
