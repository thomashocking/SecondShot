import java.util.Scanner;


public class GameControl implements GAME_CONSTS{
	private Character player;
	Menu menu;
	Event event;
	InputHandler userInput;
	
	public GameControl(long seed){
		player = new Character(seed);
		userInput = new InputHandler(player);
	}
	
	public GameControl(){
		this(DEFAULT_SEED);
	}
	
	public void start(){
		menu = new IntroMenu();
		menu.show();
		player.printStats();
		this.mainLoop();
	}
	
	public void mainLoop(){
		menu = new MainMenu();
		menu.show();
		userInput.handleInput(menu);
	}
}
