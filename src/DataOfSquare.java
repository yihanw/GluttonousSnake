import java.util.*;
import java.awt.Color;

public class DataOfSquare {

	
	//ArrayList that'll contain the colors
	ArrayList<Color> C =new ArrayList<Color>();
	int color; //0: snake , 1: food, 2:empty 
	SquarePanel square;
	public DataOfSquare(int myColor){
		
		//Lets add the color to the arrayList
		C.add(Color.lightGray);//0
		C.add(Color.blue);    //1
		C.add(Color.white);   //2
		color=myColor;
		square = new SquarePanel(C.get(color));
	}
	public void lightMeUp(int c){
		square.ChangeColor(C.get(c));
	}
}
