// ex 1



import java.util.Scanner;
class DoubleDegree{
static int[] doubleDegreeEq(int a, int b,int c)
{
double r1=0.0,r2=0.0;
int root1,root2;
int solution[]=new int[2];
int disc=b*b-4*a*c;
if(disc==0){
r1=-b/(2*a);
r2=-b/(2*a);
}
if(disc>0){
r1=(-b+Math.sqrt(disc))/(2*a);
r2=(-b-Math.sqrt(disc))/(2*a);
}
root1=(int)r1;
root2=(int)r2;
if((r1-(int)r1)!=0)
solution[0]=0;
else
solution[0]=root1;

if((r2-(int)r2)!=0)
solution[1]=0;
else
solution[1]=root2;
return solution;
}
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
System.out.println("Enter three coefficients for quadratic equation:");
int a=sc.nextInt();
int b=sc.nextInt();
int c=sc.nextInt();
int[] res;
res=doubleDegreeEq(a,b,c);
for(int i=0;i<2;i++)
System.out.print(res[i]+" ");

}
}




// ex 2

import java.util.*;
public class Main
{ public static boolean found=false; // creating static boolean to check if elemt is present
public static void removeAll(int p,List<Integer>Nlist){

for(int i=0;i<Nlist.size();i++){
if(Nlist.get(i)==p)
{Nlist.remove(i); found=true; removeAll(p,Nlist);} //Recursion to remove all p value
}
if(found==false) System.out.println("Element not found !"); //Condition if element not found
}

public static void main(String[]args){
List<Integer> Nlist = new ArrayList<>();
//Initialising the array list
System.out.println("Enter the number of input: "); // Scanner class to take user input
Scanner k=new Scanner(System.in);
int n=k.nextInt();


for(int i=0;i<n;i++)
{
int p=k.nextInt();
Nlist.add(p);
}


System.out.println("Values inside the list is: \n"+ Nlist);

System.out.println("Enter the item you wish removed: ");
int obj_a=k.nextInt();

removeAll(obj_a,Nlist);

if(Nlist.size()>0)
System.out.println("Modified ArrayList : " + Nlist); //List display
else
System.out.println("ArrayList is Empty !");
}
}