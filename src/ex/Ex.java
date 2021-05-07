package ex;
import java.util.Scanner;
import java.math.*;
public class Ex {
	public static void sortArray(int [] arr) {
		
		int temp=0;
		for(int i=0;i<arr.length;i++)
			for(int j=0;j<arr.length-1;j++)
				if(arr[i]<arr[j])
					{temp=arr[j];
		            arr[j]=arr[i];
		            arr[i]=temp;}
							
					
		
	}
	public static void setArray_random(int [] arr,int start, int end) {
		
		for(int i=0;i<arr.length;i++)
		     arr[i]=(int)(Math.random()*1000)%(end-start+1)+start;
			
		
		
		
	}
	
	
	public static void main(String[] args) {
                  
                   Scanner input=new Scanner(System.in);
                   
                   int [] arr=new int[10];
                   
                     
                   System.out.print("범위를 입력하세요(ex.1 100)");
                   int start=input.nextInt();
                   int end=input.nextInt();
                   
                   setArray_random(arr,start,end);
                     
                   System.out.println("정렬 전");
                    
                   for(int i=0;i<10;i++)
                    	 System.out.print(arr[i]+"  ");
                     
                      sortArray(arr);
                      
                      System.out.println();
                      System.out.println("정렬 후");
                      
                      for(int i=0;i<arr.length;i++)
                     	 System.out.print(arr[i]+"  ");
                   
                  
                 
	}
}
