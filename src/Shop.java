
public class Shop extends Event {
	Shopkeeper shopkeeper;
	Menu menu;
	InputHandler input;
	
	public Shop(){

	}
	
	@Override
	public void start(Character player) {
		menu = new ShopMenu();
		menu.show();
		input = new InputHandler(player);
		input.handleShopMenuInput();
	}

}
