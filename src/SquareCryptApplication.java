import java.awt.Dimension;

import javax.swing.JFrame;

public class SquareCryptApplication
{
	
	/**
	 * Start the game!
	 * 
	 * @param args
	 */
	
	public static void main( String[] args )
	{
		
		// create a new JFrame to hold a new controller instance
		JFrame frame = new JFrame("SquareCrypt");
		
		// set size changed width to 810 because it's divisible by 18 which will make each block of height 45 
		//changed width to 450 to make the width of the blocks to 45 so that they make squares
		//tetrisFrame.setSize( 450, 810 );
		frame.setSize( 510,950);
		frame.setResizable(false);

		// make a new controller instance and add it
		frame.add( new SquareCryptView() );

		// exit normally on closing the window
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		// show frame
		frame.setVisible( true );		
	}
}