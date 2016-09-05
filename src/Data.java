public class Data { 
	
	  public int x; //X-coordination
	  public int y; //Y-coordination
	  
	  public Data(int x, int y) { 
	    this.x = x; 
	    this.y = y; 
	  } 
	  
	  public void ChangeData(int x, int y){
		    this.x = x; 
		    this.y = y; 
	  }
	  
	  //Contructor
	  public int getX(){
		  return x;
	  }
	  
	  public int getY(){
		  return y;
	  }
} 