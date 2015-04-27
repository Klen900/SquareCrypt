
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
	SquareCryptView view;

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
		
		model.setMatrixIndecies(str);
	
	
		repaint();
		
	}
	
	//Compute the best block size for the current width and height.
	private int	computeBlockSize(){
		
		return getWidth()/255;
	}
	
	//Paint the game.
	public void paint(Graphics g){

		for(int row=0; row< model.row; row+=1){
			
			for(int col=0; col<model.col;col+=1){
				
               //the matrix value will be over 255 at some point so we have to mod it by 255 to stay within the RGB values.
				int b =model.matrix[row][col] %255;
				
				//if the matrix does not have a value of 0 at row & col then, row = x & col = y
                        if( model.matrix[row][col] != -1){
                        	
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

	public void saveImage(int count){
		//int imageCount = (int)Math.floor(Math.random()*2000);
		 System.out.println("count " + count);
		
		String imageName = "image"+count+".png";
		
		
		//savedImage = new BufferedImage(this.getSize().width, this.getSize().height, BufferedImage.TYPE_INT_ARGB);
		savedImage = new BufferedImage(510, 255, BufferedImage.TYPE_INT_ARGB); 
		
		Graphics g = savedImage.createGraphics();
		this.paint(g);  //this == JComponent
		g.dispose();
		//try{ImageIO.write(savedImage,"png",new File("images/"+imageName));}catch (Exception e) {}
		try{ImageIO.write(savedImage,"png",new File(imageName));}catch (Exception e) {}
	}

	
	public void saveImages(int count){
		
        // Array of input images.
		System.out.println("count " +count);
		//count must start at 1 and not 0 because we can't have array of size zero
        BufferedImage[] input = new BufferedImage[count+1];
         
        // Load each image.
        for ( int i = 1; i < input.length; i++ ) {
            try {
                File f = new File( "image" + i + ".png" );
                input[i] = ImageIO.read( f );
                
              System.out.println(f.getName());
            }
            catch ( IOException x ) {
                x.printStackTrace();
            }
        }
         
        // Create the output image. 1020*1020
        BufferedImage output = new BufferedImage(1020,1030,BufferedImage.TYPE_INT_ARGB );
         
        // Draw each of the input images onto the
        // output image.
        Graphics g = output.getGraphics();
        
        int x=0,y =0;
        
        for ( int i = 1; i < input.length; i++ ) {
        	
            g.drawImage( input[i], x, y, null );
            

			x += 510;

			if(x >= output.getWidth()){

				x = 0;

				y += 255;

			}
			System.out.println("i " + i + "y " +y );
        }
         
        // Create the output image file and write the
        // output image to it.
        File f = new File( "result.png" );
        try {
            ImageIO.write( output, "PNG", f );
        }
        catch ( IOException e ) {
            // Complain if there was any problem writing 
            // the output file.
            e.printStackTrace();
        }       
    
	}

}