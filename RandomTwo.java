import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class RandomTwo {
	public static void main(String[] args) {
		RandomTwo r = new RandomTwo();
		try {
			r.decrypt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String Message(String fileName) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("src/intro_to_file_io/test2.txt"));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
			return sb.toString();
		} finally {
			br.close();
		}
	}
	
	public void decrypt() throws IOException {
		String s = Message("src/intro_to_file_io/test2.txt");
		char[] m = s.toCharArray();
		String o = "";
		for (char message : m ) {
			message = (char) (message - 1);
			o += message;
		}
		System.out.println(o);

	}
}
