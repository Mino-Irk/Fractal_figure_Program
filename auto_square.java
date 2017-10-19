import java.applet.*;
import java.awt.*;
import java.awt.image.*;

public class auto_square extends Applet{

    //------基本変数宣言-------
    Image image;

    int w = 594; //画面表示用(図形のどこを表示するか？)
    int h = 594;

    int pix[] = new int[w*h];
    IndexColorModel cm;

    //------カラー等の初期設定-------------------
    public void init(){
	byte r[] = {(byte)0x99,(byte)0x00};
	byte g[] = {(byte)0x99,(byte)0x00};
	byte b[] = {(byte)0x99,(byte)0xff};

	cm = new IndexColorModel(8,2,r,g,b);

	setPix();
    }
    
    //-----配列計算部分--------------------
    public void setPix(){
	//pix[w/2] = 1;
	pix[0] = 1;
	for(int y=1; y<h; y++){
	    for(int x=1; x<w; x++){
		int p = y * w + x;

		int X = x;
		int Y = (p-x)/w;

		while(Y!=0 && X!=0){
		    if(Y % 3 == 1 && X % 3 == 1){
			pix[p] = 0;
			break;
		    }else{
			pix[p] = 1;
		    }
		    X /= 3;
		    Y /= 3;
		}

	    }
	}
    }
    
    //-------図形描写-----------
    public void paint(Graphics g){
	MemoryImageSource mimg = new MemoryImageSource(w,h,cm,pix,0,w);
	image = createImage(mimg);
	g.drawImage(image,0,0,this); 
	//0はどこからdrawするかの座標(100,100にするとwindowから100,100だけずれる)
    }
}