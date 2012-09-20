
public class HealthPotion implements GAME_CONSTS{
	private int potionMax;
	
	public void setPotionMax(){
		potionMax = HEALTH_POTION_MAX;
	}
	public HealthPotion(){
		this.setPotionMax();
	}
	
	public void healHealth(Character player){
		if(player.getHealth() + potionMax > player.getHealth_Cap()){
			player.setHealth(player.getHealth_Cap());
			System.out.println("Healed to full!");
		}
		else{
			player.setHealth(potionMax+player.getHealth());
			System.out.println("Healed 15 HP!");
		}
	}
}
