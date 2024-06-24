package org.fundamentos;

public class PlayValues {

    void pruebasString(){
        String txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println("The length of the txt string is: " + txt.length());

        txt = "Hello World";
        System.out.println(txt.toUpperCase());   // Outputs "HELLO WORLD"
        System.out.println(txt.toLowerCase());   // Outputs "hello world"

        txt = "Please locate where 'locate' occurs!";
        System.out.println(txt.indexOf("locate")); // Outputs 7

        String firstName = "John";
        String lastName = "Doe";
        System.out.println(firstName + " " + lastName);
        System.out.println(firstName.concat(lastName));

    }

    void pruebasMath(){
        Math.max(5, 10);
        Math.min(5, 10);
        Math.sqrt(64);   //  The Math.sqrt(x) method returns the square root of x:
        Math.abs(-4.7);  //  The Math.abs(x) method returns the absolute (positive) value of x:
        Math.random();  //  Math.random() returns a random number between 0.0 (inclusive), and 1.0 (exclusive).  El numero de decimales es equivalente a un tipo duble
        int randomNum = (int)(Math.random() * 101);  // 0 to 100
    }

    void break_continue(){

        //  This example stops the loop when i is equal to 4:
        for (int i = 0; i < 10; i++) {
            if (i == 4) {
                break;
            }
            System.out.println(i);
        }

        //  This example skips the value of 4:
        for (int i = 0; i < 10; i++) {
            if (i == 4) {
                continue;
            }
            System.out.println(i);
        }
    }

    void arrays(){
        String[] cars;
        String[] cars2 = {"Volvo", "BMW", "Ford", "Mazda"};
            cars2[0] = "Opel";
            System.out.println(cars2[0]);
        int[] myNum = {10, 20, 30, 40};
            System.out.println(myNum.length);
            // Loop through the elements of the array
            int sum=0;
            for (int age : myNum) {
                sum += age;
            }

            // Bidimencional
        int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
    }


}
