public class CharStack
{
  private final int MAX_CAP = 100;
  private int top; //location of top item on the stack
  private char [] s; //The stack

  public CharStack(){
    //PRE:
    //POS:
    //TAS: Create an empty stack with a default capacity
    s = new char[MAX_CAP];
    top = -1;
  }

  public void push(char element){
    //PRE:
    //POS:
    //TAS: Add a new item to the stack
    top ++;
    s[top] = element;
  }

 public char pop (){
    //PRE: Stack is not empty
    //POS: Stack size -1
    //TAS: remove and return the item on the top of the stack
     char result = s[top];
     top--;
     return result;
    }
    
  public char peek()
  {
    return s[top];
  }

 public String toString()
{
  String result = " ";
  for(int i= 0; i<= top+1; i++)
 {
   result = result + s[i] + " ";
}
 return result;
}
  public boolean isEmpty(){
    //PRE:have a stack
    //POS:stack is either empty or full (true or false result)
    //TAS: Return whether or not the stack is empty. HINT: look
    //     at the constructor.
    if(top == -1)
    {
      return true;
    }
    else
    {
      return false;
    }
   }
   

  public boolean isFull(){
    //PRE:must have stack
    //POS:stack is either empty or full(true or false result)
    //TAS: return whether or not the stack is full
   if(top == MAX_CAP-1)
   {
    return true;
   }
   else
   {
    return false;
   }
  }
}
