import java.util.ArrayList;
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
	
	public boolean handleMainMenuInput(){
		String userChoice;
		boolean safeChoice = false;
		boolean endGame = false;
				while(!safeChoice){
				System.out.print("Command: ");
				userChoice = input.next();
				if(userChoice.compareTo("Shop") == 0 || userChoice.compareTo("shop") == 0){
					event = new Shop();
					event.start(player);
					safeChoice = true;
					return false;
				}
				else if(userChoice.compareTo("Dungeon") == 0 || userChoice.compareTo("dungeon") == 0){
					safeChoice = true;
					event = new DungeonEvent();
					event.start(player);
					return false;
					}
				else if(userChoice.compareTo("Stats") == 0 || userChoice.compareTo("stats") == 0){
					player.printStats();
					safeChoice = true;
					return false;
				}
				else {
					System.out.println("Invalid Input");
					return false;
				}
			}
			return endGame;
		}
	public void handleBattleMenuInput(){
		boolean safeChoice = false;
		String userChoice;
		
			while(!safeChoice){
				System.out.println("Command: ");
				userChoice = input.nextLine();
				if(userChoice.compareTo("Melee") == 0 || userChoice.compareTo("melee") == 0){
					Battle battle = new Battle();
					safeChoice = battle.meleeBattle(player, monster);
					}
				else if(userChoice.compareTo("Magic") == 0 || userChoice.compareTo("magic") == 0){
					Battle battle = new Battle();
					battle.magicBattleWarning();
					int magicPower = input.nextInt();
					safeChoice = battle.magicBattle(player, monster, magicPower);
				}
			}
		}
	
	public void handleShopMenuInput(){
		String userChoice;
		ArrayList<Integer> selectionInfo = new ArrayList<Integer>();
		boolean leaveShop = false;
		while(!leaveShop){
		System.out.println("Command: ");
		userChoice = input.nextLine();
		if(userChoice.compareTo("Health Potion") == 0|| userChoice.compareTo("health potion") == 0){
		Shopkeeper shopkeep = new Shopkeeper();
		shopkeep.sellHealthPotions(player,1);
		}
		else if(userChoice.compareTo("Leave") == 0 || userChoice.compareTo("leave") == 0){
			leaveShop = true;
		}
		}
	}

	public void takeMonster(Monster monster){
		this.monster = monster;
	}
}
