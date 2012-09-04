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
	private ArrayList<HealthPotion> potions;
	
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
	
	public int getHealth(){
		return this.health;
	}
	
	public void setMana(int mana){
		this.mana = mana;
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
	
	public void setHealthPotions(int numOfPotions){
		//will add onto previous amount of potions.
		for(int i = 0; i < numOfPotions; i++){
			potions.add(new HealthPotion());
		}
	}
	
	public static void main(String[] args){
		Character theCharacter = new Character(DEFAULT_SEED);
		theCharacter.printStats();
	}
	
	//set a seed if your doing error checking on a specific problem.
	//will be used when game control class is implemented.
	public Character(long SEED){
		/****INITS
		 * 
		 * 
		 */
		this.setStats(this.statGeneration(SEED));
		potions = new ArrayList<HealthPotion>();
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
		System.out.println("Your health is:" + this.getHealth());
		System.out.println("Your mana is:" + this.getMana());
		System.out.println("Your attack:" + this.getAttack());System.out.println(potions.size());
		System.out.println("Your exp is:" + this.getExp());
		System.out.println("Your level is:" + this.getLevel());
		System.out.println("Your gold is:" + this.getGold());
	}
	
	
	public void drinkHealthPotion(){
		int healthPot = 0;
		if(potions.size() == 0){
			System.out.println("Out of potions!");
		}
		else{
		healthPot = potions.size();
		healthPot-=1;
		potions.get(healthPot).healHealth(this);
		potions.remove(healthPot);
		System.out.println(potions.size() + " Health Potions left!");
		}
	}
}
