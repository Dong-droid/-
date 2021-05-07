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
	//drive() : �����ε��� �޼ҵ��.  
	//50�����ο���,  drive((�����)ms[i]); �� ȣ��������  
	//���� ����⸦ ���ڷ� �޴� �޼ҵ尡 ����. � �޼ҵ尡 ����ɱ�? drive(Vehicle v) �޼ҵ尡 �ҷ�����.
	//�����Ÿ���� ���ڸ� �޴� �޼ҵ尡 ���ٰ� ������ �ƴ϶� Vehicle���ڷ� ��ĳ���ý�Ų��. 
	//Vehicle ���ڸ� �޴� �޼ҵ嵵 ���ٸ�  VehicleŬ������ ����� Moveable�� ��ĳ���ý�Ų��. �׷��� ���ٸ� ���������� ����ش�. 
	//����, ����Ŭ�������� �Ϲ����� ���¿� �Ϲ����� ���ڸ� �޴� �޼ҵ带 ����� �ΰ�, ����Ŭ�������� Ȯ���Ű�� ���� ����. 

	public void drive(Vehicle v) {
		System.out.println("Vehicle�� �����մϴ�.");
		distance +=v.move();
	}
	
	public void drive(Moveable m) {
		System.out.println("Moveable�� ���� �����մϴ�.");
		
		//�� Vehicle���� ��ü�� Movealbe�� ���޹޾Ƶ�  Ŭ����Ÿ�԰� �񱳴� �����ϴ�.
		System.out.println("Ŭ���� �̸� :" + m.getClass().getTypeName());
		
		//String s = m.getClass().getTypeName();
		//if (s.equals("����")) System.out.println("��������~");
		
		//if ( m instanceof ���� ) drive((����)m);
		//����⸦ ���ڷ� �޴�  drive�� �������� �ʾ��� ���� � �޼ҵ尡 �����ұ�?
		//if ( m instanceof ����� ) drive((�����)m);  
		//if ( m instanceof ��ũ) drive((��ũ)m);	
		
		distance +=m.move();
	}
	
	public void drive(��ũ t) {
		System.out.println("��ũ�� �����մϴ�.");
		distance +=t.move();
	}

	public void drive(���� b) {
		System.out.println("������ �����մϴ�.");
		distance +=b.move();
	}
	
	public void drive(Moveable [] ms) {
		System.out.println("Moveable [] �� ms�� drive�մϴ�. ");
		for(int i=0; i<ms.length; i++) {
			//distance += m[i].move();  �� �����̴� ���۵� ����������, 
			//�����ڰ�  m[i]��  �����Ѵٴ� �ǹ̴�, m[i]�� ������ move�ϴ°��� �ƴϹǷ�
		    
			//1. drive(ms[i]); �� ���� drive() �� ���ڿ� Moveable Ÿ���� ���ڷ� �����ϰ� �ưų�
			//2. Vehicle Ÿ�Կ� ���߾� drive()�ϰ� �ϴ� ���� Ÿ���ϴ�.
			//1���� 2���� ����� ���� ������� ����  �����ڴ� m[i]�� ��� �ν��ϴ°� Ȯ���غ���. � �޼ҵ尡 ����Ǵ°�?
			
			drive(ms[i]);  //1��.�Ʒ��� ���� ��ü�� Ÿ���� ���Ͽ� ȣ������ �ʾƵ�, Moveable���� ���ǵ� �޼ҵ��� move()�� �� ��ü���� ã�� �����Ѵ�.
			
			//2��. VehicleŸ�Կ� ���߾� drive()�� ���ڷ� ������ �� �ִ�.  
			//1���� 2�� ��� driver��  Vehicle�� ������ �� �ִ� ������� ��� Ÿ���ϴ�.
			
			//if ( ms[i] instanceof ���� ) drive((����)ms[i]);
			//if ( ms[i] instanceof ����� ) drive((�����)ms[i]);
			//if ( ms[i] instanceof ��ũ) drive((��ũ)ms[i]);	
			
			System.out.println("�� ����Ÿ� : " + distance);			
			input.nextLine();
		}
		
//		�̰�, for-each ��. ���� ������ ���� for���̴�.  ����ó�� ���� ī������ �ʿ���� �� ����Ѵ�.
//		for(Moveable m :ms) {
//			if ( m instanceof ���� ) drive((����)m);
//			if ( m instanceof ����� ) drive((�����)m);
//			if ( m instanceof ��ũ) drive((��ũ)m);	
//			
//			System.out.println("�� ����Ÿ� : " + distance);			
//			input.nextLine();
//		}
				
	}	
}
