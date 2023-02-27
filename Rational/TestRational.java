import java.util.Scanner;
class Rational
{
    private int num;
    private int den;

    public Rational()
    {
        this.num = 0;
        this.den = 1;
    }

    public Rational(int numerator, int denominator)
    {
        this.num = numerator;
        this.den = denominator;
    }

    public static int cmmdc(int y, int z)
    { 
        int cmmdc1 = 0;
        for(int i=2;i<=y && i<=z;i++)
	    {
		    if(y%i==0 && z%i==0)
		    {
                cmmdc1 = i;
            }
		}
          return cmmdc1;
    }

    public Rational Computing(Rational y)
    {
        int x = 1;
        
        x = cmmdc(y.num, y.den);
        if(x == 0 )
        {
            x = 1;
        }
        y.num= y.num/x;
        y.den= y.den/x;
        return y;
    }
    public Rational add(Rational y, Rational z)
    {
        y.num = ((y.num * z.den)+(y.den * z.num));
        y.den = (y.den * z.den);
      
      return y;
    }

    public Rational sub(Rational y, Rational z)
    {
      y.num=((y.num * z.den)-(y.den * z.num));
      y.den=(y.den * z.den);

      return y;
    }
    public Rational mult(Rational y, Rational z)
    {
      y.num=(y.num * z.num);
      y.den=(y.den * z.den);
      
      return y;
    }
    public Rational div(Rational y, Rational z)
    {
      y.num=(y.num * z.den);
      y.den=(y.den * z.num);
      return y;
    }
    public void intFormat()
    {
        System.out.println(" "+this.num + "/" + this.den);
    }
    public void realFormat()
    {
        double x;
        x = (double)this.num/this.den;
        System.out.print(x);
    }  


}

public class TestRational
{
    public static void main(String[] args)
    {
        /*
        //function 1
        Scanner cin = new Scanner(System.in);
        Rational nr1 = new Rational (2,3);
        Rational nr2 = new Rational (4,5);
        nr1.intFormat();
        nr1.realFormat();
        System.out.println();
        nr1.add(nr1,nr2);
        nr1.Computing(nr1);
        System.out.println();
        nr1.intFormat();
        nr1.realFormat();
        */
        
        /*
        //function 2
        Scanner cin = new Scanner(System.in);
        Rational nr1 = new Rational (14,17);
        Rational nr2 = new Rational (5,9);
        nr1.intFormat();
        nr1.realFormat();
        System.out.println();
        nr1.sub(nr1,nr2);
        nr1.Computing(nr1);
        System.out.println();
        nr1.intFormat();
        nr1.realFormat();
        */

        /*
        //function 3
        Scanner cin = new Scanner(System.in);
        Rational nr1 = new Rational (2,3);
        Rational nr2 = new Rational (7,10);
        nr1.intFormat();
        nr1.realFormat();
        System.out.println();
        nr1.mult(nr1,nr2);
        nr1.Computing(nr1);
        System.out.println();
        nr1.intFormat();
        nr1.realFormat();
        */
        
        /*
        //function 4
        Scanner cin = new Scanner(System.in);
        Rational nr1 = new Rational (4,5);
        Rational nr2 = new Rational (7,10);
        nr1.intFormat();
        nr1.realFormat();
        System.out.println();
        nr1.div(nr1,nr2);
        nr1.Computing(nr1);
        System.out.println();
        nr1.realFormat();
        nr1.intFormat();
        */
        
        
        
    }
}