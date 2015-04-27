import java.awt.Color;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Chunkify extends Thread {

	public int [] chars = new int[1000];

	String str ="";

	int yStart;

	BufferedImage bi;

	//constructor
	public Chunkify(int yStart, BufferedImage image){
		 bi = image;
		this.yStart = yStart;
	}
	@Override
	public void run() {
		try {

			readChunk();

		} catch (InterruptedException e) {
		}

	}

	private synchronized void readChunk() throws InterruptedException {


	

			int k=1;
			int x,y=yStart, j=0;

			while( k<= 2 && j<= bi.getWidth()/2 ){

				for ( x = j; x <k*bi.getWidth()/2; x ++) {

					//y goes down by row
					for ( y = yStart; y < yStart+ 255; y++) {

						Color c = new Color(bi.getRGB(x, y));

						

						if( c.getRed()!=0 && c.getRed()!=255 && c.getGreen()!=0 && c.getGreen()!=255 && c.getBlue()!=0 && c.getBlue()!=255  ){
							// System.out.println("rgb values for red " + c.getRed() + " green " + c.getGreen()+ " blue " + c.getBlue() );
							chars[c.getBlue()] = c.getRed();

						}
				

					}//y

				}//x
				//System.out.println("x " + x);

				k++;
				y=yStart;
				j+= bi.getWidth()/2;
			}//k&j

		

	}
	public String getCharValue(){

		for(int i= 0; i<chars.length;i++){

			str = str+ (char)chars[i];
		}
		return str;
	}



}