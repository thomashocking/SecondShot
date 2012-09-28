
public class Battle {
	
	public boolean meleeBattle(Character player,Monster monster){
			System.out.println("You strike for " + player.getAttack() + " damage!");
			monster.setHealthOnAttack(player.getAttack());
			
			if(monster.getHealth() > 0){
			System.out.println(monster.getHealth());
			System.out.println("You are hit for " + monster.getAttack() + " damage!");
			player.setHealthOnAttack(monster.getAttack());
			return (false);
			}
			else{
				System.out.println("You have killed the " + monster.getName() + "!");
				monster.dropLoot(player);
				return (true);
			}
	}
	
	public void magicBattleWarning(){
		System.out.println("You are about to cast a magic spell.");
		System.out.println("How much power do you want to use?: ");
	}
	
	public void magicBattleNotEnoughMana(){
		System.out.println("You cannot use that much mana.");
	}
	
	public boolean magicBattle(Character player,Monster monster,int magicPower){
		if(magicPower > player.getMana()){
			this.magicBattleNotEnoughMana();
			return false;
		}
		
		else{
			System.out.println("You cast for " + magicPower + " damage!");
			monster.setHealthOnAttack(magicPower);
			player.setManaOnUse(magicPower);
			System.out.println("You now have " + player.getMana() + " mana!");
			
			if(monster.getHealth() > 0){
				System.out.println(monster.getHealth());
				System.out.println("You are hit for " + monster.getAttack() + " damage!");
				player.setHealthOnAttack(monster.getAttack());
				return (false);
			}
			else{
			System.out.println("You have killed the " + monster.getName() + "!");
			monster.dropLoot(player);
			return (true);
		}
	}
}
}
