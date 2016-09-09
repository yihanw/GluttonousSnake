import java.util.*;
import java.awt.Color;

public class SquareData {

	//Initialize an arrayList to contain colours
	ArrayList<Color> snakeColor =new ArrayList<Color>();
	int color; 
	SquarePanel square;
	
	public SquareData(int myColor){
		
		//Adds colours to arrayList
		snakeColor.add(Color.lightGray); //0: snake
		snakeColor.add(Color.blue);      //1: food
		snakeColor.add(Color.white);     //2: empty
		color=myColor;
		square = new SquarePanel(snakeColor.get(color));
	}
	
	public void setColor(int color){
		square.ChangeColor(snakeColor.get(color));
	}
}
