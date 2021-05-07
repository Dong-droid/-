package ex;

public abstract class Animal implements Moveable{
        public String name="Animal";
        public abstract void bark();
        
        public void move(String name) {
        	System.out.println(name+"moves");
        }
}
