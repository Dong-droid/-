public abstract class Vehicle implements Moveable {
	public String name;
	private double 연료량;
	private double 연비;
	private int 주행거리;
	
	public Vehicle() {}
	//연료, 연비 세팅,  주행거리는 0
	public Vehicle(String name, int 연료량, double 연비) {
		this.name = name;
		this.연료량 = 연료량;
		this.연비 = 연비;
		this.주행거리 = 0;
	}
	public double get연료량() {
		return 연료량;
	}
	public void set연료(double 연료량) {
		this.연료량 = 연료량;
	}
	public double get연비() {
		return 연비;
	}
	public void set연비(double 연비) {
		this.연비 = 연비;
	}
	public int get주행거리() {
		return 주행거리;
	}
	public void set주행거리(int 주행거리) {
		this.주행거리 = 주행거리;
	}
	
	//연료가 소진될 때까지 달린다. 기본 주행거리 10km
	public int move() {
		
		double 소요량 = 10/this.연비;  //10km를 주행할 때 필요한 연료소비량
		
		while( this.연료량 >= 소요량) {
			this.set연료((this.연료량 - 소요량));
			this.주행거리 += 10;	
			this.show();
		}
		
		System.out.println("연료가 부족합니다. 이 차는 더 이상 움직일 수 없습니다.");
		return this.주행거리;
	}
	
	public static void show_header() {
		System.out.println("-------------------------------------------------------------");
		System.out.printf("  %16s | %10s(km)  %10s(l)  %10s(km/l)\n", "이름" , "총주행거리", "연료량", "연비") ;
		System.out.println("-------------------------------------------------------------");
	}

	public  void show() {
		
		System.out.printf("%16s | %10d         %10.2f        %10.2f", this.name, this.주행거리 , this.연료량, this.연비 ) ;
		System.out.println();
		
	}
	

	
	public static void show(Vehicle [] vs) {
		show_header();
		for(int i=0; i<vs.length; i++) {
			System.out.printf("%16s | %10d         %10.2f        %10.2f", vs[i].name, vs[i].주행거리 , vs[i].연료량, vs[i].연비 ) ;
			System.out.println();
		}
		
	}
	
	
}
