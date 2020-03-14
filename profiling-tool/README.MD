Javaのプロファイリングツールまとめ

## VisualVM

Oracle公式のJVMプロファイリングツール。GUIベース。
Javaで実装されている。

https://visualvm.java.net/ja/gettingstarted.html

* 計測対象
  * ローカルで走ってるJavaプロセス
  * jmxremoteでポートを開けているJavaプロセス
* 出力
  * リソース消費グラフ
  * メソッドやクラスごとのリソース（CPU、メモリ）所要量・比率
  * プラグインで色々なことができる。（CSV、HTMLエクスポートなども）

## HPROF

Javaがデフォルトで備えているプロファイリング機能。
プロファイリングした結果をCUIで色々吐き出してくれるらしい。

* 計測対象
  * 自身のプロセス
* 出力
  * CUIベースの統計結果？