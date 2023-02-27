import java.util.*;
import java.util.Scanner;

public class MatrixCalculations
{
	public static int sumMainDiagonal(int m[][])
	{
		int sum1=0;
		for(int i=0;i<m.length;i++)
		{
			for(int j=0;j<m[i].length;j++)
			{
				if(i==j)sum1=sum1+m[i][j];
			}
		}
		return sum1;
	}
	public static int sumUnderMainDiagonal(int m[][])
	{
		int sum2=0;
		for(int i=0;i<m.length;i++)
		{
			for(int j=i;j>=0;j--)
			{
			 sum2=sum2+m[i][j];
			}
		}
		return sum2;
	}
	public static int[][] matrixMultiplication(int m[][], int n[][])
	{
	    int mn[][]=new int[10][10];
	    int n1 = m.length;
		int n2 = n.length;
		int m1 = m[0].length; 
		int m2 = n[0].length;
	    int i,j;
		   for (i=0;i<n1;i++)
			for (j=0;j<m2;j++)
		   {
		     mn[i][j]=0;
             for(int k=0; k<n2 ;k++)
			 {  
					mn[i][j]+=m[i][k]*n[k][j];
			 }
		   }
	    return mn;
	}
      
	public static void main(String args[])
	{
		int[][] a={{1,2,3,4},{12,13,14,15},{11,16,15,6},{10,9,8,7}};
		int[][] b={{1,2,3,4},{12,13,14,15},{11,16,15,6},{10,9,8,7}};
		int s1,s2,i,j;
		int[][] c=new int[a.length][b[0].length];
		
		s1=sumMainDiagonal(a);
		System.out.println("The sum of the main diagonal is = " + s1);
		s2=sumUnderMainDiagonal(a);
		System.out.println("The sum under the main diagonal is = " + s2);
		System.out.println();
		int n = b.length;
		int m = a[0].length; 
		if (m != n) 
		{ 
			System.out.println("The matrices cannot be multiplied! ");
		}
		else
		{
			c=matrixMultiplication(a,b);
			System.out.println("The multiplication of the 2 matrices is: ");
		   for(i=0;i<a.length;i++)
           {
            System.out.println();
			
              for(j=0;j<b[i].length;j++)
			  {
				System.out.print(c[i][j]+ " ");
			  }
           }
		}
		
	}
}
		
			
	
		
	
		
				
	