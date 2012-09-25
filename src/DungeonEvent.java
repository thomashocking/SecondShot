import java.util.Random;


public class DungeonEvent extends Event implements GAME_CONSTS{
	private int eventNum;
	Random generator;
	Event event;
	
	public DungeonEvent(){
		this.eventNum = this.DUNGEON_EVENT_NUM;
		generator = new Random();
	}
	public int getEventNum(){
		return eventNum;
	}
	
	public void start(Character player){
		int randomEvent = generator.nextInt(2) + 1;
		if(randomEvent == 1){
			event = new TreasureEvent();
			event.start(player);
		}
		else if(randomEvent == 2){
			event = new MonsterEvent();
			event.start(player);
		}
	}
	
}
