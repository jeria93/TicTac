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