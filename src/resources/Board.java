package resources;

import java.util.Arrays;

public class Board {
	public static final int MAX_WIDTH = 130;
	public static final int MAX_HEIGTH = 45;
	
	static char[][] matrix;
	
	private int width;
	private int heigth;
		
	public Board(){
		Validator validator = new Validator();
		width = validator.getWidth();
		heigth = validator.getHeigth();
		
		matrix = new char[heigth][width];
		createEmptyMatrix();
	}
	
	private void createEmptyMatrix(){
		for(int i = 0; i < matrix.length; i++){
			Arrays.fill(matrix[i], ' ');
		}
	}
	
	public void draw(){
		System.out.print("\033\143");
		
		for(int k = 0; k < (width + 2); k++){
			System.out.print("-");
		}
		System.out.println();
		
		for(char[] row : matrix){
			System.out.print("|");
			for(char column : row){
				System.out.print(column);
			}
			System.out.println("|");
		}
		
		
		for(int k = 0; k < (width + 2); k++){
			System.out.print("-");
		}
		System.out.println();
	}
	
	public char[][] getMatrix(){
		return matrix;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeigth(){
		return heigth;
	}
}
