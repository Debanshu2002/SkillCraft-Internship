package Tasks;
/*
 * Create a program that converts temperatures between Celsius, Fahrenheit and Kelvin scales
 */
import java.util.Scanner;

class Convert 
{
    public double CelToKel(double t) 
    {
        return t + 273.15;
    }

    public double CelToFahr(double t) 
    {
        double f = (9.0 / 5) * t + 32;
        return f;
    }

    public double FahrToCel(double t) 
    {
        double c = (t - 32) * 5 / 9.0;
        return c;
    }

    public double FahrToKel(double t) 
    {
        double k = (5.0 / 9) * (t - 32) + 273.15;
        return k;
    }

    public double KelToCel(double t) 
    {
        return t - 273.15;
    }

    public double KelToFahr(double t) 
    {
        double f = (9.0 / 5) * (t - 273.15) + 32;
        return f;
    }
}

public class Prob1 
{
    public static void main(String args[]) 
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Input your temperature with units...");
        System.out.println("Input should be in Celsius(C)/Fahrenheit(F)/Kelvin(K)");

        String s = in.nextLine().toUpperCase().trim();
        char unit = s.charAt(s.length() - 1);
        double temp = Double.parseDouble(s.substring(0, s.length() - 1));

        Convert ob = new Convert();
        switch (unit) 
        {
            case 'C':
                System.out.println("Input is in Celsius");
                System.out.println("Celsius -> Kelvin : " + ob.CelToKel(temp) + " K");
                System.out.println("Celsius -> Fahrenheit : " + ob.CelToFahr(temp) + " F");
                break;
            case 'F':
                System.out.println("Input is in Fahrenheit");
                System.out.println("Fahrenheit -> Kelvin : " + ob.FahrToKel(temp) + " K");
                System.out.println("Fahrenheit -> Celsius : " + ob.FahrToCel(temp) + " C");
                break;
            case 'K':
                System.out.println("Input is in Kelvin");
                System.out.println("Kelvin -> Celsius : " + ob.KelToCel(temp) + " C");
                System.out.println("Kelvin -> Fahrenheit : " + ob.KelToFahr(temp) + " F");
                break;
            default:
                System.out.println("Unit is not defined!");
        }
    }
}
