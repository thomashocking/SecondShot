import java.util.ArrayList;
import java.util.Scanner;


public class Shopkeeper {
	Scanner input;
	
	
	public Shopkeeper(){
		input = new Scanner(System.in);
	}
	
	public void sellHealthPotions(Character player, int type){
		int healthPotionCost = 10;
		System.out.println("How many would you like?");
		int potionAmount = input.nextInt();
		
		if(healthPotionCost * potionAmount > player.getGold()){
			System.out.println("You dont have enough!");
		}
		else{
			player.setGoldOnPotionPurchase(potionAmount, type);
			player.setHealthPotions(potionAmount);
		}
	}
}
