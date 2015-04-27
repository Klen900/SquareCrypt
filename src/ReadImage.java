import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class ReadImage {
<<<<<<< HEAD
	
	public String str ="";

	public void read(){

=======
<<<<<<< HEAD
	
	BufferedImage image = new BufferedImage(1020,1030,BufferedImage.TYPE_INT_ARGB);

=======
>>>>>>> b3fc24825be54ef1bab413f28af7ac39357228f3


<<<<<<< HEAD
	

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

=======
>>>>>>> b8d70eb1581948ea6e2eacadcd966c647e81771f
		Chunkify chunkified1 = new Chunkify(0);
		Chunkify chunkified2 = new Chunkify(256);
		Chunkify chunkified3 = new Chunkify(511) ;
		Chunkify chunkified4 = new Chunkify(766);
>>>>>>> b3fc24825be54ef1bab413f28af7ac39357228f3

		chunkified1.run();
		chunkified2.run();
		chunkified3.run();
		chunkified4.run();

<<<<<<< HEAD
		
=======
		String str ="";
<<<<<<< HEAD
//		str= str+ chunkified1.getCharValue()+ chunkified2.getCharValue() + chunkified3.getCharValue()+chunkified4.getCharValue();
	    str= str+ chunkified1.getCharValue();
		System.out.println("str "+str);
=======
>>>>>>> b8d70eb1581948ea6e2eacadcd966c647e81771f
		str= str+ chunkified1.getCharValue()+ chunkified2.getCharValue() + chunkified3.getCharValue()+chunkified4.getCharValue();
		System.out.println(str);
>>>>>>> b3fc24825be54ef1bab413f28af7ac39357228f3

}

}
