import java.util.Scanner;
public class OpStack
{
  public static void main (String [] args)
  {
    
    
 
    System.out.println("Enter Infix notation expression:");
    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine();
    System.out.println("Postfix notation = " + convert(input));
 
  }//main method
  public static String convert(String input)
  {
    CharStack opstack = new CharStack();
    //(1+2)*7opstack.push('#');//end of the stack
    char current;
    String postfix = "";
 
 
    for(int i = 0; i<input.length(); i++)
    {
       current = input.charAt(i);
       
      if(isOperand(current))
      {
       postfix += current;
      }//if
      else if(current == '(')
      {
       opstack.push(current);
      }//elseIf
      else if(current == ')')
      {
        while(opstack.peek() != '(')
        {
          postfix = postfix + opstack.pop();
        }//
        opstack.pop();
      }//elseIf
      else if(isOperator(current))
      {
        while(opstack.isEmpty()!=true && 
         isOperator(opstack.peek()) &&
         findPrecedence(opstack.peek())>=findPrecedence(current))
        {
          postfix = postfix + opstack.pop();
        }//while
        System.out.println("push operator to stack");
        opstack.push(current);
      }//elseIf
    }//forLoop
    //System.out.println("stack top:"+opstack.peek());
    while(!opstack.isEmpty()){
     postfix += opstack.pop();
    }
    return postfix;
  }//convert method
  
public static boolean isOperand(char c)
//Helper method
{
 if((c >='a'&& c <='z')||
    (c>='A'&& c<='Z')  ||
    (c>= '0'&& c <='9'))
    {
     return true;
    }//if
 else
 {
  return false;
 }//else
 
}//isOperand

public static boolean isOperator(char c)
{
 if((c=='+') ||
    (c=='-') ||
    (c=='/') ||
    (c=='*')){
     return true;
    }//if
  else
  {
   return false;
  }//else
}//isOperator

 private static int findPrecedence(char c){
  if(c == '/' || c == '*'){
   return 2;
  } else{
   return 1;
  }
 }//findPrecedence

}//class
