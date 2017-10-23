import java.applet.*;
import java.awt.*;
import java.awt.image.*;
import java.lang.Math;

public class auto_spiral extends Applet{

    //------基本変数宣言-------
    Image image;

    int w = 300; //画面表示用(図形のどこを表示するか？)
    int h = 300;

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
    
    //-----????--------------------
    public void setPix(){
	double r_x = w/2; //半径(横座標)
	double r_y = h/2; //半径(縦縦座標)
	double r = h/2; //半径(判定用)
	pix[w/2] = 1;
	int flag = -1;

	while(r>=1){
       


	    flag = (-1) * flag;
	    for(int y=1; y<h; y++){
		for(int x=1; x<w; x++){
		    int p = y * w + x;
		    int Y = (p-x)/w;
		    int X = x;
		    
		    //System.out.println("x="+X+"：y="+Y+"：r="+(Math.pow(X-r,2))+"："+((X-r)^2 + (Y-r)^2));
		    double distance = Math.sqrt(Math.pow(X-r_x,2) + Math.pow(Y-r_y,2));//中心点までの距離を計算(中心点はxは不変，yは変数)
		    //System.out.println(distance);

		    if(Math.abs(distance-r)<=1 && (X-r_x)*flag >= 0){
			pix[p] = 1;
		    }
		    
		    
		}
	    }
	    r = r*0.9;
	    if(flag == 1){
		r_y = r_y+((r/0.9)*0.1);
	    }else{
		r_y = r_y-((r/0.9)*0.1);
	    }
	
	}
    }
    
    public void paint(Graphics g){
	MemoryImageSource mimg = new MemoryImageSource(300,300,cm,pix,0,w);
	image = createImage(mimg);
	g.drawImage(image,0,0,this); 
	//0はどこからdrawするかの座標(100,100にするとwindowから100,100だけずれる)
    }
}