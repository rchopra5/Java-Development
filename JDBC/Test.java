package JDBC;

public class Test{

    public static void function(int[][] arr)
    {
        int vertIndex = 0;
        int horizIndex = 0;

        // search through the 2d array for an element i,j ==0
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[i].length; j++)
            {
                if(arr[i][j] == 0)
                {
                    //print ith row and jth column all 0s
                    vertIndex = i;
                    horizIndex = j;

                }
                
                
            }
        }
        // if vertical index i is 0, then print every row to 0
        for(int k = 0; k < arr[vertIndex].length; k++)
        {
            arr[vertIndex][k] = 5;
        }   

        //if horizontal index j is at 0, then print every vlaue in column 0
        for(int l = 0; l < arr.length; l++)
        {
            arr[l][horizIndex] = 0;
        }

        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[i].length; j++)
            {
                System.out.print(arr[i][j]);
                
            }
            System.out.println("\n");
        }
        
    }
    public static void main(String[] args)
    {
        int[][] arr1 = { { 0, 0, 1 }, { 1, 0, 0}, {1,0,1} };
        function(arr1);
    }
}