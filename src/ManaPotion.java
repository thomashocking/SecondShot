
public class ManaPotion implements GAME_CONSTS{
private int potionMax;
	
	public void setPotionMax(){
		potionMax = MANA_POTION_MAX;
	}
	public ManaPotion(){
		this.setPotionMax();
	}
	
	public void restoreMana(Character player){
		if(player.getMana() + potionMax > player.getMana_Cap()){
			player.setMana(player.getMana_Cap());
			System.out.println("Mana set to full!");
		}
		else{
			player.setMana(potionMax+player.getMana());
			System.out.println("Restored 10 MP!");
		}
	}
}
