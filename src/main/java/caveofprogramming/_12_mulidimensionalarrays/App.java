package caveofprogramming._12_mulidimensionalarrays;

public class App {

    public static void main(String[] args) {

        // Multi dimensional array is basically an array where each element is an array in itself
        // Way 1 to create a multi dimensional array
        int[][] mulDimArray = {
                {1, 2, 3},
                {3, 4, 5},
                {6, 8, 9}
        };

        // Nested loop to iterate and print each element of the array
        for(int rowIdx = 0; rowIdx < mulDimArray.length; rowIdx++) {
            for (int colIdx = 0; colIdx < mulDimArray[rowIdx].length; colIdx++) {
                System.out.print("\t" + mulDimArray[rowIdx][colIdx]);
            }
            System.out.println();
        }

        // Way 2 of creating a multi dimensional array
        // Declare size of the array at time of creation
        String[][] grid = new String[2][4];

        grid[0][0] = "Hello";
        grid[0][1] = "World";

        System.out.println(grid[0][1]);

        // Way 3 of creating a multi dim array
        // We can leave the column size empty i.e. size of one array inside the array

        int[][] htmlTable = new int[5][];
        // At a later point we can add a new array at specified row.
        htmlTable[0] = new int[2];

        htmlTable[0][0] = 10; htmlTable[0][1] = 15;

        System.out.println(htmlTable[0].length); // 2


    }

}
