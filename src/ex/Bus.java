package ex;

public class Bus extends Vehicle {
  
    public Bus(){}
    
    public Bus(String name, double 연료량, double 연비){
    super(name,연료량,연비);
    	
    }
	
	@Override
	public int move() {
		// TODO Auto-generated method stub
		 System.out.println("부릉부릉~버스가 움직여요");
     return super.move();
  
	}
   
}
