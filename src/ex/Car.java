package ex;

public class Car implements RemoteController {

	@Override
	public void turnOn() {
		System.out.println("자동차 시동 켜기");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("자동차 시동 끄기");
	}

}
