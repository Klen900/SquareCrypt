
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
		
		model.setMatrixIndecies(str);
	
	
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
		//int imageCount = (int)Math.floor(Math.random()*2000);
		
		String imageName = "image"+model.countMatrices+".png";
		
		savedImage = new BufferedImage(this.getSize().width, this.getSize().height, BufferedImage.TYPE_INT_ARGB); 
		
		Graphics g = savedImage.createGraphics();
		this.paint(g);  //this == JComponent
		g.dispose();
		//try{ImageIO.write(savedImage,"png",new File("images/"+imageName));}catch (Exception e) {}
		try{ImageIO.write(savedImage,"png",new File(imageName));}catch (Exception e) {}
	}

	
	public void saveImages(){
		
        // Array of input images.
        BufferedImage[] input = new BufferedImage[5];
         
        // Load each input image.
        // Assume they are called "image_0.png", "image_1.png",
        // etc.
        for ( int i = 0; i < input.length; i++ ) {
            try {
                File f = new File( "image" + i + ".png" );
                input[i] = ImageIO.read( f );
            }
            catch ( IOException x ) {
                // Complain if there is any problem loading 
                // an input image.
                x.printStackTrace();
            }
        }
         
        // Create the output image.
        // It is the same size as the first
        // input image.  I had to specify the type
        // so it would keep it's transparency.
        BufferedImage output = new BufferedImage( 
                1000, 
                1000, 
                BufferedImage.TYPE_INT_ARGB );
         
        // Draw each of the input images onto the
        // output image.
        Graphics g = output.getGraphics();
        int x=0,y =0;
        
        
        for ( int i = 0; i < input.length; i++ ) {
        	
        	System.out.println("y " + y);
        	System.out.println("x " + x);
        	
            g.drawImage( input[i], x, y, null );
            

			x += input[i].getWidth();

			if(x > output.getWidth()){

				x = 0;

				y += input[i].getHeight();

			}
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