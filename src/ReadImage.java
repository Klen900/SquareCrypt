import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class ReadImage {
	
	BufferedImage image = new BufferedImage(1020,1030,BufferedImage.TYPE_INT_ARGB);



	

	public void read(){
	
		try {
			image = ImageIO.read(new File("images/theImage.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Chunkify chunkified1 = new Chunkify(0, image);
		Chunkify chunkified2 = new Chunkify(256, image);
		Chunkify chunkified3 = new Chunkify(511, image) ;
		Chunkify chunkified4 = new Chunkify(766, image);
		
	//	System.out.println("which file is it " + image.get)


		chunkified1.run();
		chunkified2.run();
		chunkified3.run();
		chunkified4.run();

		String str ="";
//		str= str+ chunkified1.getCharValue()+ chunkified2.getCharValue() + chunkified3.getCharValue()+chunkified4.getCharValue();
	    str= str+ chunkified1.getCharValue();
		System.out.println("str "+str);

}

}