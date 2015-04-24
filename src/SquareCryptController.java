
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SquareCryptController extends JPanel{
	
	JTextField input;
	
	BufferedImage savedImage ;
	
	String str="";
	SquareCryptModel model ;
	
	/**
	 * @return the str
	 */
	public String getStr() {
		return str;
	}

	/**
	 * @param str the str to set
	 */
	public void setStr(String str) {
		this.str = str;
	}


	
	public SquareCryptModel getModel(){
		
		return model;
	}
	
	
	public SquareCryptController() {
		
		super();
		
		 model = new SquareCryptModel();
		
		model.getMatrixIndecies(str);
	
	
		repaint();
		
	}
	
	//Compute the best block size for the current width and height.
	private int	computeBlockSize(){
		
		return getWidth()/255;
	}
	
	//Paint the game.
	public void paint(Graphics g){
		
		//model.matrix[0][1]=34;
		
	

		for(int row=0; row< model.row; row+=1){
			
			for(int col=0; col<model.col;col+=1){
				
				//System.out.println(model.matrix[row][col]);
               //the matrix value will be over 255 at some point so we have to mod it by 255 to stay within the RGB values.
				int b =model.matrix[row][col] %255;
				
				//if the matrix does not have a value of 0 at row & col then, row = x & col = y
                        if( model.matrix[row][col] != 0){
                        	
                        	Color color = new Color(row,col,b );
                        	paintBlock(g,row*computeBlockSize(),col*computeBlockSize(),computeBlockSize(),color);	
                        	
                        }
				   
                        else{
                        	
                            paintBlock(g,row*computeBlockSize(),col*computeBlockSize(),computeBlockSize(),Color.white);	
                        
                      }
			}

		}
	}

	//Paint the block 
	private void paintBlock(Graphics g, int row, int col, int blockSize , Color color){
		
				g.setColor(color);
				//paint block form top left corner
				g.fillRect(col, row, blockSize,blockSize);
				//g.setColor(Color.black);
				//g.drawRect(col, row, blockSize,blockSize);
				
	}

	public void saveImage(){
		int imageCount = (int)Math.floor(Math.random()*2000);
		
		String imageName = "image"+imageCount+".png";
		
		savedImage = new BufferedImage(this.getSize().width, this.getSize().height, BufferedImage.TYPE_INT_ARGB); 
		
		Graphics g = savedImage.createGraphics();
		this.paint(g);  //this == JComponent
		g.dispose();
		try{ImageIO.write(savedImage,"png",new File("images/"+imageName));}catch (Exception e) {}
	}


//	public void saveImages(){
//
//		File file = new File("images");
//
//		File [] moreFile = file.listFiles();
//
//		String [] images = new String [moreFile.length];
//
//
//		for(int i =0; i <images.length; i++){
//
//			images[i] = moreFile[i].getName();
//		}
//		
//		int x = 0;
//
//		int y = 0;
//
//		BufferedImage result = new BufferedImage(
//
//				1000, 1000, //work these out
//
//				BufferedImage.TYPE_INT_RGB);
//
//		Graphics g = result.getGraphics();
//
//		for(String image : images){
// 
//			System.out.println("looping " + image);
//
//			try{
//				
//		
//
//			BufferedImage bi = new BufferedImage(savedImage.getWidth(),savedImage.getHeight(),BufferedImage.TYPE_INT_ARGB);
//			
//			bi =ImageIO.read(new File(image));
//
//			g.drawImage(bi , x , y , null);
//
//			x += bi.getWidth();
//
//			if(x > result.getWidth()){
//
//				x = 0;
//
//				y += bi.getHeight();
//
//			}
//
//			}catch (Exception e) {}
//
//		}
//		
//		g.dispose();
//		
//		try {
//			
//			ImageIO.write(result,"png",new File("result.png"));
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}


		


	//}

}