import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		Display window= new Display(); //Initializes a window for GameProcess
		
		//Initializes window settings
		window.setTitle("Snake");
		window.setSize(300,300);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
	}
}