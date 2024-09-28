package Tasks;

/*
 * Build a program that generates a random number and challenges the user to guess it.
 * The program should prompt the user to input their guess, compare it to the generated number.
 */
import java.util.*;

public class Prob2
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String flag = "";
        do
        {
            System.out.println("Enter a number between 1 to 10");
            int n = in.nextInt();
            if(compare(n))
                System.out.println("Your prediction is correct!");
            else
                System.out.println("Your prediction is wrong");
            System.out.println();
            System.out.println("Do you wish to continue?");
            System.out.println("Y/N");
            in.nextLine();
            flag = in.nextLine();
        }while(flag.equalsIgnoreCase("y"));
    }
    static boolean compare(int n)
    {
       double r = (int)(Math.random()*10) + 1;
       System.out.println("The random generated number is " + (int)(r)); 
       return n==r;
    }
}