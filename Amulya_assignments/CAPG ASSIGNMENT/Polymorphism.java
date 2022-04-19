package polymorphism;


class Bike{
	void run(){
		
	   System.out.println("running");
	 }  
}  
public class poly extends Bike{
	  void run(){
		  
		  System.out.println("running safely with 60km");
		  }  

	public static void main(String[] args) {
		
	    Bike b = new poly();
	    b.run();  
		

	}

}