import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Restauraunt {
	
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	private double cost;
	private double revenue;
	
	public Restauraunt() {
		this(0);
	}
	public Restauraunt(double revenue) {
		this(revenue,0);
	}
	public Restauraunt(double revenue, double cost) {
		setBuildingCost(cost);
		setRevenue(revenue);
	}
	
	public Restauraunt load() {
		Restauraunt r = new Restauraunt();
		try {
			Scanner in = new Scanner(new File("restauraunt.txt"));
			r.setRevenue(in.nextDouble());
			r.setBuildingCost(in.nextDouble());
			while(in.hasNext()) {
				int num = in.nextInt();
				String name = in.next();
				double salary=  in.nextDouble();
				String type = in.next();
				double tipBonus = in.nextDouble();
				Employee emp;
				if(type.equals("BUSBOY")) {
					emp = new BusBoy(name,salary,num,tipBonus);
				} else if(type.equals("COOK")) {
					emp = new Cook(name,salary,num,tipBonus);
				} else if(type.equals("HOSTESS")) {
					emp = new Hostess(name,salary,num,tipBonus);
				} else if(type.equals("MANAGER")) {
					emp = new Manager(name,salary,num,tipBonus);
				} else { // Waiter
					emp = new Waiter(name,salary,num,tipBonus);
				}
				employees.add(emp);
			}
		} catch(Exception e) {
			
		}
		return r;
	}
	public void save() {
		try {
			PrintWriter pw = new PrintWriter("restauraunt.txt");
			pw.print(revenue+" ");
			pw.print(cost+" ");
			for(Employee e : employees) {
				pw.print(e.getEmpNum() + " ");
				pw.print(e.getName() + " ");
				pw.print(e.getSalary() + " ");
				pw.print(e.getType() + " ");
				if(e instanceof BusBoy) {
					pw.print(((BusBoy)e).getTips()+" ");
				} else if(e instanceof Cook) {
					pw.print(((Cook)e).getBonus()+" ");
				} else if(e instanceof Hostess) {
					pw.print(((Hostess)e).getTips()+" ");
				} else if(e instanceof Manager) {
					pw.print(((Manager)e).getBonus()+" ");
				} else {
					pw.print(((Waiter)e).getTips()+ " ");
				}
			}
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public double getRevenue() 				{return revenue;}
	public void setRevenue(double revenue) 	{this.revenue = revenue;}
	// add remove employees
	public double getTotalCosts() {
		double money = 0;
		for(Employee e : employees) {
			money += e.getSalary();
		}
		return money + getBuildingCost();
	}
	public void addEmployee(Employee e) {
		employees.add(e);
	}
	public double getBuildingCost() {return cost;}
	public void setBuildingCost(double cost) {this.cost = cost;}
	public Employee getEmployee(int num) {
		for(Employee e : employees) {
			if(e.getEmpNum() == num) {
				return e;
			}
		}
		return null;
	}
	public boolean rmvEmployee(int num) {
		for(int i = employees.size()-1; i>=0; i--) {
			Employee e = employees.get(i);
			if(e.getEmpNum() == num) {
				employees.remove(e);
				return true;
			}
		}
		return false;
	}
	
	
	
}
