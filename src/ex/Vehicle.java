package ex;
public class Vehicle implements Moveable {
    public String name;
    private int ���డ�ɰŸ�=0;
	private double ���ᷮ;
	private double ����;
    
	public Vehicle() {}
    
   
    public Vehicle(String name, double ���ᷮ,double ����){
    	this.���ᷮ=���ᷮ;
    	this.name=name;
    	this.����=����;
    	
    }
   

    
   
	public int move() {
		// TODO Auto-generated method stub
    	while(true){	
        
       
		this.���ᷮ-=10/this.����;
		if(this.���ᷮ<0) {this.���ᷮ=0;break;}
		���డ�ɰŸ�+=10	;
    	show(this.���ᷮ,this.����,���డ�ɰŸ�);
    	
    
    	}
    	return ���డ�ɰŸ�;
	}


	public void show(double ���ᷮ,double ����, int ���డ�ɰŸ�) {
		this.���డ�ɰŸ�=���డ�ɰŸ�;
		this.���ᷮ=���ᷮ;
		this.����=����;
    	System.out.println("---------------------------");
    	System.out.printf("%16s |  %10d    %10.2f   %10.2f\n", this.name,this.���డ�ɰŸ�,this.���ᷮ, this.����);
    	System.out.println("---------------------------");
    	
    }
   
    	
    	
    
 public static void show(Vehicle [] vs) {
	 
	 for(int i=0;i<vs.length;i++) {
		 System.out.printf("%16s |  %10d    %10.2f   %10.2f\n", vs[i].name,vs[i].���డ�ɰŸ�,vs[i].���ᷮ, vs[i].����);
		
		 
		 
	 }
	 
 }


}
