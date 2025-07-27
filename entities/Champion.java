package entities;

public class Champion {
	private String name;
	private int life;
	private int atack;
	private int armor;

	public Champion() {

	}

	public Champion(String name, int life, int atack, int armor) {
		this.name = name;
		this.life = life;
		this.atack = atack;
		this.armor = armor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public void setAtack(int atack) {
		this.atack = atack;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getLife() {
		return life;
	}

	public int getAtack() {
		return atack;
	}

	public int getArmor() {
		return armor;
	}

	public void takeDamage(Champion other) {
		int damage = other.atack - this.armor;
		if (damage < 1) {
			damage = 1;
		}
		this.life -= damage;
		if (this.life < 0) {
			this.life = 0;
		}
	}

	public String status() {
		if (life == 0) {
			return name + ": 0 de vida (morreu)";
		} else {
			return name + ": " + life + " de vida";
		}
	}
}
