package intro_to_file_io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CopyWriter {
	public static void main(String[] args) {
		CopyWriter cw = new CopyWriter();
		cw.Add();
	}

	public void Add() {
		File path = new File("src");
		System.out.println(path);
		File[] files = path.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].getAbsolutePath().contains(".java")) {
				try {
					System.out.println(files[i].getAbsolutePath());
					FileWriter fw = new FileWriter(files[i].getAbsolutePath(), true);
					fw.write("//Copyright © 2018 by Amanda Li");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
