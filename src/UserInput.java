import java.util.Scanner;

public class UserInput {
    //Java class that contains many user-input related functions.
    public Scanner sc = new Scanner(System.in);


    String[] userChoice = {null, null, null};


    public String askNum(){
        System.out.println("Please enter the value you'd like to convert.\n");
        return sc.nextLine();
    }
    public String askFROMConversion(){
        System.out.println("Please enter the starting unit.\n");
        return sc.nextLine();
    }

    public String askTOConversion(){
        System.out.println("Please enter your desired ending unit.\n");
        return sc.nextLine();
    }

    public void askUser(){
        userChoice[0] = askNum();
        userChoice[1] = askFROMConversion();
        userChoice[2] = askTOConversion();
    }


}
