
package ex;
public interface Driveable {
      public default void drive() {
    	  System.out.println("��ü�� �����ϴ�");
      }
      public default void drive(Vehicle v) {
    	  System.out.println("��� Vehicle�� ������ �� �ֽ��ϴ�.");
    	  v.move();
      }
      public default void drive(Moveable m) {
    	  System.out.println("��� Moveable�� Vehicle�� ������ �� �ֽ��ϴ�.");
    	 m.move();
      }
}
