package ex;

public interface RemoteController {

    public abstract void turnOn();

    public abstract void turnOff();

    public default void changeObj() {
    	
    	System.out.println("�ٸ� ��ġ�� �ٲٱ�");
    }

}
