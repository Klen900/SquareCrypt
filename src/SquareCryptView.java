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

	//challenges
	//which model is the controller talking to when creating the second one?
	//pixel size
	//delete was a challenge! because it was taking the last char instead of ...problem with count wasn't updating correctly
	//what string was passed to model?
	//buffered image ,saves the whole panel. why?
	//layout of controller images
	
	JTextArea input = new JTextArea(20,20); 

	JButton auto; 
	JButton goButton;
	JButton save;
	JPanel panel = new JPanel();
	JPanel anotherPanel;
	JPanel imagePanel;

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


		anotherPanel.add(goButton);
		anotherPanel.add(auto);
		anotherPanel.add(save);
		
		imagePanel = new JPanel();
		imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
		//imagePanel.setLayout(new GridLayout(1,2));
		imagePanel.add(controller);
		
		
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
		else if (buttonPressed.equals(goButton)){

			in = input.getText();
			
			if(!model.isFull){

				model.setMatrixIndecies(in);
				controller.repaint();

			}
			else{
				controller.saveImage();
				System.out.println("inside else");
				controller = new SquareCryptController();
				model = controller.getModel();

				// model = new SquareCryptModel();
				model.setMatrixIndecies(in);
				validate();
				//controller.getModel().getMatrixIndecies(in);
				// System.out.println("in " + in);

				imagePanel.add(controller);
				controller.repaint();

			}
		}
		else if (buttonPressed.equals(save)){
			 
            controller.saveImage();
			//controller.saveImages();

		}


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
                    controller.saveImage();
					System.out.println("inside else");
					controller = new SquareCryptController();
					model = controller.getModel();

					// model = new SquareCryptModel();
					model.setMatrixIndecies(in);
					validate();
					//controller.getModel().getMatrixIndecies(in);
					// System.out.println("in " + in);

					imagePanel.add(controller);
					controller.repaint();

				}
			}

			@Override
			public void removeUpdate(DocumentEvent de) {

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
				model.count = model.count --;

			}

			@Override
			public void changedUpdate(DocumentEvent de) {
			}

		}); 

	}


}
