package ex;


public class Airplane extends Vehicle {

	public Airplane() {}
	public Airplane(String name, double 연료량, double 연비){
	    	 super(name,연료량,연비);
	    	
	    }
	@Override
	public int move() {
		// TODO Auto-generated method stub
		System.out.println("슈우웅!! 비행기가 납니다");
		return super.move();
		}
	    
}