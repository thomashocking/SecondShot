import java.util.Random;


public class TreasureEvent extends Event {
	private int randomGold;
	Random generator;
	HealthPotion healthPotion;
	ManaPotion manaPotion;
	
	public TreasureEvent(){
		generator = new Random();
	}
	
	public int getGold(){
		return randomGold;
	}
	
	
	@Override
	public void start(Character player) {
		System.out.println("Starting Treasure Event...");
		int randomizedEvent = generator.nextInt(100) + 1;
		
		if(randomizedEvent > 75){
			//Drop gold
			randomGold = generator.nextInt(10) + 1;
			System.out.println("You opened the chest and found " + this.getGold() + " Gold!");
			player.pickUpGold(this.getGold());
		}
		else{
			//Drop potion
			//randomize chance for health/mana pot
			
			int randPotion;
			randPotion = generator.nextInt(2) + 1;
			if(randPotion == 1){
				int randNumOfPotions = generator.nextInt(2) + 1;
				if(randNumOfPotions == 1){
					System.out.println("You found " + randNumOfPotions + " Health Potion!");
					player.setHealthPotions(1);
					System.out.println("You now have " + player.getHealthPotionSize() + " Health Potions");
				}
				else{
					System.out.println("You found " + randNumOfPotions + " Health Potions!");
					player.setHealthPotions(2);
					System.out.println("You now have " + player.getHealthPotionSize() + " Health Potions");
				}
			}
			else{
				int randNumOfPotions = generator.nextInt(2) + 1;
				if(randNumOfPotions == 1){
					System.out.println("You found " + randNumOfPotions + " Mana Potion!");
					player.setManaPotions(1);
					System.out.println("You now have " + player.getManaPotionSize() + " Mana Potions");
				}
				else{
					System.out.println("You found " + randNumOfPotions + " Mana Potions!");
					player.setManaPotions(2);
					System.out.println("You now have " + player.getManaPotionSize() + " Mana Potions");
				}
			}
		}
	}
}
