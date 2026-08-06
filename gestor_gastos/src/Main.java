/**
 * Entry point of the application. Responsable for initializing and starting the program execution flow
 * @author José Alejandro Díaz Delgado
 * @since 2026/07/23
 * */
import model.User;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        /* Create a List users, to save de users and sing in the program */
        List <User> users = new ArrayList<>();
        users.add(new User("Alejandro", "ale@gmail.com", "alejandro123456"));
        users.add(new User("Lucas", "luc@gmail.com", "lucas123456"));
        users.add(new User("Pepe", "Pepe@gmail.com", "pepe123456"));

        System.out.println("=======================================");
        System.out.println("|          WELCOME TO GASTAPP         |");
        System.out.println("=======================================");
        System.out.println("");
        System.out.println("1. Sign in");
        System.out.println("2. Sign up");
        System.out.println("3. Exit");
        System.out.print("->");

        int election = sc.nextInt();
        sc.nextLine();

        boolean stop = true;

        switch(election){

            case 1:

                break;

            case 2:
                break;


            case 3:
                stop = false;
                break;

            default:
                System.out.println("the value entered is invalid");
                break;

        }

        if (stop) {
            do {
                System.out.println("Select a option");
                System.out.println("1. Ver datos del usuario  ");
                switch () {

                }

            } while (stop);
        }
    }
}