String substring(int begin);  // beginから最後まで
String substring(int begin, int end);  // beginからend文字目の文字列を返す。
                                       // "abc".substring(0, 1) = "a"
boolean equals(Oblect str); // 引数の文字列かどうかを判断する

str(n)  //n文字目の文字を返す。

val s = str.updated(n, c)  // str(n) = c

/* List[Char] <-> String */
s.toList   // s を Char list に変換
String.valueOf(cl)  // cl を String に変換

"a"*3 => "aaa"


