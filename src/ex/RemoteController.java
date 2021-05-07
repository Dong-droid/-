package ex;

public interface RemoteController {

    public abstract void turnOn();

    public abstract void turnOff();

    public default void changeObj() {
    	
    	System.out.println("다른 장치로 바꾸기");
    }

}
