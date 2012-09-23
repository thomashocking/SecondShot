import java.util.Scanner;


public class GameControl implements GAME_CONSTS{
	private Character player;
	Scanner input;
	Menu menu;
	Event event;
	
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
		this.mainLoop();
	}
	
	public void mainLoop(){
		menu = new MainMenu();
		menu.show();
		this.inputHandler(menu);
	}
	
	public void inputHandler(Menu menu){
		String userChoice;
		boolean safeChoice = false;
		
		if(menu.getMenuNum() == 0){
		System.out.println("No need for input...");
		}
		else if(menu.getMenuNum() == 1){
			while(!safeChoice){
				System.out.print("Command: ");
				userChoice = input.next();
				if(userChoice.compareTo("Shop") == 0 || userChoice.compareTo("shop") == 0){
				//Enter Shop
					safeChoice = true;
				}
				else if(userChoice.compareTo("Dungeon") == 0 || userChoice.compareTo("dungeon") == 0){
					safeChoice = true;
					event = new DungeonEvent();
					event.start(player);
					}
				else if(userChoice.compareTo("Stats") == 0 || userChoice.compareTo("stats") == 0){
					player.printStats();
					safeChoice = true;
				}
				else {
					System.out.println("Invalid Input");
				}
			}
		}
	}
	

}
