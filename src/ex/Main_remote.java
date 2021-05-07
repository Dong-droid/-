package ex;

public class Main_remote {
	
	public static void main (String[] args) {
           RemoteController ob =new Audio();
           TV tv=new TV();
           Car car= new Car();
           ob.turnOff();
           ob.turnOn();
           ob.changeObj();
	       tv.turnOff();
	       tv.turnOn();
	       tv.changeObj();
	       car.turnOff();
	       car.turnOn();
	       car.changeObj();
           /*((Car)ob).turnOff();
           ((Car)ob).turnOn();     //인터페이스에서도 다운 캐스팅이 되는 건가???? 안됨 오류남.
           ob.changeObj();
           
           ((TV)ob).turnOff();
           ((TV)ob).turnOn();*/
           
           System.out.println("끝...");
          
 	
	}
	
	
}
