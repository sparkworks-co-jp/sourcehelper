# 機能説明

・指定フォルダの全部ファイル中身の指定文字列を置換する

※現時点テキストファイルのみ対応してますが、今後Excelなども対応予定

# 使用方法

// 対象フォルダ
String targetFolder = "/Users/CC/git/testhelper/src/main/java";

// 置換定義（FROM->TO）
List<ReplacementDefine> defines = new ArrayList<ReplacementDefine>();
defines.add(new ReplacementDefine("sparkworks", "sparkworks123"));
defines.add(new ReplacementDefine("public", "PUBLIC"));

// doooooooooooo
ReplacementHelper.replace(targetFolder, defines);

それで、
プロジェクトのoutputフォルダが作成され、中に中身が置換されたファイルが出力される