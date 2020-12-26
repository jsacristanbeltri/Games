//Author: Jorge Sacristan Beltri
//Exercise for Units 1 to 4
//Games Aplication. 

import java.util.Scanner;

public class Games
{
    //Generate a random number between two numbers.
    public static int generateNumber(int min, int max)
    {
        int numberRandom= min+(int)(Math.random() * max);
    
        return numberRandom;
    }

    //Check if exist some repeating numbers.
    public static boolean checkRepeatNumber(int numberToCheck, int[] numbers)
    {
        boolean exist=false;
        
        for(int i=0;i<numbers.length && exist!=true;i++)
        {
            if(numbers[i]==numberToCheck)
            {
               exist=true;
            }
        }
        
        return exist;
    }

    //Generate an array of integer numbers between a maximum and minimum
    public static int[] generateLottery()
    {
        int [] numbersLottery = new int [6];
        int temp,i=0;

        while(i<6)
        {
            temp=generateNumber(1,49);
            if(checkRepeatNumber(temp, numbersLottery)==false)
            {
                numbersLottery[i] = temp;            
                i++;
            }


        }
        return orderNumbers(numbersLottery);
    }

    //Order an array of integer numbers
    public static int[] orderNumbers(int [] numbers)
    {
        int temp=0;
        for(int i=0;i<numbers.length-1;i++)
        {
            for (int j=i+1;j<numbers.length;j++)
            {
                if(numbers[j]<numbers[i])
                {
                    temp=numbers[i];
                    numbers[i]=numbers[j];
                    numbers[j]=temp;
                }
            }
        }
        return numbers;
    }

    //Check if some number match between two integer array.
    public static int checkLottery(int[] user, int[] winner)
    {
        int numberOfWinners=0;
        
        for (int i=0;i<user.length;i++)
        {
            for (int j=0;j<winner.length;j++)
            {
                if(user[i]==winner[j])
                    numberOfWinners++;
            }
        }
        
        return numberOfWinners;
    }

    //Game Nim class .
    public static void playNim(int number)
    {
        Scanner sc = new Scanner(System.in);
        String turn ="User";
        int quantityChipsOpcion =0;

        System.out.printf("Playing Nim with %d chips.", number);
        System.out.println();
        while (number>1)
        {
            if(turn.equals("User")) // User Turn
            {
                System.out.println("Your turn. Choose how many chips to" +
                        " substract:");
                quantityChipsOpcion=sc.nextInt();

                if(number>2)
                {
                    while(quantityChipsOpcion<1 || quantityChipsOpcion>3)
                    {
                        System.out.println("Wrong number, please type a " +
                                "number between 1 and 3");
                        System.out.println("Choose how many chips to " +
                                "substract:");
                        quantityChipsOpcion=sc.nextInt();
                    }
                }
                else
                {
                    while(quantityChipsOpcion<1 || quantityChipsOpcion>number)
                    {
                        System.out.printf("Wrong number, please type a " +
                                "number between 1 and %d ", number);
                        System.out.println("Choose how many chips to " +
                                "substract:");
                        quantityChipsOpcion=sc.nextInt();
                    }
                }


                number-=quantityChipsOpcion;
                System.out.printf("%d chips pending.",number);
                System.out.println();
                turn="Computer";

            }
            else //Computer turn
            {
                if(number>2)
                    quantityChipsOpcion=generateNumber(1,3);

                else
                    quantityChipsOpcion=generateNumber(1,number);


                System.out.printf("Computer substracts %d chips.",
                        quantityChipsOpcion);
                System.out.println();
                number-=quantityChipsOpcion;
                System.out.printf("%d chips pending.",number);
                System.out.println();
                turn="User";
            }
        }
        if(turn.equals("User"))
            System.out.println("YOU LOSE");
        else
            System.out.println("YOU WIN");
    }

    //Lottery class
    public static void playLottery()
    {
        Scanner sc = new Scanner (System.in);
        int [] numbersLottery = new int [6];
        int [] numbersUser= new int [6];
        int winners=0;

        //numbersUser=generateLottery();
        try
        {
            System.out.println("Enter your combination:");
            for(int i=0;i<6;i++)
                numbersUser[i]=sc.nextInt();

        }
        catch (NumberFormatException e1){
            System.out.printf("Error number format: %s", e1);
        }
        catch (Exception eN){
            System.out.printf("Error: %s", eN);
        }

        numbersLottery = generateLottery();
        sc.close();
        System.out.println("This is the winner combination:");
        for(int i=0;i<numbersLottery.length;i++)
        {
            System.out.print(""+numbersLottery[i]+ " ");
        }

        winners=checkLottery(numbersLottery,numbersUser);
        System.out.println();
        System.out.printf("You have %d hits.", winners);

    }

    public static void main(String[] args)
    {
        if(args.length>0 && args.length<3 )
        {
            if(args[0].equals("lottery") || args[0].equals("nim"))
            {
                switch (args[0])
                {
                    case "lottery":
                        playLottery();

                        break;
                    case "nim":
                        try
                        {
                            if(Integer.parseInt(args[1])>0 &&
                                    Integer.parseInt(args[1])<=30)
                                playNim(Integer.parseInt(args[1]));
                            else
                                System.out.println("Wrong input");
                        }

                        catch (Exception eN){
                            System.out.printf("Incorrect number of chips");
                        }


                        break;
                    default:
                        System.out.println("Wrong input");
                        break;


                }
            }
            else
                System.out.println("Wrong input");
        }
        else
            System.out.println("Wrong input");
    }   
}


