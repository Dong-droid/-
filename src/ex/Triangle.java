package ex;

import java.util.Scanner;

public class Triangle implements Geomtry {

	
	 Scanner sc=new Scanner(System.in);
	    public int n;
	    
		public Triangle() {
		System.out.println("���ﰢ�� �� ���� ���̸� �Է�:");
		n=sc.nextInt();}
	
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return n*n/2;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 3*n;
	}

}
