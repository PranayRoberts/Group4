package Inheritance;

class Employee{  
    float salary=40000;  
   }  
   class Inheritance extends Employee{  
    int bonus=10000;  
    public static void main(String args[]){  
    	Inheritance p=new Inheritance();  
      System.out.println("Employee salary is:"+p.salary);  
      System.out.println("Bonus of Employee is:"+p.bonus);  
   }  
   }  