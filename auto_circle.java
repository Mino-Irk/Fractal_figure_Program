import java.applet.*;
import java.awt.*;
import java.awt.image.*;

public class auto_circle extends Applet {

    //------基本変数宣言--------
    Image image;

    int w2 = 600;
    int h2 = 600;

    int pix[] = new int[w2*h2];
    IndexColorModel cm;

    int circle_number=4;
    int n=6;
    int stepChoice = 1;



    public void init() {
	byte re[] = {(byte)0x99,(byte)0x00};
	byte g[] = {(byte)0x99,(byte)0x00};
	byte b[] = {(byte)0x99,(byte)0xff};

	cm = new IndexColorModel(8,2,re,g,b);
	double x,y,r;
	int w=600;
	x=w/2.0; y=x; r=x;
	rcircle(n,x,y,r);
    }


    //--------rcircle-------------------
    public void rcircle
	(int nn, double x, double y, double r) {
	System.out.println("check2");
	if (nn <= 0) { return; }
	double st,d,t,xx,yy,rr;
	//円を描くメソッドを挿入
	setPix((int)((x-r)+r),(int)((y-r)+r),(int)r);

	d=(180.0-360.0/circle_number)/2.0;
	rr=r/(1.0/Math.cos(Math.PI*d/180.0)+1.0);
	t=Math.PI*2.0/circle_number;
	for (int k=0; k<circle_number; k++) {
	    xx=(r-rr)*Math.cos(t*k)+x;
	    yy=(r-rr)*Math.sin(t*k)+y;
	    rcircle(nn-1,xx,yy,rr);
	}
    }

    //--------配列計算部分-----------------
    public void setPix(int r_x, int r_y, int r){
	for(int yyy=1; yyy<h2; yyy++){
	    for(int xxx=1; xxx<w2; xxx++){
		int p = yyy * w2 + xxx;
		int Y = yyy;
		int X = xxx;
		
		double distance = Math.sqrt(Math.pow(X-r_x,2) + Math.pow(Y-r_y,2));
		
		if(Math.abs(distance-r)<=1){
		    pix[p] = 1;
		}
	    }
	}
    }

    //-------描画部分------------------
    public void paint(Graphics g){
	MemoryImageSource mimg = new MemoryImageSource(w2,h2,cm,pix,0,w2);
	image = createImage(mimg);
	g.drawImage(image,0,0,this);
    }
}	