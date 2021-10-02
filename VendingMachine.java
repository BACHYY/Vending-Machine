public class VendingMachine 
{
    private int numberOfQuarters;
    private int numberOfDimes;
    private int numberOfNickels;
    private int insertedNumberOfCents;

    public VendingMachine()
    {
        numberOfQuarters=20;
        numberOfDimes=35;
        numberOfNickels=10;
    }
    public VendingMachine(int pQuarters, int pDimes, int pNickels)
    {
        numberOfQuarters= pQuarters;
        numberOfDimes= pDimes;
        numberOfNickels= pNickels;
    }
    public void insertQuarter()
    {
        numberOfQuarters++;
        insertedNumberOfCents+= 25;
    }
    public void insertDime()
    {
        numberOfDimes++;
        insertedNumberOfCents+= 10;;
    }
    public void insertNickel()
    {
        numberOfNickels++;
        insertedNumberOfCents+= 5;
    }
    public int getTotalNumberOfCents()
    {
        int sum;
        sum= (numberOfQuarters*25)+(numberOfDimes*10)+(numberOfNickels*5);
        return sum;
    }
    public boolean canDispense(int numberOfcents)
    {
        if (getTotalNumberOfCents()>numberOfcents)
        {
            if(numberOfQuarters>=(numberOfcents/25))
            {
                numberOfcents=numberOfcents%25;
                if(numberOfDimes>=(numberOfcents/10))
                {
                    numberOfcents=numberOfcents%10;
                    if(numberOfNickels>=(numberOfcents/5))
                    {
                        numberOfcents=numberOfcents%5;
                        return true;
                    }
                    else     
                    {
                        return false;
                    }
                }
                else if (numberOfNickels>=(numberOfcents/5))    
                {
                    numberOfcents=numberOfcents%5;
                    return true;
                    
                }
                else    
                {
                    return false;
                }
                
            }
            else if(numberOfDimes>=(numberOfcents/10))
            {
                numberOfcents=numberOfcents%10;
                if(numberOfNickels>=(numberOfcents/5))
                {
                    numberOfcents=numberOfcents%5;
                    return true;
                }
                else     
                {
                    return false;
                } 
            }
            else if(numberOfNickels>=(numberOfcents/5))
            {
                numberOfcents=numberOfcents%5;
                return true;
            }
            else 
            {
                return false;
            }
        }
        else
        {
            return false;

        }

        
    }
    
    
    public void dispenseChange(int numberOfCents2)
    {
        int quarters=0;
        int dimes=0;
        int nickels=0;
        if (canDispense(numberOfCents2))
        {
            if (numberOfCents2>=40)
            {
                int divisor= numberOfCents2/40;
                numberOfCents2=numberOfCents2%40;
                quarters += divisor;
                dimes += divisor;
                nickels += divisor;
                if (numberOfCents2>=25)
                {
                    divisor= numberOfCents2/25;
                    numberOfCents2=numberOfCents2%25;
                    quarters+= divisor;
                    if(numberOfCents2>=10)
                    {
                        divisor=numberOfCents2/10;
                        numberOfCents2=numberOfCents2%10;
                        dimes+= divisor;
                        if(numberOfCents2>=5)
                        {
                            divisor=numberOfCents2/5;
                            numberOfCents2=numberOfCents2%5;
                            nickels+= divisor;
                        }

                    }
                    else 
                    {
                        divisor=numberOfCents2/5;
                        numberOfCents2=numberOfCents2%5;
                        nickels+= divisor;
                    }
                }
                else if (numberOfCents2>=10)
                {
                    divisor=numberOfCents2/10;
                    numberOfCents2=numberOfCents2%10;
                    dimes+= divisor;
                    if(numberOfCents2>=5)
                    {
                        divisor=numberOfCents2/5;
                        numberOfCents2=numberOfCents2%5;
                        nickels+= divisor; 
                    }
                }
                else 
                {
                    divisor=numberOfCents2/5;
                    numberOfCents2=numberOfCents2%5;
                    nickels+= divisor; 
                }
            }
            else if (numberOfCents2>=25)
            {
                if(numberOfQuarters>=(numberOfCents2/25))
                {    int divisor= numberOfCents2/25;
                    numberOfCents2=numberOfCents2%25;
                    quarters+= divisor;
                    if(numberOfCents2>=10)
                    {
                        divisor=numberOfCents2/10;
                        numberOfCents2=numberOfCents2%10;
                        dimes+= divisor;
                        if(numberOfCents2>=5)
                        {
                            divisor=numberOfCents2/5;
                            numberOfCents2=numberOfCents2%5;
                            nickels+= divisor;
                        }
                    }
                    else 
                    {
                        divisor=numberOfCents2/5;
                        numberOfCents2=numberOfCents2%5;
                        nickels+= divisor; 
                    }
                }
                else if (numberOfDimes>=(numberOfCents2/10))
                {
                    int divisor=numberOfCents2/10;
                    numberOfCents2=numberOfCents2%10;
                    dimes+= divisor;
                    if(numberOfCents2>=5)
                     {
                        divisor=numberOfCents2/5;
                        numberOfCents2=numberOfCents2%5;
                        nickels+= divisor; 
                    } 
                }
                else    
                {
                    int divisor=numberOfCents2/5;
                    numberOfCents2=numberOfCents2%5;
                    nickels+= divisor; 
                }
            }
            else if (numberOfCents2>=10)
            {
                if (numberOfDimes>=(numberOfCents2/10))
                {   int divisor=numberOfCents2/10;
                    numberOfCents2=numberOfCents2%10;
                    dimes+= divisor;
                    if(numberOfCents2>=5)
                     {
                        divisor=numberOfCents2/5;
                        numberOfCents2=numberOfCents2%5;
                        nickels+= divisor; 
                    }
                }
                else 
                {
                    int divisor=numberOfCents2/5;
                    numberOfCents2=numberOfCents2%5;
                    nickels+= divisor;  
                }
            }
            else
            {
                int divisor=numberOfCents2/5;
                numberOfCents2=numberOfCents2%5;
                nickels+= divisor; 
            }
            numberOfQuarters=numberOfQuarters-quarters;
            numberOfDimes=numberOfDimes-dimes;
            numberOfNickels=numberOfNickels-nickels;
            System.out.println(quarters+" "+"quarters"+","+dimes+" "+"dimes"+","+nickels+" "+"nickels");

        

        }
        else
        {
            System.out.println("Out of order");

        }

    }
    public void selectItem(int itemNumber)
    {
        if(itemNumber == 1){
            if(insertedNumberOfCents >=45){
                insertedNumberOfCents -=45;
                if (canDispense(insertedNumberOfCents))
                {
                    System.out.println("Snickers Bar");
                }
                dispenseChange(insertedNumberOfCents);
            }
            else{
                System.out.println("Insufficient amount");
            }
        }
        else if(itemNumber == 2){
            if(insertedNumberOfCents >=60){
                insertedNumberOfCents -=60;
                if (canDispense(insertedNumberOfCents))
                {
                    System.out.println("M&M candy");
                }
                dispenseChange(insertedNumberOfCents);
            }
            else{
                System.out.println("Insufficient amount");
            }
        }
        else if(itemNumber == 3){
            if(insertedNumberOfCents >=15){
                insertedNumberOfCents -=15;
                if(canDispense(insertedNumberOfCents))
                {
                    System.out.println("York peppermint");
                }
                dispenseChange(insertedNumberOfCents);
            }
            else{
                System.out.println("Insufficient amount");
            }
        }
        else if(itemNumber == 4){
            if(insertedNumberOfCents >=80){
                insertedNumberOfCents -=80;
                if (canDispense(insertedNumberOfCents))
                {
                    System.out.println("BBQ chips");
                }
                dispenseChange(insertedNumberOfCents);
                
            }
            else{
                System.out.println("Insufficient amount");
            }
        }
        else{
            System.out.println(" This aint an input buddy");
        }

        
        

        

    }




}
    

