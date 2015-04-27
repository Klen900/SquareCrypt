import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ReadImage {
	/**
	 * Read image runs the 4 threads that read the image.
	 * it creates 4 objects of Chunkify that takes as a parameter the y value that represents the pixel 
	 * at which each thread should start reading the image.
     * The horizontal division of the image enables us to keep the order. So we just combine the threads respectively in one final string
	 */
	
	public String str ="";

	public void read(){

		Chunkify chunkified1 = new Chunkify(0);
		Chunkify chunkified2 = new Chunkify(256);
		Chunkify chunkified3 = new Chunkify(511) ;
		Chunkify chunkified4 = new Chunkify(766);

		chunkified1.run();
		chunkified2.run();
		chunkified3.run();
		chunkified4.run();

		//final string
		str= str+ chunkified1.getCharValue()+ chunkified2.getCharValue() + chunkified3.getCharValue()+chunkified4.getCharValue();

}

}
