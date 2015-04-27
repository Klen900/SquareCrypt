
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

/**
 * This class creates the GUI view for this project, by organizing all of its components
 * and tying their functionality by handling the events run by the model, controller and image reader.
 * 
 * There are 2 main components to this view:
 *         *Top:
 *         The start button enables the recording of the user input, which changes the matrix values in the model & paints it in the controller
 *         *Center:
 *         After every 255 characters entered, the view creates a new controller with a new matrix and paints  them in a box layout.
 *         *South:
 *         Here are the buttons with the different functionalities.
 *               -Clear all: enables the deletion of the whole text and creates a whole new controller
 *               -Save: saves the images created from the text in one big image that will then be able to be read by the script
 *               -upload: lets the user upload any image created by the program so that it can be read
 *               -read image:after the image is uploaded by the user, clicking the read image button will extract the text out of the image
 *         
 * @author elkha22n
 *
 */

public class SquareCryptView extends JPanel implements ActionListener{


	//north panel
	JTextArea title;
	JTextArea instruction;
	JButton start; 
	JTextArea input = new JTextArea();

	//center panel (consists of created controllers)
	JPanel imagePanel;

	//south buttons
	JButton clear;
	JButton save;
	JButton upload;
	JButton read;
	JPanel southPanel;//where the south buttons are added

	public int count =0; //counter the number of controllers that have been instantiated 

	//instances from controller & model to create and paint the matrices
	SquareCryptController controller = new SquareCryptController();
	SquareCryptModel model = controller.getModel();


	//constructor
	public SquareCryptView(){

		mainPanel();

	}

