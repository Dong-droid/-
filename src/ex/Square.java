package ex;
import java.util.Scanner;

public class Square implements Geomtry {
    Scanner sc=new Scanner(System.in);
    public int n;
    
	public Square() {
	System.out.println("���簢�� �� ���� ���̸� �Է�:");
	n=sc.nextInt();}
	
    @Override
	public double area() {
	         	
		// TODO Auto-generated method stub
		return n*n;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 4*n;
	}

}
