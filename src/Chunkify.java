import java.awt.Color;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Chunkify extends Thread {

	public int[] chars = new int[255];
	String str ="";
	
	int indexStart, indexStop;
	BufferedImage bi;
	
	//constructor
	public Chunkify(int indexStart,int indexStop){
		this.indexStart = indexStart;
		this.indexStop = indexStop;
	
		
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
		
   
	int countloop=0;
	try {
		bi = ImageIO.read(new File("image.png")); 
		
		for (int x = 0; x <bi.getWidth(); x++) {
			System.out.println("loop x");
			//y goes down by row
		    for (int y = 0; y < bi.getHeight() -indexStop; y++) {
		    	
		        Color c = new Color(bi.getRGB(x, y));
		        
		        System.out.println("red=="+c.getRed()+" green=="+c.getGreen()+"    blue=="+c.getBlue()+"  countloop="+countloop++);      
		        System.out.println("y"+ y);
		        System.out.println("x"+ x);
		        
		        //&& (c.getGreen()!=0 || c.getGreen()!=255 )&& (c.getBlue()!=0 || c.getBlue()!=255)
				if( c.getRed()!=0 && c.getRed()!=255 && c.getGreen()!=0 && c.getGreen()!=255 && c.getBlue()!=0 && c.getBlue()!=255  ){
					
					System.out.println("inside if");
					chars[c.getBlue()] = c.getRed();

				}
				
		    }
		   
		}
		
		getCharValue();
		System.out.println("done");


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
