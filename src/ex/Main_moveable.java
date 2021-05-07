package ex;

public class Main_moveable {
      public static void main(String[] args) {
    	  
    	  Moveable ob=new Dog();
    	  Animal aDog = new Dog();
    	  Dog kong=new Dog();
    	  
    	  ob.brake();
    	  ob.drive();
    	  ob.stop();
    	  //ob.bark(); 자체 메소드
    	  aDog.move("경크구요!");
    	  aDog.drive();
    	  aDog.bark();
    	  aDog.brake();   //Animal의 관점에 Moveable이 포함되어 있기 때문에 이렇게도 가능하다!
    	  
    	  kong.bark();
    	  kong.brake();
    	  kong.drive();
    	  kong.stop();
    	  
    	  
      }
}
