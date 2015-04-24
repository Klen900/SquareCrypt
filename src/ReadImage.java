import java.awt.Color;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ReadImage {

	
	public static void main(String[] args){
	
		
		 int[] chars1 = new int[255];
		 int[] chars2 = new int[255];
		 int[] chars3 = new int[255];
		 int[] chars4 = new int[255];
	
		 
		//x=510 × y= 439
//		Chunkify chunkified1 = new Chunkify(0,100,chars1);
//    	Chunkify chunkified2 = new Chunkify(101,200,chars2);
//		Chunkify chunkified3 = new Chunkify(201,300,chars3);
//		Chunkify chunkified4 = new Chunkify(301,439,chars4);
		
		Chunkify chunkified1 = new Chunkify(0,100,chars1);
    	Chunkify chunkified2 = new Chunkify(101,200,chars2);
		Chunkify chunkified3 = new Chunkify(201,300,chars3);
		Chunkify chunkified4 = new Chunkify(301,439,chars4);
//		
		chunkified1.run();
		chunkified2.run();
		chunkified3.run();
		chunkified4.run();
//		
		System.out.println("chars "+chunkified1.getCharValue());
		System.out.println("chars "+chunkified2.getCharValue());
		System.out.println("chars "+chunkified3.getCharValue());
		System.out.println("chars "+chunkified4.getCharValue());
		
	}
}
