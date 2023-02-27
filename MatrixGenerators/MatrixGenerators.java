import java.util.*;
import java.util.Scanner;

public class MatrixGenerators
{
	public static int[][] matrix1(int size)
		{
			int m[][]=new int[size][size];
			int ct=1;
			for (int i=0;i<size;i++)
			{
				for(int j=0;j<size;j++)
				{
					m[i][j]=ct;
					ct++;
				}
			}
			return m;
		}
	public static int[][] matrix2(int size)
		{
			int n[][]=new int[size][size];
			int ct=1;
			for(int i=0;i<size;i++)
			{
				for(int j=0;j<size;j++)
				{
					n[j][i]=ct;
					ct++;
				}
			}
			return n;
		}
	public static int[][] matrix3(int size)
	{
		int mn[][]=new int[size][size];
		int j,ct=1;
		 for (int i=0; i<size; i++)
		 {
			 if (i%2==0)
			 {
				 for (j=0;j<size;j++)
				 {
					 mn[i][j]=ct;
					 ct++;
				 }
			 }
			 else 
			 {
				 for(j=size-1;j>=0;j--)
				 {
					 mn[i][j]=ct;
					 ct++;
				 }
			 }
		 }
		 return mn;
	}
	public static int[][] matrix4(int size) 
	{
	  int val=1;
	  int m=size,n=size;
	  int i,j;
	   int mnm[][]=new int[size][size];
		
        int k=0,l=0;
        while (k<m && l<n)
		{
            for ( i=l;i<n;++i)
			{
                mnm[k][i] = val++;
            }
 
            k++;
            for ( i=k;i<m;++i)
			{
                mnm[i][n - 1] = val++;
            }
            n--;
			
            if (k<m)
			{
                for ( i=n-1;i>=l;--i) 
				{
                    mnm[m-1][i] = val++;
                }
                m--;
            }
 
            if (l<n)
			{
                for (i=m-1;i>=k;--i)
				{
                    mnm[i][l]=val++;
                }
                l++;
            }
        }
		return mnm;
    }
	
	public static void main(String args[])
	{
	int i,j;
	int size;
	Scanner cin=new Scanner(System.in);
	System.out.println("size = ");
    size=cin.nextInt();
	int a[][]=new int[size][size];
	int b[][]=new int[size][size];
	int c[][]=new int[size][size];
	int d[][]=new int[size][size];
	
	a=matrix1(size) ;
	b=matrix2(size);
	c=matrix3(size);
	d=matrix4(size);
	 System.out.println("MATRIX 1");
	for (i=0;i<size;i++)
      {
        System.out.println();
        for (j=0;j<size;j++)
        System.out.print(a[i][j]+ " ");
      }
	  System.out.println();

	 System.out.println("MATRIX 2");
	for (i=0;i<size;i++)
      {
        System.out.println();
        for (j=0;j<size;j++)
        System.out.print(b[i][j]+ " ");
      }
	  System.out.println();

	 System.out.println("MATRIX 3");
	for (i=0;i<size;i++)
      {
        System.out.println();
        for (j=0;j<size;j++)
        System.out.print(c[i][j]+ " ");
      }
	  System.out.println();
	
	 System.out.println("MATRIX 4");
	for (i=0;i<size;i++)
      {
        System.out.println();
        for (j=0;j<size;j++)
        System.out.print(d[i][j]+ " ");
      }
	
	}
}