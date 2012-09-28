
public class ShopMenu extends Menu implements GAME_CONSTS{

	private int menuNumber;
	
	public ShopMenu(){
		this.menuNumber = SHOP_MENU;
	}
	
	@Override
	public void show() {
		System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		System.out.println("|              Welcome to the Shop!                              |");
		System.out.println("|              The Shop sells Potions...                         |");
		System.out.println("|              To buy a Potion. Type: 'Potion'                   |");
		System.out.println("|              To see your Gold. Type: 'Gold'                    |");
		System.out.println("|              To exit Type: 'Leave'                             |");
		System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
	}

	@Override
	public int getMenuNum() {
		return menuNumber;
	}

}
