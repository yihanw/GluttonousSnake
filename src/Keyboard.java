import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

 public class Keyboard extends KeyAdapter{
	
		public void keyPressed(KeyEvent e){
			
		    switch(e.getKeyCode()){
		    
		    case 37: //Left key
				if(GameProcess.snakeDirection!=1)
					GameProcess.snakeDirection=2;
				break;
				
		    case 38: //Top key
				if(GameProcess.snakeDirection!=4) 
					GameProcess.snakeDirection=3;
				break;	
				
			case 39: //Right key
				if(GameProcess.snakeDirection!=2) 
					GameProcess.snakeDirection=1;
				break;
						
			case 40: //Bottom key
				if(GameProcess.snakeDirection!=3)
					GameProcess.snakeDirection=4;
				break;
			
			default:        
				break;
		    }
		}
	
 }
