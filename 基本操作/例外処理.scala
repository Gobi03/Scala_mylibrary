// 例外（Throwable（Exception・Error））を発生させる（投げる・スローする・throw）。
throw 例外
throw new Exception("メッセージ")
throw new Exception("error")


// 発生した例外をキャッチする（捕捉する・catch）。
try {
  式
  …
} catch {
  case 変数:例外クラス => 式1
  …
} finally {
  式
}
