import java.util.Scanner;

public class UserInput {
    //Java class that contains many user-input related functions.
    public Scanner sc = new Scanner(System.in);


    String[] userChoice = {null, null, null};
    String[] converterList = {"Currency Converter",
            "Distance Converter", "Weight Converter"};



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
        int numOfOptions = 0;
        while(true) {
            System.out.println("Which converter would you like to use?");
            for (int i = 0; i < this.converterList.length; i++) {
                System.out.printf("%d: %s\n", i + 1, this.converterList[i]);
                numOfOptions = i + 1;
            }
            try {
                int optionPicked = Integer.parseInt(sc.nextLine());
                if (optionPicked <= numOfOptions && optionPicked > 0) {
                    return optionPicked;
                } else {
                    System.out.printf("Invalid choice, must be 1-%d\n", numOfOptions);
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid choice, must be a number.");
            } catch (Exception ex) {
                System.out.println(ex);
            }
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
