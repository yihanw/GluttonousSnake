import java.util.ArrayList;

public class GameProcess extends Thread {
	
	 ArrayList<ArrayList<SquareData>> Squares= new ArrayList<ArrayList<SquareData>>();
	 Data snakeHead;
	 int sizeSnake = 3; //Initializes the initial size of the snake
	 long speed = 80;
	 public static int snakeDirection ;

	 ArrayList<Data> pos = new ArrayList<Data>();
	 Data foodPosition;
	 
	 //Constructors
	 GameProcess(Data positionDepart){ 
		
		Squares=Display.Grid;
		
		snakeHead=new Data(positionDepart.x,positionDepart.y);
		snakeDirection = 1;

		Data headPos = new Data(snakeHead.getX(),snakeHead.getY());
		pos.add(headPos);
		
		foodPosition= new Data(Display.height-1, Display.width-1);
		nextFood(foodPosition);

	 }
	 
	 //Delay between each move of the snake
	 private void delay(){
		 try {
				sleep(speed);
		 } catch (InterruptedException e) {
				e.printStackTrace();
		 }
	 }
	 
	 //Check collision
	 int foodCount = 0; 
	 private void collision() {
		 
		 Data posCritique = pos.get(pos.size()-1);
		 for(int i = 0; i<=pos.size()-2; i++){
			 boolean bite = posCritique.getX()==pos.get(i).getX() && posCritique.getY()==pos.get(i).getY();
			 if(bite){
				stopTheGame();
			 }
		 }
		 
		 boolean eatingFood = posCritique.getX()==foodPosition.y && posCritique.getY()==foodPosition.x;
		 if(eatingFood){
			 foodCount++;
			 System.out.println(foodCount +" food eaten.");
			 sizeSnake += 1;
			 foodPosition = nextFoodPos();
			 nextFood(foodPosition);       
		 }
	 }
	 
	 //Stops the game
	 private void stopTheGame(){
		 System.out.println("Collision, game determined.\n");
		 while(true){
			 delay();
		 }
	 }
	 
	 //Displays next food
	 private void nextFood(Data foodPositionIn){
			Squares.get(foodPositionIn.x).get(foodPositionIn.y).setColor(1);
	 }
	 
	 //Finds a space that is not occupied by the snake
	 private Data nextFoodPos(){
		 Data p ;
		 int ranX = 0 + (int)(Math.random()*19); 
		 int ranY = 0 + (int)(Math.random()*19); 
		 p = new Data(ranX,ranY);
		 
		 for(int i = 0; i<=pos.size()-1; i++){
			 if(p.getY()==pos.get(i).getX() && p.getX()==pos.get(i).getY()){
				 ranX= 0 + (int)(Math.random()*19); 
				 ranY= 0 + (int)(Math.random()*19); 
				 p=new Data(ranX,ranY);
				 i=0;
			 }
		 }
		 return p;
	 }
	 
	 //Moves snakeHead and resets the position of snake
	 private void moveInterne(int direction){
		 
		 switch(direction){
		 
		 	case 1: //right
			 snakeHead.ChangeData(Math.abs(snakeHead.x+1)%20,snakeHead.y);
			 pos.add(new Data(snakeHead.x,snakeHead.y));
			 break;
			 
		 	case 2: //left
				 if(snakeHead.x-1<0){
					 snakeHead.ChangeData(19,snakeHead.y);
				 }
				 else{
					 snakeHead.ChangeData(Math.abs(snakeHead.x-1)%20,snakeHead.y);
				 } 
				pos.add(new Data(snakeHead.x,snakeHead.y));
				break;
			 
		 	case 3: //top
				if(snakeHead.y-1<0){
					 snakeHead.ChangeData(snakeHead.x,19);
				 }
				else{
				 snakeHead.ChangeData(snakeHead.x,Math.abs(snakeHead.y-1)%20);
				}
				 pos.add(new Data(snakeHead.x,snakeHead.y));
				break;	
				
			case 4: //bottom
				 snakeHead.ChangeData(snakeHead.x,(snakeHead.y+1)%20);
				 pos.add(new Data(snakeHead.x,snakeHead.y));
				break;
				
		 }
	 }
	 
	 //Refresh squares
	 private void moveExterne(){
		 for(Data t : pos){
			 int y = t.getX();
			 int x = t.getY();
			 Squares.get(x).get(y).setColor(0);
			 
		 }
	 }
	 
	 //Refreshes the tail of the snake, removes unnecessary data in arrayList
	 private void deleteTail(){
		 
		 int cmpt = sizeSnake;
		 for(int i = pos.size()-1;i>=0;i--){
			 if(cmpt==0){
				 Data t = pos.get(i);
				 Squares.get(t.y).get(t.x).setColor(2);
			 }
			 else{
				 cmpt--;
			 }
		 }
		 cmpt = sizeSnake;
		 for(int i = pos.size()-1;i>=0;i--){
			 if(cmpt==0){
				 pos.remove(i);
			 }
			 else{
				 cmpt--;
			 }
		 }
	 }
	 
	 //Run method
	 public void run() {
		 while(true){
			 moveInterne(snakeDirection);
			 collision();
			 moveExterne();
			 deleteTail();
			 delay();
		 }
	 }
}
