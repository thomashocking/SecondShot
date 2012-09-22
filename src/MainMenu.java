
public class MainMenu extends Menu implements GAME_CONSTS {
	
	private int menuNumber;
	
	public int getMenuNum(){
		return this.menuNumber;
	}
	
	public MainMenu(){
		this.menuNumber = this.MAIN_MENU_NUM;
	}
	
	public void show() {
		System.out.println("*******************************************************");
		System.out.println("What would you like to do?                            *");
		System.out.println("Type: " + "'Shop' " + "to enter inside the shop                 *");
		System.out.println("Type: " + "'Dungeon' " + "to enter inside the dungeon           *");
		System.out.println("Type: " + "'Stats' " + "to see your stats                       *");
		System.out.println("*******************************************************");
	}
	
	public String toString(){
		return "MainMenu";
	}



	
}
