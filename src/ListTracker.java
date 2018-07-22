import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ListTracker implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton add;
	JButton remove;
	JButton save;
	JButton load;
	String newTask = "";
	ArrayList<String>aL = new ArrayList<String>();
	
	public static void main(String[] args) {
		ListTracker tracker = new ListTracker();
		tracker.createUI();
	}
	
	public void createUI(){
		frame = new JFrame();
		panel = new JPanel();
		add = new JButton("Add Task");
		remove = new JButton("Remove Task");
		save = new JButton("Save Task");
		load = new JButton("Load Task");
		frame.setVisible(true);
		frame.add(panel);
		panel.add(add);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(add)) {
			newTask = JOptionPane.showInputDialog("Type A New Task");
			aL.add(newTask);
			System.out.println(aL);
		}
		if (e.getSource().equals(remove)) {
			String s;
			s = JOptionPane.showInputDialog("Type the task you would like to remove");
			for (int i = 0; i < aL.size() - 1; i++) {
				if (aL.get(i).equals(s)) {
					aL.remove(i);
					JOptionPane.showMessageDialog(null, " Your task has been removed");
				} else {
					JOptionPane.showMessageDialog(null, "Task does not exist");
				}
				System.out.println(aL);
			}
		}
		if (e.getSource().equals(save)) {
			try {
				FileWriter fw = new FileWriter("src/intro_to_file_io/test2.txt", true);
				fw.write("\n" + newTask);
				fw.close();
			} catch (IOException f) {
				f.printStackTrace();
			}
		}
		if (e.getSource().equals(load)) {
			try {
				BufferedReader br = new BufferedReader(new FileReader("src/intro_to_file_io/test2.txt"));
				
				String line = br.readLine();
				while(line != null){
					aL.add(line);
					line = br.readLine();
				}
				
				br.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			System.out.println(aL);
			JOptionPane.showMessageDialog(null, aL);
		}
	}
}
