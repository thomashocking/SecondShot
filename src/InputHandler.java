import java.util.Scanner;


public class InputHandler {
	Scanner input;
	Event event;
	Character player;
	Monster monster;
	
	public InputHandler(Character player){
		this.player = player;
		input = new Scanner(System.in);
	}
	
	public void handleInput(Menu menu){
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
		else if(menu.getMenuNum() == 2){
			while(!safeChoice){
				System.out.println("Command: ");
				userChoice = input.nextLine();
				if(userChoice.compareTo("Melee") == 0 || userChoice.compareTo("melee") == 0){
					MeleeBattle battle = new MeleeBattle();
					battle.meleeBattle(player, monster);
					}
				}
			}
		}
	
	public void takeMonster(Monster monster){
		this.monster = monster;
	}
}
