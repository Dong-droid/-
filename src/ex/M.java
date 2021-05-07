package ex;


public class M {
public static void main(String[] args) {
	
	Bus b = new Bus("타요버스",100,12);
	Airplane a=new Airplane("쑝비행기",100,0.1);
	Tank t=new Tank("탱크탱크",50,4);
	Driver d=new Driver("미미");
	
	Vehicle [] vs= {b,a,t};
	Vehicle.show(vs);
	Moveable [] ms= {b,a,t};
	d.drive();
	
	//가능한 표현들>>d.drive(vs);
	d.drive(ms);
	//d.drive(t);
	//d.drive(b);
	//d.drive(t);
	//d.drive(a);//자동업캐스팅
	
	
	Vehicle.show(vs);
	
	
	
	
	
}
}
