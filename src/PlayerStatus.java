import java.util.Scanner;

public class PlayerStatus {
	Scanner sc = new Scanner(System.in);
	// Starea interna

	private String nickname; // Nume jucator
	private int score; // Scor jucator
	private int lives; // Numar vieti
	private int health; // [0-100], Procent viata ramas
	private String weaponInHand; // Arma jucator
	private double positionX; // Coordonata Ox pozitie
	private double positionY; // Coordonata Oy pozitie
	private static String gameName; // Nume joc

	// Comportament

	// 1. a) Initializare nickname
	public void initPlayer(Scanner sc) {
		this.nickname = sc.next();
	}

	// 1. b) Initializare nickname + lives
	public void initPlayer(String nickname, int lives) {
		this.nickname = nickname;
		this.lives = lives;
	}

	// 1. c) Initializare nickname + lives + score
	public void initPlayer(String nickname, int lives, int score) {
		this.nickname = nickname;
		this.lives = lives;
		this.score = score;
	}

	public int getLives() {
		return lives;
	}

	public int getScore() {
		return score;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getHealth() {
		return health;
	}

	// Metoda care afla daca nr este perfect
	public boolean perfectNumber(int number) {
		int sumDivisors = 1;
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				sumDivisors += i;
			}
		}
		if (sumDivisors == number) {
			return true;
		}
		return false;
	}

	// Metoda care afla daca nr este prim
	public boolean primeNumber(int number) {
		boolean isPrime = true;
		for (int i = 2; i * i < number && isPrime; i++) {
			if (number % i == 0) {
				isPrime = false;
				return isPrime;
			}
		}
		return true;
	}

	// Metoda care afla daca nr este par
	public boolean isEven(int number) {
		if (number % 2 == 0) {
			return true;
		}
		return false;
	}

	// 2. Metoda actualizeaza starea jucatorului in functie de artifactul gasit
	public void findArtifact(int artifactCode) {
		System.out.println();
		System.out.println("Artifact code " + "'" + artifactCode + "':");
		// a)
		if (perfectNumber(artifactCode)) {
			System.out.println("WOW! You stepped on a perfect number! For that you will get: ");
			System.out.println("Score: +5000\nLives: +1\nHealth: 100");
			score += 5000;
			lives++;
			health = 100;
			System.out.println();
			System.out.println("Total score: " + getScore());
			System.out.println("Total lives: " + getLives());
			System.out.println("Total health: " + getHealth());
			// b)
		} else if (primeNumber(artifactCode)) {
			System.out.println("WOW! You stepped on a prime number! For that you will get: ");
			System.out.println("\nScore: +1000\nLives: +2\nHealth: +25");
			score += 1000;
			lives += 2;
			if (health <= 75) {
				health += 25;
				System.out.println();
				System.out.println("Total score: " + getScore());
				System.out.println("Total lives: " + getLives());
				System.out.println("Total health: " + getHealth());
			} else {
				int difference = 100 - health;
				health += difference;
				System.out.println();
				System.out.println("Total score: " + getScore());
				System.out.println("Total lives: " + getLives());
				System.out.println("Total health: " + getHealth());
			}
			// c)
		} else if (isEven(artifactCode) && artifactCode % 3 == 0) {
			// Daca numarul este divizibil cu 3 atunci si suma cifrelor sale este
			// Capcana
			System.out.println("Oops! You stepped on a trap! Unfortunately: ");
			System.out.println("Score: -3000\nHealth: -25");
			score -= 3000;
			health -= 25;
			if (health <= 0) {
				lives--;
				health = 100;
			}
			if (lives > 0) {
				System.out.println();
				System.out.println("Total score: " + getScore());
				System.out.println("Total lives: " + getLives());
				System.out.println("Total health: " + getHealth());
			} else {
				System.out.println("GAME OVER!");
			}
			// d)
		} else {
			// Alte numere care nu prezinta puteri magice
			System.out.println("Your score is: " + artifactCode);
			score += artifactCode;
		}
	}

	// 3. Metoda schimba arma folosita de jucator si afiseaza TRUE sau FALSE
	public boolean setWeaponInHand(String weaponInHand) {
		if (weaponInHand.equals("knife") || weaponInHand.equals("sniper") || weaponInHand.equals("kalashnikov")) {
			if (score >= Weapon.getKnifeCost() || score >= Weapon.getSniperCost()
					|| score >= Weapon.getKalashnikovCost()) {
				this.weaponInHand = weaponInHand;
			}
			if (this.weaponInHand.equals("knife")) {
				score -= Weapon.knifeCost;
			} else if (weaponInHand.equals("sniper")) {
				score -= Weapon.sniperCost;
			} else {
				score -= Weapon.kalashnikovCost;
			}
			return true;
		}
		return false;
	}

	// 4. Metoda returneaza arma curenta
	public String getWeaponInHand() {
		return weaponInHand;
	}

	// 5. Transforma positionX si positionY in proprietati ale obiectelor clasei
	// PlayerStatus
	// Proprietati = Field-uri care au setter si getter
	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}

	public double getPositionX() {
		return positionX;
	}

	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}

	public double getPositionY() {
		return positionY;
	}

	// 6. Implementeaza metode necesare pt ca gameName sa devina proprietate
	public static void setGameName(String newGameName) {
		newGameName = gameName;
	}

	public static String getGameName() {
		return gameName;
	}

	// 7. Metoda actualizeaza pozitia jucatorului
	public void movePlayerTo(double positionX, double positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}

	// 8. Transforma campul nickname intr-unul de tip read-only
	// Field-ul nickname a fost facut private de la inceputul clasei, in sectiunea
	// de stare
	public String getNickname() {
		return nickname;
	}

	// Distanta dintre jucatori
	public double playersDistance(PlayerStatus player, PlayerStatus opponent) {
		double playersDistance = Math.sqrt(Math.pow(player.positionX - opponent.positionX, 2.0) + Math.pow(player.positionY - opponent.positionY, 2.0));
		return playersDistance;
	}

	// 9. Metoda simuleaza bataie intre jucatorul curent si adversar
	public void shouldAttackOpponent(PlayerStatus player, PlayerStatus opponent) {
		System.out.println();
		System.out.println("Oh no! Somebody attacked you!");
		if (player.weaponInHand == opponent.weaponInHand) {
			int playerProbability = (3 * player.health + player.score / 1000) / 4;
			int opponentProbability = (3 * opponent.health + opponent.score / 1000) / 4;
			if (playerProbability > opponentProbability) {
				System.out.println("You won the fight!");
			} else if (playerProbability < opponentProbability) {
				System.out.println("You lost the fight.");
			} else
				System.out.println("Tie.");
		}

		if (player.weaponInHand != opponent.weaponInHand) {
			// sniper > kalashniov > knife
			if (playersDistance(player, opponent) > 1000) {
				if (player.weaponInHand.equals("sniper")) {
					System.out.println("You won the fight!");
				} else if (opponent.weaponInHand.equals("sniper")) {
					System.out.println("You lost the fight.");
				} else if (player.weaponInHand.equals("kalashnikov") && opponent.weaponInHand.equals("knife")) {
					System.out.println("You won the fight!");
				} else {
					System.out.println("You lost the fight.");
				}
			}
			// kalashnikov > sniper > knife
			if (playersDistance(player, opponent) <= 1000) {
				if (player.weaponInHand.equals("kalashnikov")) {
					System.out.println("You won the fight!");
				} else if (opponent.weaponInHand.equals("kalashnikov")) {
					System.out.println("You lost the fight!");
				} else if (player.weaponInHand.equals("sniper") && opponent.weaponInHand.equals("knife")) {
					System.out.println("You won the fight!");
				} else {
					System.out.println("You lost the fight.");
				}
			}
		}
	}
}
