import java.util.Scanner;
public class Game {
    public static void main (String [] args){
        GameMap box = new GameMap(50,200);
        Display display = new Display(box);
        Ball ball = new Ball(box,47,100);
        Movement movement = new Movement(ball,box);
        Paddle paddle = new Paddle(box,25,48,90);
        Scanner input = new Scanner(System.in);
        char direction = input.next().charAt(0);
        if(direction=='a')
        movement.shootBall('d');
        else if(direction=='d')
            movement.shootBall('a');
        else movement.shootBall('a');
        while(movement.isBallMoving()){
            System.out.println("Ball is moving");
            direction = input.next().charAt(0);
            System.out.println("Paddle input pressed key : " + direction);
            paddle.movePaddle(direction);
            movement.doTheWork();
            display.clearScreen();
            display.printArray();
        }
        display.clearScreen();
        System.out.println("Game Over");
    }
}