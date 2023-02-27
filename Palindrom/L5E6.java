public class L5E6
{
   public static boolean palindrome(String s)
	{
        int x;
        if(s.length()%2!=0)
            x=(s.length()-1)/2;
        else
            x=s.length()/2;
        for(int i=0;i<x;i++)
	{
            if(s.charAt(i)!=s.charAt(s.length()-i-1))
	    {
                return false;
            }
        }
        return true;
            
    }
	/*public static boolean palindrome(String s)
	{   
	    if(s.length()<=1)
		
			return true;
		
		else 
		
			if(s.charAt(0)!=s.charAt(s.length()-1))
		
				return false;
		
		else 
		
			return palindrome(s.substring(1,s.length()-1));
		
	    
	}*/
	
    public static void main(String[] args)
    {
       System.out.print(palindrome("palindrome"));
    }
}