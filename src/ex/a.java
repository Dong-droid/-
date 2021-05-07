package ex;

public class a {
	public static void main(String[] args) {
		
		강아지 d1 = new 강아지();
		강아지 d2 = new 강아지() {
			
			public void 공부하기() {
			 System.out.println("공부하기");}
		};
		강아지 d3 = new 강아지 () {
			int 공부시간=5;
			public void 과제하기() {
				System.out.println("과제 수행하기");
			}
			public void 공부하기() {
				for (int i=0;i<공부시간;i++)
					과제하기();
			}
		};	
		강아지 요롱이 = new 강아지() {};
		d1.공부하기();
		d2.공부하기();
		d3.공부하기();
		
		
  
	}
	
	
	
     }

