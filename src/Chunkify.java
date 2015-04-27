import java.awt.Color;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Chunkify extends Thread {

	public int [] chars = new int[2040];//255*8 we can process up to  8 images that take 255 chars each

	String str ="";

	int yStart;

	BufferedImage bi;

	//constructor
<<<<<<< HEAD
	public Chunkify(int yStart, BufferedImage image){
		 bi = image;
=======
	public Chunkify(int yStart){

>>>>>>> b3fc24825be54ef1bab413f28af7ac39357228f3
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


<<<<<<< HEAD
		try {
			//bi = ImageIO.read(new File("result.png")); 
			 bi = ImageIO.read(new File("images/theImage.png"));
=======
	

>>>>>>> b8d70eb1581948ea6e2eacadcd966c647e81771f
			int k=1;
			int x,y=yStart, j=0;

			while( k<= 2 && j<= bi.getWidth()/2 ){

				for ( x = j; x <k*bi.getWidth()/2; x ++) {

					//y goes down by row
					for ( y = yStart; y < yStart+ 255; y++) {

						Color c = new Color(bi.getRGB(x, y));


						if( c.getRed()!=0 && c.getRed()!=255 && c.getGreen()!=0 && c.getGreen()!=255 && c.getBlue()!=0 && c.getBlue()!=255  ){
							
							chars[c.getBlue()] = c.getRed();

						}

					}//y

				}//x
<<<<<<< HEAD
				//System.out.println("x " + x);
=======
>>>>>>> b3fc24825be54ef1bab413f28af7ac39357228f3

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
