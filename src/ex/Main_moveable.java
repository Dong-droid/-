package ex;

public class Main_moveable {
      public static void main(String[] args) {
    	  
    	  Moveable ob=new Dog();
    	  Animal aDog = new Dog();
    	  Dog kong=new Dog();
    	  
    	  ob.brake();
    	  ob.drive();
    	  ob.stop();
    	  //ob.bark(); ��ü �޼ҵ�
    	  aDog.move("��ũ����!");
    	  aDog.drive();
    	  aDog.bark();
    	  aDog.brake();   //Animal�� ������ Moveable�� ���ԵǾ� �ֱ� ������ �̷��Ե� �����ϴ�!
    	  
    	  kong.bark();
    	  kong.brake();
    	  kong.drive();
    	  kong.stop();
    	  
    	  
      }
}
