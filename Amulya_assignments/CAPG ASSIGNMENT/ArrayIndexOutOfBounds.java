package capg.training;

//IndexOutOfBoundsException :Thrown to indicate that an index of some sort (such as to an array, to a string, or to a vector) is out of range.

//ArrayIndexOutOfBoundsException, StringIndexOutOfBoundsException are two classes, which have implemented IndexOutOfBoundsException.

//ArrayIndexOutOfBoundsException: Thrown to indicate that an array has been accessed with an illegal index. The index is either negative or greater than or equal to the size of the array.

public class ArrayIndexOutOfBounds {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int arr[]= {1,2,3,4,5};
			System.out.println(arr[21]);
		}
		//catch(ArrayIndexOutOfBoundsException e) {
			//System.out.println("Array Boundary");
			
		//} 
		catch(Exception g) {
			System.out.println(g);
			
		}

	}

}