package Engine;

public class Location {
	
	private int xCoord;
	private int yCoord;

		public Location(int a , int b){

		xCoord=a;
		yCoord=b;

		}

		public void setXCoord(int a ){

		
			xCoord= a ; 

		
		}
		public void setYCoord(int a){

			yCoord=a;
			
		}
		public int getXCoord(){

			return xCoord;


		}
		public int getYCoord(){


			return yCoord;

		}



}