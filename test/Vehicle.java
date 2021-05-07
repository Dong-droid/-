public abstract class Vehicle implements Moveable {
	public String name;
	private double ���ᷮ;
	private double ����;
	private int ����Ÿ�;
	
	public Vehicle() {}
	//����, ���� ����,  ����Ÿ��� 0
	public Vehicle(String name, int ���ᷮ, double ����) {
		this.name = name;
		this.���ᷮ = ���ᷮ;
		this.���� = ����;
		this.����Ÿ� = 0;
	}
	public double get���ᷮ() {
		return ���ᷮ;
	}
	public void set����(double ���ᷮ) {
		this.���ᷮ = ���ᷮ;
	}
	public double get����() {
		return ����;
	}
	public void set����(double ����) {
		this.���� = ����;
	}
	public int get����Ÿ�() {
		return ����Ÿ�;
	}
	public void set����Ÿ�(int ����Ÿ�) {
		this.����Ÿ� = ����Ÿ�;
	}
	
	//���ᰡ ������ ������ �޸���. �⺻ ����Ÿ� 10km
	public int move() {
		
		double �ҿ䷮ = 10/this.����;  //10km�� ������ �� �ʿ��� ����Һ�
		
		while( this.���ᷮ >= �ҿ䷮) {
			this.set����((this.���ᷮ - �ҿ䷮));
			this.����Ÿ� += 10;	
			this.show();
		}
		
		System.out.println("���ᰡ �����մϴ�. �� ���� �� �̻� ������ �� �����ϴ�.");
		return this.����Ÿ�;
	}
	
	public static void show_header() {
		System.out.println("-------------------------------------------------------------");
		System.out.printf("  %16s | %10s(km)  %10s(l)  %10s(km/l)\n", "�̸�" , "������Ÿ�", "���ᷮ", "����") ;
		System.out.println("-------------------------------------------------------------");
	}

	public  void show() {
		
		System.out.printf("%16s | %10d         %10.2f        %10.2f", this.name, this.����Ÿ� , this.���ᷮ, this.���� ) ;
		System.out.println();
		
	}
	

	
	public static void show(Vehicle [] vs) {
		show_header();
		for(int i=0; i<vs.length; i++) {
			System.out.printf("%16s | %10d         %10.2f        %10.2f", vs[i].name, vs[i].����Ÿ� , vs[i].���ᷮ, vs[i].���� ) ;
			System.out.println();
		}
		
	}
	
	
}
