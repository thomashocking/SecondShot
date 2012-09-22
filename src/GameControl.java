import java.util.Scanner;


public class GameControl implements GAME_CONSTS{
	private Character player;
	Scanner input;
	Menu menu;
	
	public GameControl(long seed){
		player = new Character(seed);
		input = new Scanner(System.in);
	}
	
	public GameControl(){
		this(DEFAULT_SEED);
	}
	
	public void start(){
		menu = new IntroMenu();
		menu.show();
		player.printStats();
		this.inputHandler(menu);
		this.mainLoop();
	}
	
	public void mainLoop(){
		menu = new MainMenu();
		menu.show();
		this.inputHandler(menu);
	}
	
	public void inputHandler(Menu menu){
		if(menu.getMenuNum() == 0){
		System.out.println("No need for input...");
		}
		else if(menu.getMenuNum() == 1){
			
		}
	}
}
