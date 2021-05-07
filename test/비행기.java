public class 비행기 extends Vehicle {
	public 비행기() {}
	//연료, 연비 세팅,  주행거리는 0
	public 비행기(String name, int 연료, double 연비) {
		super(name,연료, 연비);
	}
	
	public void fly() {		
		System.out.println("슈우우우웅~~");		
	}
	
	public int move()  {		
		fly();		
		return super.move();		
	}	
}
