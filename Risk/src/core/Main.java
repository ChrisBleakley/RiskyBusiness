/*
 * Alan Halvey -
 * Alan Holmes -
 * Greg Sloggett - 14522247
 * 
 */

package core;

import java.awt.Color;
import java.io.IOException;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String args[]) throws IOException{
		Screen screen = new Screen();

		CommandInput.run();
		boolean flag = true;

		while(flag){
			//if the both users have put in their name
			if ((CommandInput.getPlayer2().length() >= 3) && (CommandInput.getPlayer2().length() <= 10)){
				Screen.mainFrame.repaint();
				Deck.shuffledDeck();
				flag = false;
			}	
		}

		while(Data.unitsLeft==true){
			if(flag==false){
				CommandInput.placeNeutrals();
				Screen.mainFrame.repaint();
				flag=true;
			}
			if(Data.PLAYER_1_ARMIES !=0 || Data.PLAYER_2_ARMIES !=0){
				CommandInput.placeUnits(CommandInput.currentPlayer);
				Screen.mainFrame.repaint();
			}
			else{
				CommandInput.appendStringTo("No units left to place", Color.RED);
				Data.unitsLeft=false;
			}
		}
	}

}