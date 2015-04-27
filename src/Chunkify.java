import java.awt.Color;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Chunkify extends Thread {

	public int [] chars = new int[1000];

	String str ="";

	int indexStart, indexStop;

	BufferedImage bi;

	//constructor
	public Chunkify(int indexStart,int indexStop, int[]chars){

		this.indexStart = indexStart;
		this.indexStop = indexStop;
		this.chars = chars;


	}
	@Override
	public void run() {
		try {

			readChunk();
			System.out.println("alive " + indexStart);

		} catch (InterruptedException e) {
		}

	}

	private synchronized void readChunk() throws InterruptedException {


		try {
			bi = ImageIO.read(new File("result.png")); 

			//what is j doing ?
			//why does x increase by bi.getWidth()/2 ??
			

			int k=1;
			int y, j=0;

			while( k<= 2 && j<= bi.getWidth()/2 ){
				System.out.println("k " + k);
				System.out.println("j " + j);
				for (int x = j; x <k*bi.getWidth()/2; x ++) {

					//y goes down by row
					for ( y = 0; y <indexStop; y++) {

						Color c = new Color(bi.getRGB(x, y));

						

						if( c.getRed()!=0 && c.getRed()!=255 && c.getGreen()!=0 && c.getGreen()!=255 && c.getBlue()!=0 && c.getBlue()!=255  ){
							// System.out.println("rgb values for red " + c.getRed() + " green " + c.getGreen()+ " blue " + c.getBlue() );
							chars[c.getBlue()] = c.getRed();

						}

					}//y

				}//x
				k++;
				y=0;
				j+= bi.getWidth()/2;
			}// k&j

		} catch (IOException e) {

			//e.printStackTrace();
			System.out.println("Image not found");

		}

	}
	public String getCharValue(){

		for(int i= 0; i<chars.length;i++){

			str = str+ (char)chars[i];
		}
		return str;
	}



}
