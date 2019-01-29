package ds.test.programs;

import java.util.Set;



class Base{
   private void func(){
          System.out.println("In Base Class func method !!");         
    };
}

class Derived extends Base{
    private void func(){   //  Is this a Method Overriding..????        
          System.out.println("In Derived Class func method"); 
    }      
}

public class PolyMorphism{
    public static void main(String [] args){                      
          Derived d = new Derived();
//          d.func(); 
    }
}