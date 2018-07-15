import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class RandomOne {
	public static void main(String[] args) {
		RandomOne r = new RandomOne();
		r.Message();
	}

	public void Message() {
		String m = JOptionPane.showInputDialog("Type your message");
		char[] c = m.toCharArray();
		String s = "";
		for (char message : c) {
			message = (char) (message + 1);
			s += message;
		}
		try {
			FileWriter fw = new FileWriter("src/intro_to_file_io/test2.txt");
			fw.write(s);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
//Copyright © 2018 by Amanda Li