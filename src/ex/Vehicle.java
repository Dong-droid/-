package ex;
public class Vehicle implements Moveable {
    public String name;
    private int 주행가능거리=0;
	private double 연료량;
	private double 연비;
    
	public Vehicle() {}
    
   
    public Vehicle(String name, double 연료량,double 연비){
    	this.연료량=연료량;
    	this.name=name;
    	this.연비=연비;
    	
    }
   

    
   
	public int move() {
		// TODO Auto-generated method stub
    	while(true){	
        
       
		this.연료량-=10/this.연비;
		if(this.연료량<0) {this.연료량=0;break;}
		주행가능거리+=10	;
    	show(this.연료량,this.연비,주행가능거리);
    	
    
    	}
    	return 주행가능거리;
	}


	public void show(double 연료량,double 연비, int 주행가능거리) {
		this.주행가능거리=주행가능거리;
		this.연료량=연료량;
		this.연비=연비;
    	System.out.println("---------------------------");
    	System.out.printf("%16s |  %10d    %10.2f   %10.2f\n", this.name,this.주행가능거리,this.연료량, this.연비);
    	System.out.println("---------------------------");
    	
    }
   
    	
    	
    
 public static void show(Vehicle [] vs) {
	 
	 for(int i=0;i<vs.length;i++) {
		 System.out.printf("%16s |  %10d    %10.2f   %10.2f\n", vs[i].name,vs[i].주행가능거리,vs[i].연료량, vs[i].연비);
		
		 
		 
	 }
	 
 }


}