	//the main panel that hold all the JComponents
	public void mainPanel(){

		setLayout(new BorderLayout());

		//set the background color to dark blue
		setBackground(new Color(0,0,102));

		/**
		 * north panel:
		 *    title + instruction + start button + input text area
		 */
		title = new JTextArea("                                 SquareCrypt");
		instruction = new JTextArea("          Press Start and enter the text you want to encrypt!                               "
				+ "When you are done typing, press save.");

		title.setEditable(false);
		instruction.setEditable(false);
		input.setLineWrap(true);

		/**
		 * center panel
		 * holds the painted matrices
		 */
		imagePanel = new JPanel();
		imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));//the matrices get created on a vertical axis
		imagePanel.add(controller);//add the white painted matrix to the panel
		//set background to dark blue
		imagePanel.setBackground(new Color(0,0,102));

		/**
		 * south panel
		 *    buttons: save + clear all + upload image + read image
		 */
		southPanel = new JPanel();
		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));

		//start
		start = new JButton("Start");
		start.addActionListener(this);

		//save
		save = new JButton("Save");
		save.addActionListener(this);

		//clear
		clear = new JButton("Clear All");
		clear.addActionListener(this);

		//read
		read = new JButton("Read Image!");
		read.addActionListener(this);

		//upload
		upload = new JButton("Upload Image");
		upload.addActionListener(this);

		/**
		 * set button colors & style
		 */
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

		//add the buttons to the south panel
		southPanel.add(save);
		southPanel.add(clear);
		southPanel.add(upload);
		southPanel.add(read);

		//set background to dark blue
		southPanel.setBackground(new Color(0,0,102));

		this.add(topText(),BorderLayout.NORTH);

		this.add(imagePanel,BorderLayout.CENTER);

		this.add(southPanel,BorderLayout.SOUTH);

	}

	/**
	 * combines:  titleText() & input area
	 * @return
	 */
	public JPanel topText(){

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));

		input.setPreferredSize(new Dimension(510,50));
		panel.setPreferredSize(new Dimension(510,200));

		panel.add(titleText());//holds title, instruction and start button
		panel.add(input);//input text area

		return panel;
	}

	/**
	 * titleText() combines title & instructionPanel()
	 * @return
	 */
	public JPanel titleText(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));

		title.setPreferredSize(new Dimension(510,5));

		Font font = new Font("Serif", Font.BOLD, 25);
		title.setFont(font);
		title.setBackground(Color.yellow);

		panel.add(title);//SquareCrypt
		panel.add(instructionPanel());//instruction + start button


		return panel;
	}

	/**
	 * instructionPanel() holds the instruction sentence and the start button
	 * @return
	 */
	public JPanel instructionPanel(){

		JPanel panel = new JPanel();

		//instruction style
		Font font = new Font("Serif", Font.BOLD, 15);
		instruction.setFont(font);
		instruction.setLineWrap(true);
		instruction.setBackground(new Color(0,0,102));
		instruction.setForeground(Color.white);

		//set size
		start.setPreferredSize(new Dimension(80,10));
		instruction.setPreferredSize(new Dimension(430,10));

		//panel style
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setBackground(new Color(0,0,102));

		//set button color
		start.setBackground(Color.yellow);
		start.setOpaque(true);
		start.setBorderPainted(false);

		//add components
		panel.add(instruction);
		panel.add(start);

		return panel;
	}

	/**
	 * Handle the key-pressed event of the buttons.
	 */
	public void actionPerformed(ActionEvent e){

		JButton buttonPressed = (JButton) e.getSource();

		if (buttonPressed.equals(start)){

			autoUpdate();//start updating the matrix as the user is typing

		}

		else if (buttonPressed.equals(clear)){

			count = 0;//set the count of created matrices back to 0

			input.setText("");//clear the text area

			model.clearAll();//changes all the indices to the matrix back to the default -1.

			validate();

			imagePanel.removeAll();//updates count and repaints the matrix

			imagePanel.updateUI();

		}

		else if (buttonPressed.equals(save)){

			count++; //increment the count of matrices saved
			
			controller.saveImages(count);//save the images created in 1 big image that takes up to 8 matrices

			controller.saveImage(count);// this saves the last matrix that doesn't get to 255 chars to be able to be saved
			                            //automatically by the program
                                        //the parameter count is needed for the image name : image +count.png
			

		}	else if(buttonPressed.equals(upload)){
			
			FileChooserDemo upload1 = new FileChooserDemo();//open the file chooser to get the image we want to rad
			
			upload1.createAndShowGUI();
			
			upload1.getFile().getName();//get the image file name

		}
		else if(buttonPressed.equals(read)){
			
			ReadImage reader = new ReadImage();//instance of Reader that takes in the image file chosen by the user
			
			reader.read();//synchronously read the image
			
			input.setText(reader.str);//display the extracted text in the textArea in the north panel

		}

	}

	/**
	 * getters and setters for count to access it from model & controller
	 * @return
	 */
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}


	/**
	 * this method takes care of the real time update of the matrices on the view as the user is typing
	 *             -insert update: paints the block with its RGB value from controller if character is inserted
	 *             -removeUpdate: paints the block in white when char is deleted by user, also update sthe matrix in model   
	 */
	public void autoUpdate(){

		input.getDocument().addDocumentListener(new DocumentListener(){

			String in;

			@Override

			public void insertUpdate(DocumentEvent de) {

				int textLngth = input.getText().length();//get the length of the string inputed

				in = input.getText().substring(textLngth-1, textLngth);//get the last character inserted

				controller.setStr(in);//give that last char to the controller

				if(!model.isFull){//if the matrix did not reach 255 chars

					model.setMatrixIndecies(in);//keep inserting the chars in the same matrix
					controller.repaint();//update the display

				}

				else{//if the model is full

					count++;//increment the count of the created matrices

					controller.saveImage(count);//automatically save the previous painted matrix

					System.out.println("255 chars reached! painting new matrix...");

					controller = new SquareCryptController();//create new controller to paint new image

					model = controller.getModel();

					model.setMatrixIndecies(in);//update its matrix with the user input

					validate();

					imagePanel.add(controller);//add the new controller to the panel

					controller.repaint();

				}

			}

			@Override

			public void removeUpdate(DocumentEvent de) {

				int textLngth = input.getText().length();//get the length of the string inputed

				//search for position text.Lngth()+1
				//find last character and set it's matrix index to -1 (erase it)
				for(int i=0; i<model.row; i++){

					for(int j =0;j<model.col; j++ ){

						if(model.matrix[i][j] == textLngth + 1){

							model.matrix[i][j] = -1;

							break;
						}
					}
				}
				model.count = model.count -1;//decrement the count of the inserted characters

				controller.repaint();
				validate();

			}

			@Override
			//required method
			public void changedUpdate(DocumentEvent de) {

			}

		}); 

	}

}