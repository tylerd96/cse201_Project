import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
	
	public void createComponents() {
		JFrame frame = new JFrame();
		
		buildingStats = new JButton("Show Statistics");
		ActionListener statsList = new statsListener();
		buildingStats.addActionListener(statsList);
		
		newEmployee = new JButton("Add Employee");
		ActionListener newList = new newListener();
		newEmployee.addActionListener(newList);
		
		rmEmployee = new JButton("Remove Employee");
		ActionListener rmList = new rmListener();
		rmEmployee.addActionListener(rmList);
		
		getEmployee = new JButton("Get Employee");
		ActionListener getList = new getListener();
		getEmployee.addActionListener(getList);
		
		save = new JButton("Save");
		ActionListener saveList = new saveListener();
		save.addActionListener(saveList);
		
		load = new JButton("Load");
		ActionListener loadList = new getListener();
		load.addActionListener(loadList);
		
		area = new JTextArea(15,60);
		
		
		
		JPanel panel = new JPanel();
		panel.add(buildingStats);
		panel.add(newEmployee);
		panel.add(rmEmployee);
		panel.add(getEmployee);
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
			
		}
	}
	// New Employee actions
	class newListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	// Remove Employee actions
	class rmListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	// Get Statistics actions
	class statsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	// Saving actions
	class saveListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	// Loading actions
	class loadListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public static void main(String args[]) {
		new tester();
	}
}
