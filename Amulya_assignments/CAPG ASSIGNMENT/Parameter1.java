package marchfifteen;
 //with parameter but no return type
public class Parameter1 {
    public static void main(String args[])
    {
        int a = 4;
        int b = 5;
 
        // Calling the function with 2 parameters
        calc(a, b);
    }
    public static void calc(int x, int y)
    {
        int sum = x + y;
        // Displaying the sum
        System.out.print("Sum of two numbers is :" + sum);
    }
}