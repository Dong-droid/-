package ex;
public class Tank extends Vehicle {
	
	  
	    public Tank(String name, double 연료량, double 연비){
	    	 super(name,연료량,연비);
	    
	    }

		@Override
		public int move() {
			// TODO Auto-generated method stub
			System.out.println("탱크탱크");
			return super.move();
		}
	    
}
