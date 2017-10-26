## フラクタル図形(Java)
#### 入っているプログラム(10/26更新)

* auto.java
	* sampleプログラム(Sierpinski gasket)
* auto_square.java
	* 応用課題1のプログラム
	* Sierpinski carpetという図形 
* auto_spiral.java
	* 応用課題2のプログラム(螺旋)
	* 多分フラクタル図形…ではない．
* auto_circle.java
	* 応用問題2のプログラム(円)
	* 螺旋を元にして作っているが，円の数が多くなるとかなり重くなる欠点がある．
	* フラクタルかどうかは確信がない．
* Applet.html
	* アプレットビューワー起動用のHTMLコード
* **.class
	* Applet.htmlに入力しているコンパイル済みのclassファイル  

	
#### Appletviewrの起動方法
何もインストールする必要はなく，以下のコマンドで起動可能．

	Appletviewr Applet.html
	
初期時点では`auto_circle.class`の図形が起動するようになっているため，別のソースを使用したい場合には，  
**Applet.html**の`code="auto_circle.class"`の部分をその都度書き換える必要がある． 