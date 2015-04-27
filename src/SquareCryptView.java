
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
=======
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
<<<<<<< HEAD

=======
>>>>>>> b3fc24825be54ef1bab413f28af7ac39357228f3
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import javax.swing.plaf.FileChooserUI;
>>>>>>> b8d70eb1581948ea6e2eacadcd966c647e81771f

/**
 * This class creates the GUI view for this project, by organizing all of its components
 * and tying their functionality by handling the events run by the model, controller and image reader.
 * 
 * There are 2 main components to this view:
 *         *Top:
 *             The start button enables the recording of the user input, which changes the matrix values in the model & paints it in the controller
 *         *Center:
 *             After every 255 characters entered, the view creates a new controller with a new matrix and paints it.
 *         *South:
 *             
 *         
 * 
 * @author elkha22n
 *
 */

public class SquareCryptView extends JPanel implements ActionListener{

	//challenges

	//which model is the controller talking to when creating the second one?

	//pixel size

	//delete was a challenge! because it was taking the last char instead of ...problem with count wasn't updating correctly

	//what string was passed to model?

	//buffered image ,saves the whole panel. why?

	//layout of controller images
<<<<<<< HEAD
	
	JTextArea input = new JTextArea(20,20);


=======


	JTextArea input = new JTextArea();;

>>>>>>> b3fc24825be54ef1bab413f28af7ac39357228f3
	JButton auto; 

	JButton clear;

	JButton save;
<<<<<<< HEAD
	
	//button to upload image to read!!
=======
<<<<<<< HEAD
	//button to upload image to read!!
	JButton upload;
	JButton read;
=======
>>>>>>> b8d70eb1581948ea6e2eacadcd966c647e81771f
	JButton upload;
	JButton read;
	

>>>>>>> b3fc24825be54ef1bab413f28af7ac39357228f3
	JPanel panel = new JPanel();

	JPanel anotherPanel;

	JPanel imagePanel;
	
	JTextArea title;
	JTextArea instruction;

	public int count =0; 

	SquareCryptController controller = new SquareCryptController();
	SquareCryptModel model = controller.getModel();
	//constructor

	public SquareCryptView(){

		mainPanel();

	}

	public void mainPanel(){
		
		setBackground(new Color(0,0,102));
		
	
		
		
		title = new JTextArea("                                 SquareCrypt");
		instruction = new JTextArea("          Press Start and enter the text you want to encrypt!                               "
				+ "When you are done typing, press save.");
		
		title.setEditable(false);
		instruction.setEditable(false);
	   
		anotherPanel = new JPanel();

		anotherPanel.setLayout(new BoxLayout(anotherPanel, BoxLayout.X_AXIS));

		input.setLineWrap(true);
		
		//keep scrolling when input goes beyond the JTextArea height
//		DefaultCaret caret = (DefaultCaret)input.getCaret();
//		caret.setUpdatePolicy(DefaultCaret.OUT_BOTTOM);
		JScrollPane jScrollPane=new JScrollPane(input);
		auto = new JButton("Start");
		
		add(jScrollPane, BorderLayout.CENTER);
        // arbitrary size to make vertical scrollbar appear
        setSize(240, 240);
        setVisible(true);

<<<<<<< HEAD
=======
		//input.setWrapStyleWord(true);

		//input.setResizable(false);

		//setLayout(new GridLayout(3,1));
<<<<<<< HEAD
		read = new JButton("Read Image!");
		read.addActionListener(this);
		upload = new JButton("Upload Image");
		upload.addActionListener(this);
=======

>>>>>>> b3fc24825be54ef1bab413f28af7ac39357228f3
		auto = new JButton("Go");
>>>>>>> b8d70eb1581948ea6e2eacadcd966c647e81771f

		auto.addActionListener(this);

		
		save = new JButton("Save");

		save.addActionListener(this);

		clear = new JButton("Clear All");

		clear.addActionListener(this);
		
		read = new JButton("Read Image!");
		read.addActionListener(this);
		
		upload = new JButton("Upload Image");
		upload.addActionListener(this);
		

		setLayout(new BorderLayout());
		//**************************************
		//set button color
		save.setBackground(Color.green);
		save.setOpaque(true);
		save.setBorderPainted(false);
		
		clear.setBackground(Color.RED);
		clear.setOpaque(true);
		clear.setBorderPainted(false);
		 
		upload.setBackground(Color.white);
		upload.setOpaque(true);
		upload.setBorderPainted(false);
		
		read.setBackground(Color.yellow);
		read.setOpaque(true);
		read.setBorderPainted(false);
		
		

		anotherPanel.add(save);
		anotherPanel.add(clear);
		anotherPanel.add(upload);
<<<<<<< HEAD
		anotherPanel.add(read);
		
		anotherPanel.setBackground(new Color(0,0,102));
		//**************************************
=======
<<<<<<< HEAD
		anotherPanel.add(read);
>>>>>>> b8d70eb1581948ea6e2eacadcd966c647e81771f


		
		JScrollPane scrollPane = new JScrollPane(panel);
		
=======

>>>>>>> b3fc24825be54ef1bab413f28af7ac39357228f3
		imagePanel = new JPanel();

		imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));


		imagePanel.add(controller);
		imagePanel.setBackground(new Color(0,0,102));
		
		this.add(topText(),BorderLayout.NORTH);
		//this.add(title,BorderLayout.NORTH);

		this.add(imagePanel,BorderLayout.CENTER);

		//this.add(controller,BorderLayout.CENTER);

		this.add(anotherPanel,BorderLayout.SOUTH);

	}
	
	public JPanel titleText(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));

        title.setPreferredSize(new Dimension(510,5));
		 Font font = new Font("Serif", Font.BOLD, 25);
		 title.setFont(font);
        title.setBackground(Color.yellow);
   	    panel.add(title);
        panel.add(instructionPanel());
    	
		
		return panel;
	}
	
	//this panel holds the instruction sentence and the start button
	public JPanel instructionPanel(){
		 JPanel panel = new JPanel();
		 Font font = new Font("Serif", Font.BOLD, 15);
		 instruction.setFont(font);
		 auto.setPreferredSize(new Dimension(80,10));
    	 
		 panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		 panel.add(instruction);
		 panel.setBackground(new Color(0,0,102));
		 instruction.setPreferredSize(new Dimension(430,10));
		 instruction.setLineWrap(true);
		 instruction.setBackground(new Color(0,0,102));
		 instruction.setForeground(Color.white);
		 
			//set button color
		 auto.setBackground(Color.yellow);
		 auto.setOpaque(true);
		 auto.setBorderPainted(false);
			
		 panel.add(auto);
		 
		 return panel;
	}

    public JPanel topText(){
    	
    	 JPanel panel = new JPanel();
    	 panel.setLayout(new GridLayout(2,1));
    	 input.setPreferredSize(new Dimension(510,50));
         panel.add(titleText());
    	 panel.add(input);
    	 panel.setPreferredSize(new Dimension(510,200));
    	
    	 
    	return panel;
    }
    
	//Handle the key-pressed event.
	public void actionPerformed(ActionEvent e){

		JButton buttonPressed = (JButton) e.getSource();

		String in;

		if (buttonPressed.equals(auto)){

			autoUpdate();

		}
<<<<<<< HEAD
=======

>>>>>>> b3fc24825be54ef1bab413f28af7ac39357228f3
		else if (buttonPressed.equals(clear)){

			count = 0;

			input.setText("");

			model.clearAll();

			validate();

			imagePanel.removeAll();

			imagePanel.updateUI();

			//controller.repaint();

		}

		else if (buttonPressed.equals(save)){
<<<<<<< HEAD
			 count++;
            controller.saveImage(count);
			controller.saveImages(count);

		}
		else if(buttonPressed.equals(upload)){
		FileChooserDemo upload1 = new FileChooserDemo();
			 upload1.createAndShowGUI();
			 upload1.getFile().getName();
				

		}
		else if(buttonPressed.equals(read)){
			//pass the image to the controller!!
			ReadImage reader = new ReadImage();
			reader.read();
			
=======

			count++;

			controller.saveImage(count);

			controller.saveImages(count);

		}	else if(buttonPressed.equals(upload)){
			FileChooserDemo upload1 = new FileChooserDemo();
			 upload1.createAndShowGUI();
			 upload1.getFile().getName();
				

		}
		else if(buttonPressed.equals(read)){
			//pass the image to the controller!!
			ReadImage reader = new ReadImage();
			reader.read();
			input.setText(reader.str);
			
		}
>>>>>>> b3fc24825be54ef1bab413f28af7ac39357228f3

	}

