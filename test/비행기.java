public class ����� extends Vehicle {
	public �����() {}
	//����, ���� ����,  ����Ÿ��� 0
	public �����(String name, int ����, double ����) {
		super(name,����, ����);
	}
	
	public void fly() {		
		System.out.println("�������~~");		
	}
	
	public int move()  {		
		fly();		
		return super.move();		
	}	
}
