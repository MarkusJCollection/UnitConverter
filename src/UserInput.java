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



    public int askWhich(){
        System.out.printf("""
                What converter would you like to use? (1,2,3)
                1: Currency Converter
                2: Weights Converter
                3: Distance Converter\n""");
        try{
            return Integer.parseInt(sc.nextLine());
        }catch(NumberFormatException ex){
            System.out.println("Invalid choice.");
            return 0;
        }catch(Exception ex){
            System.out.println(ex);
            return 0;
        }
    }



    public void askUser(){
        this.userChoice[0] = askNum();
        this.userChoice[1] = askFROMConversion();
        this.userChoice[2] = askTOConversion();
    }
    public UserInput(){
    }


    public UserInput(String num, String c1, String c2){
        this.userChoice[0] = num;
        this.userChoice[1] = c1;
        this.userChoice[2] = c2;
    }



}
