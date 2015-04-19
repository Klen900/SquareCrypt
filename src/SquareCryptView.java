import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SquareCryptView extends JPanel implements ActionListener, KeyListener{

	JTextArea input = new JTextArea(20,20); 

	
	JPanel panel;
	
	SquareCryptController controller = new SquareCryptController();

	
	//constructor
	public SquareCryptView(){
		
	
		mainPanel();
	}
	
	public void mainPanel(){
		
		//setLayout(new GridLayout(3,1));
		setLayout(new BorderLayout());
		inputPanel();
		
		//this.add(inputPanel());
		this.add(input,BorderLayout.NORTH);
		this.add(controller,BorderLayout.CENTER);
		this.add(getText(),BorderLayout.SOUTH);
	}
	
	private void inputPanel(){
		 panel = new JPanel();
		 input = new JTextArea();
		// input.setBounds(10, 231, 370, 22);
		 //input.setPreferredSize(new Dimension(getWidth(), getHeight()/3));
		
		//controller.setPreferredSize(new Dimension(500,200));
		
		//panel.add(input);
		//panel.setBackground(Color.yellow);
		//panel.setPreferredSize(new Dimension(getWidth(), getHeight()/3));
		
		//return panel;
		
	}
	
	private JButton getText(){
		JButton button = new JButton("Go");
		
		
		//add action listener
		button.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// get text from input area
				
				String in = input.getText();
				
				controller.setStr(in);
				System.out.println("controller " + controller.getStr());
				controller.repaint();
				System.out.println(input.getText());
                
			}
		});
		
		return button;
		
	}
	
//	private String getInstantText(){
//		
//		
//	}
	
	//Handle the key-pressed event.
	
	public void keyPressed(KeyEvent e){
	
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT){
	
			System.out.println("***********************************************************************");
		}
		
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	
}
