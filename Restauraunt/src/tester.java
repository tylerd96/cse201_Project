import javax.swing.*;
import javax.swing.plaf.synth.SynthSeparatorUI;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
public class tester {
	
	public tester() {createComponents();}
	
	ArrayList<Employee> employees = new ArrayList<Employee>();
	public static JButton buildingStats;
	public static JButton newEmployee;
	public static JButton rmEmployee;
	public static JButton getEmployee;
	public static JButton save;
	public static JButton load;
	public static JTextArea area;
	//public static JRadioButtonMenuItem type;
	public static JRadioButton busBoy;
	public static JRadioButton cook;
	public static JRadioButton host;
	public static JRadioButton manager;
	public static JRadioButton waiter;
	public static ButtonGroup group;
	private boolean addPress = false;
	private int addStage = 0;
	private boolean getPress = false;
	private boolean rmPress = false;
	StringTokenizer st;
	private int num = -1;
	private EmployeeType type = EmployeeType.NA;
	private double salary = 0;
	private String name = "";
	private double tipBonus = 0;
	boolean bon = false;
	Restauraunt r = new Restauraunt(10000, 100);
	
	public void createComponents() {
		JFrame frame = new JFrame();
		
		buildingStats = new JButton("Show Statistics");
		ActionListener statsList = new statsListener();
		buildingStats.addActionListener(statsList);
		buildingStats.setPreferredSize(new Dimension(175,25));
		
		newEmployee = new JButton("Add Employee");
		ActionListener newList = new newListener();
		newEmployee.addActionListener(newList);
		newEmployee.setPreferredSize(new Dimension(175,25));
		
		rmEmployee = new JButton("Remove Employee");
		ActionListener rmList = new rmListener();
		rmEmployee.addActionListener(rmList);
		rmEmployee.setPreferredSize(new Dimension(175,25));
		
		getEmployee = new JButton("Get Employee");
		ActionListener getList = new getListener();
		getEmployee.addActionListener(getList);
		getEmployee.setPreferredSize(new Dimension(175,25));
		
		save = new JButton("Save");
		ActionListener saveList = new saveListener();
		save.addActionListener(saveList);
		
		load = new JButton("Load");
		ActionListener loadList = new getListener();
		load.addActionListener(loadList);
		
		area = new JTextArea(15,60);
		area.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				int kc = e.getKeyCode();
				//int num = -1;
				//EmployeeType type = EmployeeType.NA;
				//String name = "";
				//double salary = 0;
				//double tipBonus = 0;
				//boolean bon = false;
				if(kc == KeyEvent.VK_ENTER) {
					if(addPress && addStage == 0) {//=============================== Add
						st = new StringTokenizer(area.getText());
						try {
							st.nextToken(":");
							String sub = st.nextToken(":");
							sub = sub.trim();
							num = Integer.parseInt(sub);
							System.out.println(num);
							if(busBoy.isSelected()) {
								type = EmployeeType.BUSBOY;
							} else if(cook.isSelected()) {
								type = EmployeeType.COOK;
								bon = true;
							} else if(host.isSelected()) {
								type = EmployeeType.HOSTESS;
							} else if(manager.isSelected()) {
								type = EmployeeType.MANAGER;
								bon = true;
							} else {
								type = EmployeeType.WAITER;
							}	
							addStage++;
							area.setText("Enter the employee's name: ");
							for(Employee emp : employees) {
								if(num == emp.getEmpNum()) {
									area.setText("That employee number already exists! Please try again");
									addPress = false;
									addStage = 0;
								}
							}
						} catch(Exception j) {
							area.setText("An error occurred, remember, don't delete the ':' and "
									+ "enter in the right parameters.");
							j.printStackTrace();
						}
						//addPress = false;
						
					} else if(addPress && addStage == 1) {
						//System.out.println(num);
						st = new StringTokenizer(area.getText());
						try {
							st.nextToken(":");
							name = st.nextToken(":");
							name = name.trim();	
							addStage++;
							area.setText("Enter in the Employee's salary: ");
						} catch(Exception j) {
							area.setText("An error occurred, remember, don't delete the ':' and "
									+ "enter in the right parameters.");
							j.printStackTrace();
						}
						
					} else if(addPress && addStage == 2) {
						//System.out.println(num);
						st = new StringTokenizer(area.getText());
						try {
							st.nextToken(":");
							String s = st.nextToken(":");
							s = s.trim();
							salary = Double.parseDouble(s);
							addStage++;
							if(bon) {
								area.setText("Enter in the employees monthly bonus: ");
							} else {
								area.setText("Enter in the employees average tip: ");
							}
						} catch (Exception e2) {
							// TODO: handle exception
							area.setText("An error occurred, remember, don't delete the ':' and "
									+ "enter in the right parameters.");
							e2.printStackTrace();
						}
					} else if(addPress && addStage == 3) {
						//System.out.println(num);
						st = new StringTokenizer(area.getText());
						try {
							st.nextToken(":");
							String s = st.nextToken(":");
							s = s.trim();
							tipBonus = Double.parseDouble(s);
							Employee emp;
							if(type == EmployeeType.BUSBOY) {
								System.out.println(num);
								emp = new BusBoy(name,salary,num,tipBonus);
								System.out.println(num);
								//emp = new BusBoy()
							} else if(type == EmployeeType.COOK) {
								emp = new Cook(name,salary,num,tipBonus);
							} else if(type == EmployeeType.HOSTESS) {
								emp = new Hostess(name,salary,num,tipBonus);
							} else if(type == EmployeeType.MANAGER) {
								emp = new Manager(name, salary,num,tipBonus);
							} else {
								emp = new Waiter(name,salary,num,tipBonus);
							}
							addStage++;
							r.addEmployee(emp);
							System.out.println(num);
							System.out.println(emp.getName() + emp.getEmpNum() + emp.getSalary());
						} catch (Exception e2) {
							// TODO: handle exception
							area.setText("An error occurred, remember, don't delete the ':' and "
									+ "enter in the right parameters.");
							e2.printStackTrace();
						}
					} else if(addPress && addStage ==4) {
						area.setText("Employee added!");
						addStage = 0;
						name = "";
						type = EmployeeType.NA;
						num = -1;
						salary = 0;
						tipBonus = 0;
						addPress = false;
					} else if(getPress) {//====================================== Get
						st = new StringTokenizer(area.getText());
						try {
							st.nextToken(":");
							String sub = st.nextToken(":");
							sub = sub.trim();
							int num1 = Integer.parseInt(sub);
							Employee emp = r.getEmployee(num1);
							if(emp == null) {
								area.setText("That employee doesn't exist!");
							} else {
								if(emp instanceof Cook) { // name salary num bonus
									Cook c = (Cook)emp;
									area.setText("  Employee Num: " + c.getEmpNum() + 
											"\n  Name: " + c.getName() + 
											"\n  Type: " + c.getType() +
											"\n  Salary: " + c.getSalary() + 
											"\n  Bonus: " + c.getBonus());
								} else if(emp instanceof BusBoy) {
									BusBoy b = (BusBoy)emp;
									area.setText("  Employee Num: " + b.getEmpNum() + 
											"\n  Name: " + b.getName() + 
											"\n  Type: " + b.getType() +
											"\n  Salary: " + b.getSalary() + 
											"\n  Bonus: " + b.getTips());
									
								} else if(emp instanceof Manager) {
									Manager m = (Manager)emp;
									area.setText("  Employee Num: " + m.getEmpNum() + 
											"\n  Name: " + m.getName() + 
											"\n  Type: " + m.getType() +
											"\n  Salary: " + m.getSalary() + 
											"\n  Bonus: " + m.getBonus());
								} else if(emp instanceof Hostess) {
									Hostess host = (Hostess)emp;
									area.setText("  Employee Num: " + host.getEmpNum() + 
											"\n  Name: " + host.getName() + 
											"\n  Type: " + host.getType() +
											"\n  Salary: " + host.getSalary() + 
											"\n  Bonus: " + host.getTips());
								} else { // Waiter
									Waiter w = (Waiter)emp;
									area.setText("  Employee Num: " + w.getEmpNum() + 
											"\n  Name: " + w.getName() + 
											"\n  Type: " + w.getType() +
											"\n  Salary: " + w.getSalary() + 
											"\n  Bonus: " + w.getTips());
								}
							}
							
						} catch (Exception e2) {
							e2.printStackTrace();
							area.setText("An error occurred, remember, don't delete the ':' and "
									+ "enter in the right parameters.");
							
						}
						getPress = false;
					} else if(rmPress) {// ====================================== Remove
						st = new StringTokenizer(area.getText());
						try {
							st.nextToken(":");
							String sub = st.nextToken(":");
							sub = sub.trim();
							int num1 = Integer.parseInt(sub);
							//System.out.println("here");
							if(r.rmvEmployee(num1)) {
								area.setText("Employee No. " + num1 + " removed");
							} else {
								area.setText("Employee No. " + num1 + " not found.");
							}
							
							
						} catch (Exception e2) {
							area.setText("An error occurred, remember, don't delete the ':' and "
									+ "enter in the right parameters.");
							e2.printStackTrace();
						}
						rmPress = false;
					} 
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {}
		
		});
		
