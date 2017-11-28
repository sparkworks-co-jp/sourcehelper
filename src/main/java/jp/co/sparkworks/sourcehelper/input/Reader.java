package jp.co.sparkworks.sourcehelper.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Reader {

	public static List<String> readText(String fileName) throws Throwable {
		return readText(new File(fileName));
	}

	public static List<String> readText(File file) {
		List<String> lines = new ArrayList<String>();
		try {

			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			while (line != null) {
				lines.add(line);
				line = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return lines;
	}

}
