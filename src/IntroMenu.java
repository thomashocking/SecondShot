
public class IntroMenu extends Menu implements GAME_CONSTS{
	
	private int menuNumber;
	
	public void show() {
		System.out.println("___________________________");
		System.out.println("Welcome to DnD v2");
		System.out.println("Now generating your character....");
		System.out.println("___________________________");
	}
	
	public IntroMenu(){
		this.menuNumber = this.INTRO_MENU_NUM;
	}
	public String toString(){
		return "IntroMenu";
	}

	public int getMenuNum() {
		return this.menuNumber;
	}
	
}
