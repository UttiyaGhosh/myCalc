package com.uttiya.calc;

import java.util.Scanner;
import org.apache.log4j.Logger;

public class Basic {

    private static final Logger logger = Logger.getLogger(Basic.class);

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

            switch (choice) {

                case '1':
                    System.out.println("Enter first number:");
                    a = sc.nextFloat();
                    System.out.println("Enter second number:");
                    b = sc.nextFloat();
                    res = basic.add(a, b);
                    System.out.println("Sum is = " + res);
                    break;

                case '2':
                    System.out.println("Enter first number:");
                    a = sc.nextFloat();
                    System.out.println("Enter second number:");
                    b = sc.nextFloat();
                    res = basic.subtract(a, b);
                    System.out.println("Difference is = " + res);
                    break;

                case '3':
                    System.out.println("Enter first number:");
                    a = sc.nextFloat();
                    System.out.println("Enter second number:");
                    b = sc.nextFloat();
                    res = basic.multiply(a, b);
                    System.out.println("Product is = " + res);
                    break;

                case '4':
                    System.out.println("Enter first number:");
                    a = sc.nextFloat();
                    System.out.println("Enter second number:");
                    b = sc.nextFloat();
                    res = basic.divide(a, b);
                    if(res==Float.POSITIVE_INFINITY)
                        System.out.println("Division by 0 is not possible");
                    else
                        System.out.println("Quotient is = " + res);
                    break;

                case '5':
                    System.out.println("Bye!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        }while (choice != '5');

    }

    float add(float a,float b){
        logger.info("Adding " + a + " with " + b);
        float c=a+b;
        logger.info("Result is " + c);
        return c;
    }

    float subtract(float a,float b){
        logger.info("Subtracting " + a + " from " + b);
        float c=a-b;
        logger.info("Result is " + c);
        return c;
    }

    float multiply(float a,float b){
        logger.info("Multiplying " + a + " with " + b);
        float c=a*b;
        logger.info("Result is " + c);
        return c;
    }

    float divide(float a, float b) {
        logger.info("Dividing " + a + " by " + b);
        if(b==0) {
            logger.info("Division by zero error");
            return Float.POSITIVE_INFINITY;
        }else {
            float c=a/b;
            logger.info("Result is " + c);
            return c;
        }
    }

}