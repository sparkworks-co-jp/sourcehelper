package jp.co.sparkworks.sourcehelper;

import java.util.ArrayList;
import java.util.List;

import jp.co.sparkworks.sourcehelper.datastruct.ReplacementDefine;

public class Main {

	public static void main(String[] args) throws Throwable {

		// 対象フォルダ
		String targetFolder = "/Users/CC/git/testhelper/src/main/java";

		// 置換定義
		List<ReplacementDefine> defines = new ArrayList<ReplacementDefine>();
		defines.add(new ReplacementDefine("sparkworks", "sparkworks123"));
		defines.add(new ReplacementDefine("public", "PUBLIC"));

		// doooooooooooo
		ReplacementHelper.replace(targetFolder, defines);
	}

}
