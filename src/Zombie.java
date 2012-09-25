import java.util.Random;


public class Zombie extends Monster {
	private String Name;
	private int attack;
	private int health;
	private int goldDrop;
	private int expDrop;
	Random generator;
	
	public Zombie(){
		this.setName("Zombie");
		generator = new Random();
		this.generateStats();
	}
	
	private void generateStats(){
		int randNum = generator.nextInt(10) + 2;
		this.setHealth(randNum);
		randNum = generator.nextInt(3) + 1;
		this.setAttack(randNum);
		randNum = generator.nextInt(10) + 1;
		this.setGoldDrop(randNum);
		randNum = generator.nextInt(15) + 5;
		this.setExpDrop(randNum);
	}
	
	public void setName(String name){
		this.Name = name;
	}
	
	public String getName(){
		return this.Name;
	}
	
	public void setAttack(int attack){
		this.attack = attack;
	}
	
	public int getAttack(){
		return this.attack;
	}
	
	public void setHealth(int health){
		this.health = health;
	}
	
	public void setHealthOnAttack(int damage){
		this.health -= damage;
	}
	
	public int getHealth(){
		return this.health;
	}
	
	public void setGoldDrop(int gold){
		this.goldDrop = gold;
	}
	
	public int getGoldDrop(){
		return this.goldDrop;
	}
	
	public void setExpDrop(int exp){
		this.expDrop = exp;
	}
	
	public int getExpDrop(){
		return this.expDrop;
	}
	
	public void descriptionOnEncouter(){
		System.out.println("A " + this.toString() + "! appears!");
		System.out.println("Health: " + this.getHealth());
		System.out.println("Attack: " + this.getAttack());
	}
	
	public String toString(){
		return this.getName();
	}
	
	public void attackPlayer(Character player){
		player.setHealthOnAttack(this.getAttack());
	}
	
	public void dropLoot(Character player){
		System.out.println("The " + this.getName() + " dropped " + this.getGoldDrop() + " gold!");
		player.pickUpGold(this.getGoldDrop());
		System.out.println("You have also gained: " + this.getExpDrop() + "EXP!");
		player.setExpOnKill(this.getExpDrop());
	}
}
