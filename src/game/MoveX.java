package game;

import resources.*;

public class MoveX {
	
	public static Board board;
	
	public static Player[] players;
	
	public static int numOfPlayers = 0;
	private static int maxPlayers;
	
	private char[] playerNames;
	
	private void addPlayer(char character){
		if (numOfPlayers == maxPlayers) return;
		players[numOfPlayers] = new Player(character);
		numOfPlayers++;
	}
	
	public void addRandomNumOfPlayers(){
		int playersToAdd = (int) (Math.random() * maxPlayers);
		if (playersToAdd == 0) playersToAdd = 1;
		
		players = new Player[playersToAdd];
		
		System.out.print("Adding " + playersToAdd + " player");
		if (playersToAdd != 1) System.out.print("s");
		System.out.println("...");
		
		try {
			Thread.sleep(1000);
			
		} catch (Exception e) {}
		
		playerNames = new char[playersToAdd];
		
		for (int i = 0; i < playersToAdd; i++){
			boolean nameNotFound = true;
			
			while (nameNotFound){
				playerNames[i] = (char) (Math.random() * 26 + 65);
			
				if (i == 0) nameNotFound = false;
				
				for (int j = 0; j < i; j++){
					if (playerNames[j] == playerNames[i]){
						nameNotFound = true;
					} else {
						nameNotFound = false;
					}
				}
			}
		}
		
		for (char playerName : playerNames){
			addPlayer(playerName);
		}
	}
	
	public static void main(String[] args) {
		MoveX game = new MoveX();
		board = new Board();
		
		maxPlayers = (int) (board.getHeigth() * board.getWidth()) / 10;
		if (maxPlayers == 0) maxPlayers = 1;
		if (maxPlayers > 26) maxPlayers = 26;
		System.out.println("Max. amount of players: " + maxPlayers);
		
		game.addRandomNumOfPlayers();
		
		boolean keepPlaying = true;
		
		while (keepPlaying){
			for (int i = 0; i < players.length; i++){
				if (players[i] != null)	players[i].setRandomPosition();
			}
			
			try {
				Thread.sleep(500);
			} catch (Exception e) {}
			
			board.draw();
		}
	}
}
