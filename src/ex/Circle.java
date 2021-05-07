package ex;

import java.util.Scanner;

public class Circle implements Geomtry {

	 Scanner sc=new Scanner(System.in);
	    public int n;
	    
		public Circle() {
		System.out.println("원의 반지름의 길이를 입력:");
		n=sc.nextInt();}
	
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return n*PI*n;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 2*PI*n;
	}

}
