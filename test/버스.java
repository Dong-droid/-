public class 버스 extends Vehicle {
	public 버스() {}
	//연료, 연비 세팅,  주행거리는 0
	public 버스(String name, int 연료, double 연비) {
		super(name,연료, 연비);
	}
	
	public void 운행하기() {		
		System.out.println("부릉부릉부르릉~~");		
	}
	
	public int move() {		
		운행하기();		
		return super.move();		
	}
}
