
public class Employee {
	
	//Instance variables
	private double salary;
	private String name;
	private int empNum;
	private EmployeeType type;
	
	// Constructors
	public Employee()	{
		this("");
	}
	public Employee(String name) {
		this(name,0);
	}
	public Employee(String name, double salary) {
		this(name,salary,-1);
	}
	public Employee(String name, double salary, int empNum) {
		this(name,0,empNum,EmployeeType.NA);
	}
	public Employee(String name, double salary, int empNum, EmployeeType type) {
		setSalary(salary);
		setName(name);
		setType(type);
		setEmpNum(empNum);
	}
	
	
	// Getters and Setters
	public int getEmpNum() 					{	return empNum;			}
	public void setEmpNum(int empNum) 		{	this.empNum = empNum;	}
	public String getName() 				{	return name;			}
	public void setName(String name) 		{	this.name = name;		}
	public EmployeeType getType() 			{	return type;			}
	public void setType(EmployeeType type) 	{	this.type = type;		}
	public double getSalary() 				{	return salary;			}
	public void setSalary(double salary) 	{	this.salary = salary;	}
	
	
}