<<<<<<< HEAD
	}
=======

>>>>>>> b3fc24825be54ef1bab413f28af7ac39357228f3

	public int getCount() {

		return count;

	}


	public void setCount(int count) {

		this.count = count;

	}


	public void autoUpdate(){

		input.getDocument().addDocumentListener(new DocumentListener(){

			String in;

			@Override

			public void insertUpdate(DocumentEvent de) {

				int textLngth = input.getText().length();

				in = input.getText().substring(textLngth-1, textLngth);

				controller.setStr(in);


				if(!model.isFull){


					model.setMatrixIndecies(in);

					controller.repaint();


				}

				else{

					count++;

					controller.saveImage(count);

					System.out.println("inside else");

					controller = new SquareCryptController();

					model = controller.getModel();

					model.setMatrixIndecies(in);

					validate();

					imagePanel.add(controller);

					controller.repaint();

				}

			}

			@Override

			public void removeUpdate(DocumentEvent de) {
				//controller.setStr("");

				int textLngth = input.getText().length();

				//search through for position text.Lngth()+1
				//find last character and set it's matrix indecies to -1 (erase it)

				for(int i=0; i<model.row; i++){

					for(int j =0;j<model.col; j++ ){

						if(model.matrix[i][j] == textLngth + 1){
<<<<<<< HEAD

							model.matrix[i][j] = -1;
							break;
						}
						
=======

							model.matrix[i][j] = -1;

							break;
						}
>>>>>>> b3fc24825be54ef1bab413f28af7ac39357228f3
					}
					
					//System.out.println("this is the fucking string " + controller.getStr());
				}

				//find x,y position of in

				//change to 0

				//repaint
<<<<<<< HEAD
				model.count = model.count -1;

=======

				model.count = model.count -1;
				
>>>>>>> b3fc24825be54ef1bab413f28af7ac39357228f3
				controller.repaint();
				validate();

			}

			@Override

			public void changedUpdate(DocumentEvent de) {

			}

		}); 

	}

<<<<<<< HEAD
=======

<<<<<<< HEAD
=======



>>>>>>> b3fc24825be54ef1bab413f28af7ac39357228f3
>>>>>>> b8d70eb1581948ea6e2eacadcd966c647e81771f
}