import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

class Main {

  public static int getCard(){   
    int c = ThreadLocalRandom.current().nextInt(1,14); // generates a random number from 1 to 13 inclusively.
    if (c>10) { c = 10; }; // convert face card numbers to 10
    System.out.println("Card adds " + c + " to your total");
    return c;
  }

  public static void main(String[] args) {    
    int total = 0;
    int count = 0;
    int num;
    boolean keepPlaying = true;

    Scanner scan = new Scanner(System.in);

    do { 
      System.out.println("Total is " + total);
      if (count<2){ // always get dealt two cards
        total += getCard();
        count++;
      }
      else
      { // once you have two or more cards it is your choice to get more
        System.out.print("Enter 1 to draw another card, any other number to stop.");
        num = scan.nextInt();
        if (num==1){
          total += getCard();
          count++;
        }
        else
        {
          keepPlaying = false;
        }
      } 
    } while (keepPlaying && (total<=21));

    System.out.println("Your total is " + total);
    if (total>21){
      System.out.println("Your went bust");
    }
  }
}