package ex;


public class Driver implements Driveable {
	
    static int TotalRunningDistance;
    public Driver(String name) {
    }
      
     
    
     @Override
	public void drive(Vehicle v) {
		// TODO Auto-generated method stub
	 v.move();
	}



	@Override
	public void drive(Moveable m) {
		// TODO Auto-generated method stub
		System.out.println("Ŭ���� �̸� :" + m.getClass().getTypeName());
		Driveable.super.drive(m);
		TotalRunningDistance +=m.move();
	}

	public void drive(Tank t) {
		System.out.println("��ũ�� �����մϴ�.");
		TotalRunningDistance +=t.move();
	}
	public void drive(Bus b) {
		System.out.println("������ �����մϴ�.");
		TotalRunningDistance +=b.move();
	}

	public void drive(Moveable [] ms) {
		System.out.println("Moveable [] �� ms�� drive�մϴ�. ");
		for(int i=0; i<ms.length; i++) {
			TotalRunningDistance+=ms[i].move();
			System.out.println("�� ����Ÿ� : " + TotalRunningDistance);			
		
		}}
	/*public void drive(Vehicle [] vs) {
	   TotalRunningDistance=0;
	   for(int i=0;i<vs.length;i++) {
		   TotalRunningDistance +=vs[i].move(); 
		   System.out.println("���ݱ��� "+TotalRunningDistance+"��ŭ �̵��߽��ϴ�.");
	   }
	  airplane �ڵ����� ��ĳ���õ�
*/
	
	   
	}

