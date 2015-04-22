import java.awt.Color;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ReadImage {

	
	public static void main(String[] args){
	

		Chunkify chunkified1 = new Chunkify(0,50);
		Chunkify chunkified2 = new Chunkify(50,100);
		Chunkify chunkified3 = new Chunkify(100,150);
		Chunkify chunkified4 = new Chunkify(150,200);
		
		chunkified1.run();
		chunkified2.run();
		chunkified3.run();
		chunkified4.run();
		
		System.out.println("chars "+chunkified1.getCharValue());
		
	}
}
