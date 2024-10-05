//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String [][] cars = new String[3][3];

        String [][] cars2 = {
                {"BMW", "Mercedes", "Audi"},
                {"Volvo", "Ford", "Mazda"},
                {"Toyota", "Honda", "Ford"}

        };



//        Row 0, --->
        cars[0][0] = "BMW";
        cars[0][1] = "Mercedes";
        cars[0][2] = "Audi";

//        Row 1, colum
        cars[1][0] = "Volvo";
        cars[1][1] = "Ford";
        cars[1][2] = "Mazda";

//        Row 2, column
        cars[2][0] = "Toyota";
        cars[2][1] = "Honda";
        cars[2][2] = "Ford";

//        Skriver ut allt, alla rader, alla kolumner
        for (int i = 0; i < cars.length; i++) {
            System.out.println();
            for (int j = 0; j < cars[i].length; j++) {
                System.out.print(cars[i][j] + " ");
            }

        }
        System.out.println();
        System.out.println(cars[2][0]); //Toyota

    }
}

/* Ideas
2d array for checkboard? 1-9?
scanner for user 1 and 2 input?
try catch -> what if user puts other values than int/string? default values?
rules? how to understand the game?
scanner.close()?
player 1 = x
player 2 = o
player 1, your turn..
player 2 your turn..

if statemente/switch, case block -> if square is already taken, return? "square is already taken, try a new one"
Nobody won, tie? start over?
set properties as private, no need for someone to play around the "board"?, scores?
scanner -> Player 1, what's your name? - enter name
scanner -> Player 2, what's your name? - enter name
print out board, change 2d array[][] for actual user input values?

 */