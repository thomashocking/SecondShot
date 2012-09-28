import java.util.ArrayList;
import java.util.Random;


public class Character implements GAME_CONSTS{
	private int HEALTH_CAP;
	private int MANA_CAP;
	private int health;
	private int mana;
	private int attack;
	private int exp;
	private int level;
	private int gold;
	private ArrayList<HealthPotion> healthPotions;
	private ArrayList<ManaPotion> manaPotions;
	
	/***Setters and Getters
	*
	*
	*
	*/
	
	public void setHealth_Cap(int healthCap){
		this.HEALTH_CAP = healthCap;
	}
	
	public int getHealth_Cap(){
		return this.HEALTH_CAP;
	}
	
	public void setMana_Cap(int manaCap){
		this.MANA_CAP = manaCap;
	}
	
	public int getMana_Cap(){
		return this.MANA_CAP;
	}
	
	public void setHealth(int health){
		this.health = health;
	}
	
	public void setHealthOnAttack(int damage){
		this.health -= damage;
		if(this.getHealth() <= 0){
			System.out.println("The Player has died!");
		}
	}
	
	public int getHealth(){
		return this.health;
	}
	
	public void setMana(int mana){
		this.mana = mana;
	}
	
	public void setManaOnUse(int manaUsed){
		this.mana -= manaUsed;
	}
	
	public int getMana(){
		return this.mana;
	}
	
	public void setAttack(int attack){
		this.attack = attack;
	}
	
	public int getAttack(){
		return this.attack;
	}
	
	public void setExp(int exp){
		this.exp = exp;
	}
	
	public void setExpOnKill(int newExp){
		this.exp += newExp;
	}
	
	public int getExp(){
		return this.exp;
	}
	
	public void setLevel(int level){
		this.level = level;
	}
	
	public int getLevel(){
		return this.level;
	}
	
	public void setGold(int gold){
		this.gold = gold;
	}
	
	public int getGold(){
		return this.gold;
	}
	
	public void setGoldOnPotionPurchase(int amount, int type){
		if(type == 1){
			int healthPotionCost = 10;
			int playerGold = this.getGold();
			if(healthPotionCost * amount > this.getGold()){
				System.out.println("You dont have enough!");
			}
			else{
			this.setGold(playerGold -= healthPotionCost * amount);
			}
		}
		else if(type == 2){
			int manaPotionCost = 15;
			int playerGold = this.getGold();
			if(manaPotionCost * amount > this.getGold()){
				System.out.println("You dont have enough!");
			}
			else{
			this.setGold(playerGold -= manaPotionCost * amount);
			}
		}
	}
	
	public static void main(String[]args){
		Character player = new Character(1);
		player.setManaPotions(1);
		System.out.println(player.getManaPotionSize());
	}
	
	public void setHealthPotions(int numOfPotions){
		//will add onto previous amount of potions.
		for(int i = 0; i < numOfPotions; i++){
			healthPotions.add(new HealthPotion());
		}
	}
	
	public void setManaPotions(int numOfPotions){
		//will add onto previous amount of potions.
		for(int i = 0; i < numOfPotions; i++){
			manaPotions.add(new ManaPotion());
		}
	}
	
	public int getHealthPotionSize(){
		return healthPotions.size();
	}
	
	public int getManaPotionSize(){
		return manaPotions.size();
	}
	
	//set a seed if your doing error checking on a set of values.
	//will be used when game control class is implemented.
	public Character(long SEED){
		/****INITS
		 * 
		 * 
		 */
		this.setStats(this.statGeneration(SEED));
		healthPotions = new ArrayList<HealthPotion>();
		manaPotions = new ArrayList<ManaPotion>();
	}
	
	private ArrayList statGeneration(long SEED){
		Random generator = new Random();
		//generator.setSeed(SEED);
		int randHealth, randMana, randAttack = 0;
		randHealth = generator.nextInt(10) + 5;
		while(randHealth > 10){
			randHealth = generator.nextInt(10) + 5;
		}
		randMana = generator.nextInt(8) + 1;
		randAttack = generator.nextInt(6) + 2;
		ArrayList<Integer> randNumArrayList = new ArrayList<Integer>();
		randNumArrayList.add(randHealth);
		randNumArrayList.add(randMana);
		randNumArrayList.add(randAttack);
		return randNumArrayList;	
	}
	
	private void setStats(ArrayList<Integer> stats){
		this.health = stats.get(0);
		this.mana = stats.get(1);
		this.attack = stats.get(2);
		this.HEALTH_CAP = this.health;
		this.MANA_CAP = this.mana;
		this.exp = 0;
		this.gold = 0;
		this.level = 1;
	}
	
	public void printStats(){
		System.out.println("Your health is: " + this.getHealth());
		System.out.println("Your mana is: " + this.getMana());
		System.out.println("Your attack: " + this.getAttack());
		System.out.println("Your exp is: " + this.getExp());
		System.out.println("Your level is: " + this.getLevel());
		System.out.println("Your gold is: " + this.getGold());
		System.out.println(this.getHealthPotionSize() + " Health Potions");
	}
	
	
	public void drinkHealthPotion(){
		int healthPot = 0;
		if(healthPotions.size() == 0){
			System.out.println("Out of potions!");
		}
		else{
		healthPot = healthPotions.size();
		healthPot-=1;
		healthPotions.get(healthPot).healHealth(this);
		healthPotions.remove(healthPot);
		System.out.println(healthPotions.size() + " Health Potions left!");
		}
	}
	
	public void pickUpGold(int newGold){
		this.setGold(this.getGold() + newGold);
	}
	
	//could be possible abstracted out code for future refactoring.
	
	//possible solution would be base class Potion, and then 2 different child classes.
	public void drinkManaPotion(){
		int manaPot = 0;
		if(manaPotions.size() == 0){
			System.out.println("Out of potions!");
		}
		else{
		manaPot = healthPotions.size();
		manaPot-=1;
		manaPotions.get(manaPot).restoreMana(this);
		manaPotions.remove(manaPot);
		System.out.println(manaPotions.size() + " Mana Potions left!");
		}
	}
	
	public void buyHealthPotions(){
		
	}
}
