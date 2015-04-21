import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ReadImage {
	
	int[] chars = new int[255];
	String str ="";
	
	public void readColors(){
		
    BufferedImage bi;
	int countloop=0;
	try {
		bi = ImageIO.read(new File("test.png")); 
		
		for (int x = 0; x <bi.getWidth(); x++) {
		    for (int y = 0; y < bi.getHeight(); y++) {
		        Color c = new Color(bi.getRGB(x, y));
		        System.out.println("red=="+c.getRed()+" green=="+c.getGreen()+"    blue=="+c.getBlue()+"  countloop="+countloop++);      
		        System.out.println("y"+ y);
		        
		        //&& (c.getGreen()!=0 || c.getGreen()!=255 )&& (c.getBlue()!=0 || c.getBlue()!=255)
				if( c.getRed()!=0 && c.getRed()!=255 && c.getGreen()!=0 && c.getGreen()!=255 && c.getBlue()!=0 && c.getBlue()!=255  ){
					
					chars[c.getBlue()] = c.getRed();

				}
				
		    }
		   
		}

	} catch (IOException e) {
		
		//e.printStackTrace();
		System.out.print("Image not found");
	}

}
	public String getCharValue(){

      for(int i= 0; i<chars.length;i++){
    	  
    	  str = str+ (char)chars[i];
      }
		return str;
	}
	
	public static void main(String[] args){
		ReadImage readImage = new ReadImage();
		readImage.readColors();
		System.out.println(readImage.getCharValue());

		
	}
}
