import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;


class Display extends JFrame{
	
	private static final long serialVersionUID = -2542001418764869760L;
	public static ArrayList<ArrayList<SquareData>> Grid;
	public static int width = 20;
	public static int height = 20;
	public Display(){
		
		//Initializes an arrayList to contain snake body
		Grid = new ArrayList<ArrayList<SquareData>>();
		ArrayList<SquareData> data;
		
		//Adds data to snake body
		for(int i=0; i<width; i++){
			data = new ArrayList<SquareData>();
			for(int j=0;j<height;j++){
				SquareData c = new SquareData(2);
				data.add(c);
			}
			Grid.add(data);
		}
		
		//Initializes the panel
		getContentPane().setLayout(new GridLayout(20,20,0,0));
		
		// Start & pauses all threads, then adds every square of each thread to the panel
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				getContentPane().add(Grid.get(i).get(j).square);
			}
		}
		
		// initial position of the snake
		Data position = new Data(10,10);
		// passing this value to the controller
		GameProcess c = new GameProcess(position);
		//Let's start the game now..
		c.start();

		// Links the Display to the keyboardlistenner.
		this.addKeyListener((KeyListener) new Keyboard());
		
	}
}

