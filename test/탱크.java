public class 탱크 extends Vehicle {
	public 탱크() {}
	//연료, 연비 세팅,  주행거리는 0
	public 탱크(String name, int 연료, double 연비) {
		super(name,연료, 연비);
	}
	
	public int move() {		
		System.out.println("탱크탱크탱크탱크~~");
		return super.move();		 
	}
	public void 포탄쏘기() {
		System.out.println("탱크가 포탄을 쏩니다");
	}
}
