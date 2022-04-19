package patterns;

import java.util.Scanner;

class Program{
	public void Rightangled(int r) {
		int n = r;
	    //Outer Loop for number of Rows
	    for(int i=0;i<n;i++)
	    {
	        // printing '*' in each column.
	        for(int j=0;j<=i;j++)
	        {
	          System.out.print("* ");
	        }
	        System.out.println();
	    }
	}
public void Fullstar(int r) {
	int n=r;
	for(int i=0;i<n;i++)
    {
        for(int k=i;k<n;k++)
        System.out.print(" ");

        // printing '*' in each column.
        for(int j=0;j<=i;j++)
        {
          // We print '*' for each row.
          System.out.print("* ");
        }

        System.out.println();
    }
}

public void Leftstar(int k) {
	int a, b;
    for (a = 0; a < k; a++) {
        for (b = 2 * (k - a); b >= 0; b--) {
            System.out.print(" ");
        }
       for (b = 0; b <= a; b++) {

            System.out.print("* ");
        }
        System.out.println();
    }
}
}

public class StarPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int i=1;
			do {
				System.out.println("Enter 1:for right angle triangle 2:for left angled 3:for full star 0:to exit code");
				
				int ch=sc.nextInt();
				if (ch==0) {
					i=0;
				}
				
				Program p = new Program();
				
				switch(ch) {
				case 1:System.out.println("Enter number of rows ");
						int rows=sc.nextInt();
						p.Rightangled(rows);
						break;
				case 2:System.out.println("Enter number of rows ");
						int rows1=sc.nextInt();
						p.Leftstar(rows1);
						break;
				case 3:System.out.println("Enter number of rows ");
						int rows2=sc.nextInt();
						p.Fullstar(rows2);
						break;
				}
				
			}while(i!=0);
	}

}


