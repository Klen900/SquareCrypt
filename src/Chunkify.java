import java.awt.Color;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Chunkify extends Thread {

	public int [] chars = new int[1000];
	//public int[] chars;
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
			int limit = bi.getWidth()/2;
			int start = 0;
			int y;
			int count = 0;
			
			int k=1;
			while(k<=2){
				
				 for(int x = start; x<limit; x++){
						for ( y = 0; y <indexStop; y++) {

							Color c = new Color(bi.getRGB(x, y));

							//System.out.println("y"+ y);
//							if(x>510){
//								System.out.println("x"+ x);
//							}

							//&& (c.getGreen()!=0 || c.getGreen()!=255 )&& (c.getBlue()!=0 || c.getBlue()!=255)
							if( c.getRed()!=0 && c.getRed()!=255 && c.getGreen()!=0 && c.getGreen()!=255 && c.getBlue()!=0 && c.getBlue()!=255  ){
								// System.out.println("rgb values for red " + c.getRed() + " green " + c.getGreen()+ " blue " + c.getBlue() );
								//System.out.println("blue***************************************************************************" + c.getBlue());
								chars[c.getBlue()] = c.getRed();

							}

						}
				 }
				 start = bi.getWidth()/2;
				limit = bi.getWidth();
				k++;
				y = 0;
			}
			
			
		//	int k=1;
			
//			while( k<=2 ){
//				for(int j = 0;j<=bi.getWidth()/2 ; j+= bi.getWidth()/2){
//					System.out.println("how many times does this happen");
//					for (int x = j; x <k*bi.getWidth()/2; x ++) {
//						count ++;
//						System.out.println("Let's count this shit " + count );
//						//y goes down by row
//						for ( y = 0; y <indexStop; y++) {
//
//							Color c = new Color(bi.getRGB(x, y));
//
//							//System.out.println("y"+ y);
////							if(x>510){
////								System.out.println("x"+ x);
////							}
//
//							//&& (c.getGreen()!=0 || c.getGreen()!=255 )&& (c.getBlue()!=0 || c.getBlue()!=255)
//							if( c.getRed()!=0 && c.getRed()!=255 && c.getGreen()!=0 && c.getGreen()!=255 && c.getBlue()!=0 && c.getBlue()!=255  ){
//								// System.out.println("rgb values for red " + c.getRed() + " green " + c.getGreen()+ " blue " + c.getBlue() );
//								//System.out.println("blue***************************************************************************" + c.getBlue());
//								chars[c.getBlue()] = c.getRed();
//
//							}
//
//						}
//
//					}
//					//end of x for loop
//				}
//				//end of j for loop
//				k++;
//				y=0;
//			}

		//	getCharValue();	


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