
public class Weapon {
	String knife;
	String sniper;
	String kalashnikov;
	static int knifeCost;
	static int sniperCost;
	static int kalashnikovCost;

	public static void setKnifeCost(int newKnifeCost) {
		knifeCost = newKnifeCost;
	}

	public static int getKnifeCost() {
		return knifeCost;
	}

	public static void setSniperCost(int newSniperCost) {
		sniperCost = newSniperCost;
	}

	public static int getSniperCost() {
		return sniperCost;
	}

	public static void setKalashnikovCost(int newKalashnikovCost) {
		kalashnikovCost = newKalashnikovCost;
	}

	public static int getKalashnikovCost() {
		return kalashnikovCost;
	}
}
