
public class MonsterBattleMenu extends Menu implements GAME_CONSTS{

	private int menuNum;
	
	
	public MonsterBattleMenu(){
		this.menuNum = this.MONSTER_BATTLE_MENU;
	}
	
	@Override
	public void show() {
		System.out.println("What would you like to do?");
		System.out.println("**********************************************************");
		System.out.println("Type: 'Melee' to use a melee type attack!                *");
		System.out.println("Type: 'Magic' to use a magic type attack!                *");
		System.out.println("Type: 'Stats' followed by 'monster' or 'me' to see stats *");
		System.out.println("Type: 'Run' to have a chance to run away from battle     *");
		System.out.println("**********************************************************");
		
	}

	@Override
	public int getMenuNum() {
		return this.menuNum;
	}
	
	public String toString(){
		return "Monster Battle Menu";
	}

}
