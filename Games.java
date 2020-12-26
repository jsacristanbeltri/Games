//Jorge Sacristan Beltri
//Exercise for Units 1 to 4
//Games Aplication. 

import java.util.Scanner;

public class Games
{
    public static int generateNumber(int min, int max)
    {
        int numberRandom= min+(int)(Math.random() * max);
    
        return numberRandom;
    }
    
    public static boolean checkRepeatNumber(int numberToCheck, int[] numbers)
    {
        boolean exist=false;
        
        for(int i=0;i<numbers.length;i++)
        {
            if(numbers[i]==numberToCheck)
            {
               exist=true;
            }
        }
        
        return exist;
    }

    public static int[] generateLottery()
    {
        int [] numbersLottery = new int [6];
        int temp=0,cont=0,i=0;

        while(i<6)
        {
            temp=generateNumber(1,5);
            if(checkRepeatNumber(temp, numbersLottery)==false)
            {
                numbersLottery[i] = temp;            
                i++;
            }
        }

        return numbersLottery;
    }
    
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


    public static void main(String[] args)
    {
        int [] numbersLottery = new int [6];
        int [] numbersUser = new int [6];
        int winners=0;
        numbersLottery = generateLottery();
        //numbersUser=generateLottery();
        System.out.println("Numeros ganadores");
        for(int i=0;i<numbersLottery.length;i++)
        {
            System.out.print(""+numbersLottery[i]+ " ");
        }
        
        /*System.out.println("Numeros usuario");
        for(int j=0;j<numbersUser.length;j++)
        {
            System.out.print(""+numbersUser[j]+ " ");
        }
        
        winners=checkLottery(numbersLottery,numbersUser);
        System.out.printf("The number of winner numbers is: %d", winners);*/
        
    }   
}


