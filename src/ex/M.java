package ex;


public class M {
public static void main(String[] args) {
	
	Bus b = new Bus("Ÿ�����",100,12);
	Airplane a=new Airplane("�������",100,0.1);
	Tank t=new Tank("��ũ��ũ",50,4);
	Driver d=new Driver("�̹�");
	
	Vehicle [] vs= {b,a,t};
	Vehicle.show(vs);
	Moveable [] ms= {b,a,t};
	d.drive();
	
	//������ ǥ����>>d.drive(vs);
	d.drive(ms);
	//d.drive(t);
	//d.drive(b);
	//d.drive(t);
	//d.drive(a);//�ڵ���ĳ����
	
	
	Vehicle.show(vs);
	
	
	
	
	
}
}
