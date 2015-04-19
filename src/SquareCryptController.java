
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

public class SquareCryptController extends JPanel{
	
	JTextField input;
	
	String str="";
	
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

	SquareCryptModel model = new SquareCryptModel();
	
	public SquareCryptController() {
		
		super();
		
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
		
		model.getMatrixIndecies(str);

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
		
		BufferedImage bi = new BufferedImage(this.getSize().width, this.getSize().height, BufferedImage.TYPE_INT_ARGB); 
		Graphics g = bi.createGraphics();
		this.paint(g);  //this == JComponent
		g.dispose();
		try{ImageIO.write(bi,"png",new File("test.png"));}catch (Exception e) {}
	}
	

}