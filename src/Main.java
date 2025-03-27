import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SingleGame sg = new SingleGame();
        sg.game();
    }
}

class SingleGame{
    int guess;
    int answer;
    Scanner sc;
    int guessTurns;
    SingleGame(){
        this.guessTurns = 0;
        this.guess = -1;
        this.answer = (int)(Math.random()*100) + 1;
        this.sc = new Scanner(System.in);
    }
    void game(){
        System.out.println("Hi, let's guess a number between 1 and 100!");
        while(this.answer != this.guess){

            try {
                TakeGuess();
            } catch (InputMismatchException e) {
                System.out.println("You entered an invalid number!");
                sc.nextLine();
            }
        }
        System.out.println("Congrats! You guessed the number within " +this.guessTurns+" turns!");
    }

    private void TakeGuess() throws InputMismatchException {

        this.guess = this.sc.nextInt();
        sc.nextLine();
        if(this.guess > this.answer){
            System.out.println("Smaller please! Try again!");
        } else if (this.guess < this.answer) {
            System.out.println("Greater please! Try again!");
        }
        guessTurns++;

    }
}