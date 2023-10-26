package Autoboxing;
public class AutoBoxingDemo {
    public static void main(String [] args)
    {
        int i = 10;

        //Autobox
        Integer iObj = Integer.valueOf(i);
        System.out.println("value of Integer obj: " + iObj);

        // auto - unbox 
        int i1 = iObj;
        System.out.println("value of i1: " + i1);

        Character charObj = 'a';
        char ch = charObj;
        System.out.println("Value of ch: " + ch);
        System.out.println("value of charObj: " + charObj);


    }
}