package jp.co.sparkworks.sourcehelper.output;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Writer {

	private static String FOLDER = "./output";

	// 一回の実施でフォルダ名を固定するため、staticに定義している
	private static String timestamp = null;

	public static void writerText(String fileName, String contents) {
		String foldername = getFolderName();
		String filename = fileName;
		File file = new File(foldername, filename);
		try {
			writerToFile(file, contents);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static void writerToFile(File file, String contents) throws Throwable {

		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}

		FileWriter filewriter = new FileWriter(file);
		filewriter.write(contents);
		filewriter.flush();
		filewriter.close();
	}

	private static String getFolderName() {
		String folderName = FOLDER + "/replacement-" + getTimeStamp();

		return folderName;
	}

	private static String getTimeStamp() {
		if (timestamp == null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
			timestamp = LocalDateTime.now().format(formatter).toString();
		}
		return timestamp;
	}

}
