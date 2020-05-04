package com.uttiya.calc;

import java.util.Scanner;

public class Basic {

    public static void main(String[] args) {

        float a, b, res;
        char choice;
        Basic basic=new Basic();

        do {

            Scanner sc = new Scanner(System.in);

            System.out.println("Menu");
            System.out.println("1.Add");
            System.out.println("2.Subtract");
            System.out.println("3.Multiply");
            System.out.println("4.Divide");
            System.out.println("5. Exit");

            System.out.println("Enter your choice:");
            choice = sc.next().charAt(0);
            System.out.println("Add first number:");
            a = sc.nextFloat();
            System.out.println("Add second number:");
            b = sc.nextFloat();

            switch (choice) {


                case '1':

                    res = basic.add(a, b);
                    System.out.println("Sum is =" + res);
                    break;

                case '2':
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        }while (choice != '5');

    }

    float add(float a,float b){

        float res=a+b;
        return res;

    }
}