		busBoy = new JRadioButton("Bus Boy");
		cook = new JRadioButton("Cook");
		host = new JRadioButton("Host");
		manager = new JRadioButton("Manager");
		waiter = new JRadioButton("Waiter");
		busBoy.setSelected(true);
		
		group = new ButtonGroup();
		group.add(busBoy);
		group.add(cook);
		group.add(host);
		group.add(manager);
		group.add(waiter);
		
		
		
		JPanel panel = new JPanel();
		panel.add(buildingStats);
		panel.add(newEmployee);
		panel.add(rmEmployee);
		panel.add(getEmployee);
		panel.add(busBoy);
		panel.add(cook);
		panel.add(host);
		panel.add(manager);
		panel.add(waiter);
		panel.add(area);
		panel.add(save);
		panel.add(load);
		
		frame.add(panel);
		final int FRAME_WIDTH = 800;
		final int FRAME_HEIGHT = 400;
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Restauraunt Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	}
	// Get Employee actions
	class getListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			area.setText("Type employee's number you want to get: ");
			getPress = true;
		}
	}
	// New Employee actions
	class newListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			area.setText("Enter the number of the new employee you would like to add, and "
					+ "select their position above: ");
			addPress = true;
		}
	}
	// Remove Employee actions
	class rmListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			area.setText("Enter the number of the employee you would like to remove: ");
			rmPress = true;
		}
	}
	// Get Statistics actions
	class statsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			area.setText("Total Building Revenue: " + r.getRevenue() +
					"\nBuilding Rent Cost: " + r.getBuildingCost() + 
					"\nTotal Building Costs: " + r.getTotalCosts() + 
					"");
		}
	}
	// Saving actions
	class saveListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			r.save();
			area.setText("Saved!");
		}
	}
	// Loading actions
	class loadListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			r = r.load();
			area.setText("Loaded!");
		}
	}

	public static void main(String args[]) {
		new tester();
	}
}
