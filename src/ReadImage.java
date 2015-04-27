import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ReadImage {

	public static void main(String[] args){

		Chunkify chunkified1 = new Chunkify(0);
		Chunkify chunkified2 = new Chunkify(256);
		Chunkify chunkified3 = new Chunkify(511) ;
		Chunkify chunkified4 = new Chunkify(766);

		chunkified1.run();
		chunkified2.run();
		chunkified3.run();
		chunkified4.run();

		String str ="";
		str= str+ chunkified1.getCharValue()+ chunkified2.getCharValue() + chunkified3.getCharValue()+chunkified4.getCharValue();
		System.out.println(str);

}

}
