import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ReadImage {
	public static String getCharValue(int [] finalChars){
<<<<<<< HEAD
=======

		String str = "";
	      for(int i= 0; i<finalChars.length;i++){
	    	  System.out.println("first letter " + (char) finalChars[0]);
	    	  
	    	   str = str+ (char)finalChars[i];
	    	   
	      }
			return str;
		}
	


>>>>>>> 65cb317e74fe966f4a304900025efc0fe1dc573d

		String str = "";
	      for(int i= 0; i<finalChars.length;i++){
	    	  System.out.println("first letter " + (char) finalChars[0]);
	    	  
	    	   str = str+ (char)finalChars[i];
	    	   
	      }
			return str;
		}  
	

	public static void main(String[] args){

	
<<<<<<< HEAD
=======
		
//		 int[] chars1 = new int[255];
//		 int[] chars2 = new int[255];
//		 int[] chars3 = new int[255];
//		 int[] chars4 = new int[255];
	
>>>>>>> 65cb317e74fe966f4a304900025efc0fe1dc573d
		 int [] finalChars = new int[200];
		 
		//x=510 × y= 439
		Chunkify chunkified1 = new Chunkify(0,100, finalChars);
    	Chunkify chunkified2 = new Chunkify(101,200, finalChars);
		Chunkify chunkified3 = new Chunkify(201,300, finalChars) ;
		Chunkify chunkified4 = new Chunkify(301,439, finalChars);
<<<<<<< HEAD

		
=======
		
//		Chunkify chunkified1 = new Chunkify(0,100,chars1);
//    	Chunkify chunkified2 = new Chunkify(101,200,chars2);
//		Chunkify chunkified3 = new Chunkify(201,300,chars3);
//		Chunkify chunkified4 = new Chunkify(301,439,chars4);
//		
>>>>>>> 65cb317e74fe966f4a304900025efc0fe1dc573d
		chunkified1.run();
		chunkified2.run();
		chunkified3.run();
		chunkified4.run();
		
		System.out.println(" I hope this works " + ReadImage.getCharValue(finalChars));
<<<<<<< HEAD
		
		System.out.println("chars "+chunkified1.getCharValue());
		System.out.println("chars "+chunkified2.getCharValue());
		System.out.println("chars "+chunkified3.getCharValue());
		System.out.println("chars "+chunkified4.getCharValue());
		
		
=======
//		
//		System.out.println("chars "+chunkified1.getCharValue());
//		System.out.println("chars "+chunkified2.getCharValue());
//		System.out.println("chars "+chunkified3.getCharValue());
//		System.out.println("chars "+chunkified4.getCharValue());
		
		
}
>>>>>>> 65cb317e74fe966f4a304900025efc0fe1dc573d
}
}
