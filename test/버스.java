public class ���� extends Vehicle {
	public ����() {}
	//����, ���� ����,  ����Ÿ��� 0
	public ����(String name, int ����, double ����) {
		super(name,����, ����);
	}
	
	public void �����ϱ�() {		
		System.out.println("�θ��θ��θ���~~");		
	}
	
	public int move() {		
		�����ϱ�();		
		return super.move();		
	}
}
