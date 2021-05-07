package ex;

import java.util.Scanner;

public class Triangle implements Geomtry {

	
	 Scanner sc=new Scanner(System.in);
	    public int n;
	    
		public Triangle() {
		System.out.println("정삼각형 한 변의 길이를 입력:");
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
