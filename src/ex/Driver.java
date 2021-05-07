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
		System.out.println("클래스 이름 :" + m.getClass().getTypeName());
		Driveable.super.drive(m);
		TotalRunningDistance +=m.move();
	}

	public void drive(Tank t) {
		System.out.println("탱크를 운전합니다.");
		TotalRunningDistance +=t.move();
	}
	public void drive(Bus b) {
		System.out.println("버스를 운전합니다.");
		TotalRunningDistance +=b.move();
	}

	public void drive(Moveable [] ms) {
		System.out.println("Moveable [] 한 ms를 drive합니다. ");
		for(int i=0; i<ms.length; i++) {
			TotalRunningDistance+=ms[i].move();
			System.out.println("총 주행거리 : " + TotalRunningDistance);			
		
		}}
	/*public void drive(Vehicle [] vs) {
	   TotalRunningDistance=0;
	   for(int i=0;i<vs.length;i++) {
		   TotalRunningDistance +=vs[i].move(); 
		   System.out.println("지금까지 "+TotalRunningDistance+"만큼 이동했습니다.");
	   }
	  airplane 자동으로 업캐스팅됨
*/
	
	   
	}

