import java.util.ArrayList;

public class Restauraunt {
	
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	private double cost;
	
	public Restauraunt() {
		this(0);
	}
	public Restauraunt(double cost) {
		setBuildingCost(cost);
	}
	
	
	// add remove employees
	public double getTotalCosts() {
		double money = 0;
		for(Employee e : employees) {
			if(e instanceof Manager) {
				
			}
		}
		return money + getBuildingCost();
	}
	public double getBuildingCost() {return cost;}
	public void setBuildingCost(double cost) {this.cost = cost;}
	
	
	
}
