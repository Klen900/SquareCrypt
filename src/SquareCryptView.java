import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

import java.util.TimerTask;

public class SquareCryptView extends JPanel implements ActionListener{

	JTextArea input = new JTextArea(20,20); 

	JButton auto; 
	JButton goButton;
	JButton save;
	JPanel panel;
	JPanel anotherPanel;
	
	SquareCryptController controller = new SquareCryptController();
	SquareCryptModel model = controller.getModel();
		
	
	//constructor
	public SquareCryptView(){
		
		mainPanel();
	}
	
	public void mainPanel(){
		anotherPanel = new JPanel();
		anotherPanel.setLayout(new BoxLayout(anotherPanel, BoxLayout.X_AXIS));
		
		//setLayout(new GridLayout(3,1));
		auto = new JButton("Update Automatically");
		auto.addActionListener(this);
		save = new JButton("save");
		save.addActionListener(this);
		 goButton = new JButton("Go");
		 goButton.addActionListener(this);
		setLayout(new BorderLayout());
		inputPanel();
		anotherPanel.add(goButton);
		anotherPanel.add(auto);
		anotherPanel.add(save);
		
		//this.add(inputPanel());
		this.add(input,BorderLayout.NORTH);
		this.add(controller,BorderLayout.CENTER);
		this.add(anotherPanel,BorderLayout.SOUTH);
	}
	
	private void inputPanel(){
		 panel = new JPanel();
		// input.setBounds(10, 231, 370, 22);
		 //input.setPreferredSize(new Dimension(getWidth(), getHeight()/3));
		
		//controller.setPreferredSize(new Dimension(500,200));
		
		//panel.add(input);
		//panel.setBackground(Color.yellow);
		//panel.setPreferredSize(new Dimension(getWidth(), getHeight()/3));
		
		//return panel;
		
	}
	
	
	
//	private String getInstantText(){
//		
//		
//	}
	
	//Handle the key-pressed event.
	
	public void actionPerformed(ActionEvent e){
		
		JButton buttonPressed = (JButton) e.getSource();
		String in;
		if (buttonPressed.equals(auto)){
			
		
			autoUpdate();
			
		}
		else if (buttonPressed.equals(goButton)){
			
			in = input.getText();
			
			controller.setStr(in);
			System.out.println("controller " + controller.getStr());
			controller.repaint();
			System.out.println(input.getText());
		}
		else if (buttonPressed.equals(save)){
			controller.saveImage();
			
		}
				
		
	}

	public void autoUpdate(){
	input.getDocument().addDocumentListener(new DocumentListener(){

		String in;
	 @Override
     public void insertUpdate(DocumentEvent de) {
		 
		 
		int textLngth = input.getText().length();
		 System.out.println(input.getText().substring(textLngth-1, textLngth));
		 in = input.getText().substring(textLngth-1, textLngth);
		 controller.setStr(in);
		 System.out.println("text" +  controller.getStr());
		 controller.repaint();
     }

     @Override
     public void removeUpdate(DocumentEvent de) {
    	    
    	 System.out.println("DELETE DELETE DELETE");
    	 
 		int textLngth = input.getText().length();
    	 
    	 
    	 //search through for position text.Lngth()+1
    	 for(int i=0; i<model.row; i++){
 			for(int j =0;j<model.col; j++ ){
 				
 				if(model.matrix[i][j] == textLngth){
 					
 					model.matrix[i][j] = 0;
 					break;
 				}
 				
 	
 			}
    	 }
    	 //find x,y position of in
    	 //change to 0
    	 //repaint
		 controller.repaint();
    	 
     }

     @Override
     public void changedUpdate(DocumentEvent de) {
     }

	});
	
	}

}
