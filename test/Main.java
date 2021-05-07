
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		버스 b = new 버스("타요버스",100, 12); //연료,연비
		비행기 a = new 비행기("쑝비행기",100, 0.1); //연료,연비
		탱크 t = new 탱크("탱크탱크",50, 4); //연료,연비
		
		Driver d = new Driver("미미");
		Vehicle [] vs = {b,a,t};
		
		//현재 Vehicle들의 상태를 보인다.
		Vehicle.show(vs);
	
		d.drive();  //		
		//driver는  차량의 연료가 떨어질때까지  drive()한다 . 총 몇 km까지 달릴 수 있을까?
		d.drive(vs);

		Vehicle.show(vs);
		
		
	}

}
