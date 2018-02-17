package resources;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {
	private Scanner userInput;
	
	public Validator(){
		userInput = new Scanner(System.in);
	}
	
	public int getWidth(){
		int width = 0;
		
		do {
			System.out.print("Please enter the board width (1 - " + 
					Board.MAX_WIDTH + "): ");
			try {
				width = userInput.nextInt();
			} catch (InputMismatchException e) {
				userInput.next();
			}
		} while (width < 1 || width > Board.MAX_WIDTH);
		
		return width;
	}
	
	public int getHeigth(){
		int heigth = 0;
		
		do {
			System.out.print("Please enter the board heigth (1 - " + 
					Board.MAX_HEIGTH + "): ");
			try {
				heigth = userInput.nextInt();
			} catch (InputMismatchException e) {
				userInput.next();
			}	
		} while (heigth < 1 || heigth > Board.MAX_HEIGTH);
		
		return heigth;
	}
}
