import java.util.Scanner;

public class UserInput {
    //Java class that contains many user-input related functions.
    public Scanner sc = new Scanner(System.in);


    String[] userChoice = {null, null, null};


    public String askNum(){
        System.out.println("\nPlease enter the value you'd like to convert.");
        return sc.nextLine();
    }
    public String askFROMConversion(){
        System.out.println("\nPlease enter the starting unit.");
        return sc.nextLine();
    }

    public String askTOConversion(){
        System.out.println("\nPlease enter your desired ending unit.");
        return sc.nextLine();
    }

    public void askUser(){
        userChoice[0] = askNum();
        userChoice[1] = askFROMConversion();
        userChoice[2] = askTOConversion();
    }
    public UserInput(){
    }


    public UserInput(String num, String c1, String c2){
        userChoice[0] = num;
        userChoice[1] = c1;
        userChoice[2] = c2;
    }



}
