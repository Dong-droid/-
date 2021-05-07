
package ex;
public interface Driveable {
      public default void drive() {
    	  System.out.println("객체가 없습니다");
      }
      public default void drive(Vehicle v) {
    	  System.out.println("모든 Vehicle을 운전할 수 있습니다.");
    	  v.move();
      }
      public default void drive(Moveable m) {
    	  System.out.println("모든 Moveable한 Vehicle을 운전할 수 있습니다.");
    	 m.move();
      }
}
