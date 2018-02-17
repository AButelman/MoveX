package resources;

import game.MoveX;

public class Player {
	private int xPosition;
	private int yPosition;
	private char character;
	private Board board;
	
	public Player(char character){
		this.board = MoveX.board;
		this.character = character;
	}
	
	private void setOnBoard(){
		Board.matrix[yPosition][xPosition] = character;
	}
	
	private void clearActualSpace(){
		Board.matrix[yPosition][xPosition] = ' ';
	}
	
	
	public void setRandomPosition(){
		int newXPosition;
		int newYPosition;
		boolean newPositionFound = false;
		
		do {
			newXPosition = (int) (Math.random() * this.board.getWidth()); 
			newYPosition = (int) (Math.random() * this.board.getHeigth());
		
			if (MoveX.numOfPlayers == 1) {
				newPositionFound = true;
			} else {
			
				for (Player player : MoveX.players){
					
					if (player.equals(this)) {
						continue;
					} else {
						while ((player.getXPosition() == newXPosition)			
								&& (player.getYPosition() == newYPosition)){
					
							newXPosition = (int) (Math.random() * this.board.getWidth()); 
							newYPosition = (int) (Math.random() * this.board.getHeigth());
						}	
						newPositionFound = true;
					}	
				}
			}
		} while (!newPositionFound || ((newXPosition == xPosition) && (newYPosition == yPosition)));;
		
		setXPosition(newXPosition); 
		setYPosition(newYPosition);
		setOnBoard();
	}
	
	public void setXPosition(int xPosition){
		clearActualSpace();
		if (xPosition <= board.getWidth() && xPosition >= 0) {
			this.xPosition = xPosition;
		}
		setOnBoard();
	}
	
	public void setYPosition(int yPosition){
		clearActualSpace();
		if (yPosition <= board.getHeigth() && yPosition >= 0) {
			this.yPosition = yPosition;
		}
		setOnBoard();
	}
	
	public int getXPosition(){
		return xPosition;
	}
	
	public int getYPosition(){
		return yPosition;
	}
}
