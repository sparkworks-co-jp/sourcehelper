package jp.co.sparkworks.sourcehelper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jp.co.sparkworks.sourcehelper.datastruct.ReplacementDefine;
import jp.co.sparkworks.sourcehelper.input.Reader;
import jp.co.sparkworks.sourcehelper.output.Writer;

public class ReplacementHelper {
	static String folder = null;

	public static void replace(String folder, List<ReplacementDefine> defines) throws Throwable {
		ReplacementHelper.folder = folder;
		System.out.println("[" + folder + "] start ");
		System.out.println("[" + defines + "]  ");

		File file = new File(folder);
		if (!file.exists()) {
			System.err.println("Directory Not EXIST:" + folder);
			return;
		}

		if (!file.isDirectory()) {
			System.err.println("Not Directory:" + folder);
			return;
		}

		getAllFiles(file).stream().forEach(r -> {
			replace(r, defines);
		});
	}

	public static void replace(File file, List<ReplacementDefine> defines) {
		List<String> lines = Reader.readText(file);

		boolean hasReplaced = false;
		StringBuffer sb = new StringBuffer();
		StringBuffer replace = new StringBuffer();

		for (String line : lines) {
			String newLine = new String(line);
			for (ReplacementDefine define : defines) {
				newLine = newLine.replaceAll(define.getFrom(), define.getTo());
			}
			sb.append(newLine);
			sb.append(System.lineSeparator());

			if (!newLine.equals(line)) {
				hasReplaced = true;
				replace.append("     ・" + line);
				replace.append(System.lineSeparator());
				replace.append("  　  >" + newLine);
				replace.append(System.lineSeparator());
			}
		}

		String newFileName = file.getAbsolutePath().substring(ReplacementHelper.folder.length());
		if (hasReplaced) {
			System.err.println("■️Replaced:" + newFileName);
			System.out.println(replace.toString());
			Writer.writerText(newFileName, sb.toString());
		} else {
			System.out.println("<No Change>" + newFileName);
		}
	}

	private static List<File> getAllFiles(File folder) {
		List<File> files = new ArrayList<File>();

		for (File file : folder.listFiles()) {
			if (file.isDirectory()) {
				files.addAll(getAllFiles(file));
			} else {
				files.add(file);
			}
		}
		return files;
	}

}
