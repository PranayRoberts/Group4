package upcasting;

class Parent {
    String name;
 
    // A method which prints the
    // signature of the parent class
    void method()
    {
        System.out.println("Method from Parent");
    }
}



class Child extends Parent {
    int id;
 
    // Overriding the parent method
    // to print the signature of the
    // child class
    @Override void method()
    {
        System.out.println("Method from Child");
    }
}





public class Upcasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Parent p = new Child();
        p.name = "GeeksforGeeks";
 

        System.out.println(p.name);

        
        p.method();
 
       
 
       
        Child c = (Child)p;
 
        c.id = 1;
        System.out.println(c.name);
        System.out.println(c.id);
        c.method();
		

	}

}