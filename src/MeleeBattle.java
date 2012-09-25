
public class MeleeBattle {
	
	public void meleeBattle(Character player,Monster monster){
			System.out.println("You strike for " + player.getAttack() + " damage!");
			monster.setHealthOnAttack(player.getAttack());
			if(monster.getHealth() > 0){
			System.out.println(monster.getHealth());
			System.out.println("You are hit for " + monster.getAttack() + " damage!");
			player.setHealthOnAttack(monster.getAttack());
			}
			else{
				System.out.println("You have killed the " + monster.getName() + "!");
				monster.dropLoot(player);
			}

	}
}
