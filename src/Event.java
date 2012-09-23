
public abstract class Event implements GAME_CONSTS{
	private int eventNum;
	
	public Event(){
		eventNum = this.EVENT_NUM;
	}
	
	public int getEventNum(){
		return eventNum;
	}
	
	public abstract void start(Character player);

}
