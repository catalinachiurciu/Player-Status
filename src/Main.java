import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PlayerStatus player = new PlayerStatus();
		PlayerStatus opponent = new PlayerStatus();

		Weapon.setKalashnikovCost(20_000);
		Weapon.setKnifeCost(1_000);
		Weapon.setSniperCost(10_000);
		PlayerStatus.setGameName("War Hunt");
		
		// PLAYER
		System.out.println("\t => Welcome to War Hunt! <= \n");
		System.out.println("Now let's choose your nickname!");
		player.initPlayer(sc);
		player.initPlayer(player.getNickname(), 1);
		player.initPlayer(player.getNickname(), 1, 50000);
		player.setHealth(100);
		player.setPositionX(0);
		player.setPositionY(0);
		player.setWeaponInHand("knife");

		// OPPONENT
		opponent.initPlayer(player.getNickname(), 3, 50000);
		opponent.setHealth(97);
		opponent.setPositionX(5);
		opponent.setPositionY(7);
		opponent.setWeaponInHand("sniper");

		System.out.println("Your nickname is: " + player.getNickname());
		System.out.println("Lives: " + player.getLives());
		System.out.println("Score: " + player.getScore());
		System.out.println("Health: " + player.getHealth());
		System.out.println("Initial position: " + "(" + player.getPositionX() + "; " + player.getPositionY() + ")");
		System.out.println("Weapon in hand: " + player.getWeaponInHand());
		System.out.println();
		player.findArtifact(6);
		player.setWeaponInHand("kalashnikov");
		System.out.println();
		System.out.println("Player`s weapon in hand now is: " + player.getWeaponInHand());
		System.out.println("Opponent`s weapon in hand now is: " + player.getWeaponInHand());
		player.movePlayerTo(5.2, 8.9);
		opponent.movePlayerTo(3400, 250.2);
		System.out.println("Players distance is: " + player.playersDistance(player, opponent));
		System.out.println();
		player.shouldAttackOpponent(player, opponent);
		player.findArtifact(5);
		opponent.setWeaponInHand("kalashnikov");
		player.setWeaponInHand("kalashnikov");
		player.movePlayerTo(15.5, 83.9);
		opponent.movePlayerTo(34.7, 23.2);
		player.shouldAttackOpponent(player, opponent);
		sc.close();

	}
}
