
public abstract class Monster {
	private String Name;
	private int attack;
	private int health;
	private int goldDrop;
	private int expDrop;
	
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
	
	public void printStats(){
		System.out.println("A " + this.getName() + " appears!");
		System.out.println("Health: " + this.getHealth());
		System.out.println("Attack: " + this.getAttack());
	}
	
	public void attackPlayer(Character player){
		
	}
	public abstract void specialAttack(int monsterAttack);
}
