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
           ((Car)ob).turnOn();     //�������̽������� �ٿ� ĳ������ �Ǵ� �ǰ�???? �ȵ� ������.
           ob.changeObj();
           
           ((TV)ob).turnOff();
           ((TV)ob).turnOn();*/
           
           System.out.println("��...");
          
 	
	}
	
	
}
