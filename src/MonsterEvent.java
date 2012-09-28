import java.util.Random;


public class MonsterEvent extends Event {
	Monster monster;
	Menu menu;
	InputHandler userInput;
	Random generator;
	
	public MonsterEvent(){
		monster = new Zombie();
	}
	
	
	@Override
	public void start(Character player) {
		System.out.println("A monster has found you!");
		monster.descriptionOnEncouter();
		menu = new MonsterBattleMenu();
		menu.show();
		userInput = new InputHandler(player);
		userInput.takeMonster(monster);
		userInput.handleBattleMenuInput();
	}
	
}
