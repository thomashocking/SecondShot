
public abstract class Monster {
	private String Name;
	private int attack;
	private int health;
	private int goldDrop;
	private int expDrop;
	
	public Monster(){
		this.setName("Default Monster");
		this.setAttack(0);
		this.setHealth(0);
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
		System.out.println(this.toString());
	}
	
	public String toString(){
		return this.getName();
	}
	
	public void attackPlayer(Character player){
		player.setHealthOnAttack(this.getAttack());
	}
	
	public abstract void specialAttack(int monsterAttack);
}
