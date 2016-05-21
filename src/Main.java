import java.util.Scanner;

public class Main {

	public static void main(String args){
		Scanner o=new Scanner(System.in);
		while(true){
			System.out.println("Enter your choice \n1. Add Edge \n2. Exit ");
			int n=o.nextInt();
			if(n==2)
				break;
			else{
				System.out.println("Enter Source");
				String source=o.next();
				System.out.println("Enter Destination");
				String destination=o.next();
				// call to add Edge
			}
		}
		o.close();
	}
}
