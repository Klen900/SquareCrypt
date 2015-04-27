import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

import java.util.TimerTask;

public class SquareCryptView extends JPanel implements ActionListener{

	//challenges
	//which model is the controller talking to when creating the second one?
	//pixel size
	//delete was a challenge! because it was taking the last char instead of ...problem with count wasn't updating correctly
	//what string was passed to model?
	//buffered image ,saves the whole panel. why?
	//layout of controller images
	
	JTextArea input = new JTextArea(20,20);


	JButton auto; 
	JButton clear;
	JButton save;
	//button to upload image to read!!
	JButton upload;
	JButton read;
	JPanel panel = new JPanel();
	JPanel anotherPanel;
	JPanel imagePanel;
	public int count =0; 
	

	SquareCryptController controller = new SquareCryptController();
	SquareCryptModel model = controller.getModel();




	//constructor
	public SquareCryptView(){

		mainPanel();
	}

	public void mainPanel(){
		
		anotherPanel = new JPanel();

		anotherPanel.setLayout(new BoxLayout(anotherPanel, BoxLayout.X_AXIS));
	//	input.setMaximumSize(new Dimension(20,100));
		input.setLineWrap(true);
		//input.setWrapStyleWord(true);
		//input.setResizable(false);
		//setLayout(new GridLayout(3,1));
		read = new JButton("Read Image!");
		read.addActionListener(this);
		upload = new JButton("Upload Image");
		upload.addActionListener(this);
		auto = new JButton("Go");
		auto.addActionListener(this);
		save = new JButton("Save");
		save.addActionListener(this);
		clear = new JButton("Clear All");
		clear.addActionListener(this);
		setLayout(new BorderLayout());


		anotherPanel.add(auto);
		anotherPanel.add(save);
		anotherPanel.add(clear);
		anotherPanel.add(upload);
		anotherPanel.add(read);


		
		JScrollPane scrollPane = new JScrollPane(panel);
		
		imagePanel = new JPanel();
		imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
		//imagePanel.setLayout(new GridLayout(1,2));
		imagePanel.add(controller);
		//imagePanel.add(Box.createVerticalGlue());
		//imagePanel.add(scrollPane);

		
		
		this.add(input,BorderLayout.NORTH);
		this.add(imagePanel,BorderLayout.CENTER);
		//this.add(controller,BorderLayout.CENTER);
		this.add(anotherPanel,BorderLayout.SOUTH);
	}


	//Handle the key-pressed event.

	public void actionPerformed(ActionEvent e){

		JButton buttonPressed = (JButton) e.getSource();
		String in;
		if (buttonPressed.equals(auto)){


			autoUpdate();

		}
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
			

		}

	}

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
				for(int i=0; i<model.row; i++){
					for(int j =0;j<model.col; j++ ){

						if(model.matrix[i][j] == textLngth + 1){

							model.matrix[i][j] = -1;
							break;
						}
						
					}
					
					//System.out.println("this is the fucking string " + controller.getStr());
				}
				//find x,y position of in
				//change to 0
				//repaint
				model.count = model.count -1;

				controller.repaint();
				validate();

			}

			@Override
			public void changedUpdate(DocumentEvent de) {
			}

		}); 

	}


}