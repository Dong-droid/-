import java.lang.reflect.Type;
import java.util.Scanner;

import javax.naming.Name;
 

public class Driver implements Driveable {
	String name;
	Scanner input =new Scanner(System.in);
	int distance =0;
	
	public Driver() {}
	public Driver(String name) {
		this.name =name;
	}	
	//drive() : 오버로딩된 메소드들.  
	//50번라인에서,  drive((비행기)ms[i]); 로 호출했으나  
	//여긴 비행기를 인자로 받는 메소드가 없다. 어떤 메소드가 실행될까? drive(Vehicle v) 메소드가 불려진다.
	//비행기타입이 인자를 받는 메소드가 없다고 에러가 아니라 Vehicle인자로 업캐스팅시킨다. 
	//Vehicle 인자를 받는 메소드도 없다면  Vehicle클래스에 연결된 Moveable로 업캐스팅시킨다. 그래도 없다면 문법에러로 잡아준다. 
	//따라서, 상위클래스에서 일반적인 형태와 일반적인 인자를 받는 메소드를 만들어 두고, 하위클래스에서 확장시키는 것이 좋다. 

	public void drive(Vehicle v) {
		System.out.println("Vehicle을 운전합니다.");
		distance +=v.move();
	}
	
	public void drive(Moveable m) {
		System.out.println("Moveable한 것을 운전합니다.");
		
		//각 Vehicle들의 객체를 Movealbe로 전달받아도  클래스타입과 비교는 가능하다.
		System.out.println("클래스 이름 :" + m.getClass().getTypeName());
		
		//String s = m.getClass().getTypeName();
		//if (s.equals("버스")) System.out.println("버스버스~");
		
		//if ( m instanceof 버스 ) drive((버스)m);
		//비행기를 인자로 받는  drive가 구현되지 않았을 때는 어떤 메소드가 동작할까?
		//if ( m instanceof 비행기 ) drive((비행기)m);  
		//if ( m instanceof 탱크) drive((탱크)m);	
		
		distance +=m.move();
	}
	
	public void drive(탱크 t) {
		System.out.println("탱크를 운전합니다.");
		distance +=t.move();
	}

	public void drive(버스 b) {
		System.out.println("버스를 운전합니다.");
		distance +=b.move();
	}
	
	public void drive(Moveable [] ms) {
		System.out.println("Moveable [] 한 ms를 drive합니다. ");
		for(int i=0; i<ms.length; i++) {
			//distance += m[i].move();  로 움직이는 동작도 가능하지만, 
			//운전자가  m[i]를  운전한다는 의미는, m[i]가 저절로 move하는것이 아니므로
		    
			//1. drive(ms[i]); 와 같은 drive() 의 인자에 Moveable 타입의 인자로 동작하게 아거나
			//2. Vehicle 타입에 맞추어 drive()하게 하는 것이 타당하다.
			//1번과 2번의 방법을 각각 실행시켜 보고  운전자는 m[i]를 어떻게 인식하는가 확인해보자. 어떤 메소드가 실행되는가?
			
			drive(ms[i]);  //1번.아래와 같이 객체의 타입을 비교하여 호출하지 않아도, Moveable에서 정의된 메소드인 move()를 각 객체에서 찾아 실행한다.
			
			//2번. Vehicle타입에 맞추어 drive()에 인자로 전달할 수 있다.  
			//1번과 2번 모두 driver가  Vehicle을 운전할 수 있는 방법으로 모두 타당하다.
			
			//if ( ms[i] instanceof 버스 ) drive((버스)ms[i]);
			//if ( ms[i] instanceof 비행기 ) drive((비행기)ms[i]);
			//if ( ms[i] instanceof 탱크) drive((탱크)ms[i]);	
			
			System.out.println("총 주행거리 : " + distance);			
			input.nextLine();
		}
		
//		이건, for-each 문. 위와 동작이 같은 for문이다.  지금처럼 보통 카운팅이 필요없을 때 사용한다.
//		for(Moveable m :ms) {
//			if ( m instanceof 버스 ) drive((버스)m);
//			if ( m instanceof 비행기 ) drive((비행기)m);
//			if ( m instanceof 탱크) drive((탱크)m);	
//			
//			System.out.println("총 주행거리 : " + distance);			
//			input.nextLine();
//		}
				
	}	
}
