package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class FileManager { 
	
	public void save(String filename, String text) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(filename, "UTF-8");
		
		writer.println("%This is a LateX Editor Document.");
		writer.println(text);		
		writer.close();
		
	}
	
	public String load(String filename) throws IOException {
		String content = "";
		
		FileReader fr;
		
		try {
			fr = new FileReader (filename);
			BufferedReader br = new BufferedReader(fr);

			String line;
			
			while ((line = br.readLine()) != null) {
				if (line.startsWith("%")) {
					continue;
					
				} else {
					content += line + '\n';
				}
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return content; 
	}
	
}
