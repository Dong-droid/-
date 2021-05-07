package ex;

public class Dog extends Animal implements Moveable{

	@Override
	public void bark() {
		// TODO Auto-generated method stub
		System.out.println("A dog barks");
	}

	@Override
	public void drive() {
		// TODO Auto-generated method stub
		System.out.println("A dog drives");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("A dog stops");
	}

	@Override
	public void brake() {
		// TODO Auto-generated method stub
		System.out.println("A dog brakes");
	}
	public void move(String name) {
		super.move(name);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("A dog moves");
	}
 
}
