import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ReadImage {
	
	public static String getCharValue(int [] finalChars){

		String str = "";
	      for(int i= 0; i<finalChars.length;i++){
	    	  
	    	  str = str+ (char)finalChars[i]; 
	      }
	      return str;
	} 

	public static void main(String[] args){

		int [] finalChars = new int[1000];

		//Chunkify chunkified1 = new Chunkify(0, finalChars);
		//Chunkify chunkified2 = new Chunkify(256, finalChars);
		Chunkify chunkified3 = new Chunkify(511, finalChars) ;
		//Chunkify chunkified4 = new Chunkify(766, finalChars);


		//chunkified1.run();
		//chunkified2.run();
		chunkified3.run();
		//chunkified4.run();

		//System.out.println(" chars: " + ReadImage.getCharValue(finalChars));

		//System.out.println("chars "+chunkified1.getCharValue());
		//System.out.println("chars "+chunkified2.getCharValue());
		System.out.println("chars "+chunkified3.getCharValue());
		//System.out.println("chars "+chunkified4.getCharValue());
		
}

}

