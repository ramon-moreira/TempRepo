package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Champion;

public class Desafio_4Champion {

	public static void main(String[] args) {
Locale.setDefault(Locale.US);
Scanner sc = new Scanner(System.in);
Champion championOne;
Champion championTwo;

System.out.println("Digite os dados do primeiro campeão:");
System.out.print("Nome: ");
String name = sc.nextLine();
System.out.print("Vida inicial: ");
int life = sc.nextInt();
System.out.print("Ataque: ");
int attack = sc.nextInt();
System.out.print("Armadura: ");
int armor = sc.nextInt();
championOne = new Champion(name, life, attack, armor);
sc.nextLine();
System.out.println("Digite os dados do segundo campeão:");
System.out.print("Nome: ");
String name2 = sc.nextLine();
System.out.print("Vida inicial: ");
int life2 = sc.nextInt();
System.out.print("Ataque: ");
int attack2 = sc.nextInt();
System.out.print("Armadura: ");
int armor2 = sc.nextInt();
championTwo = new Champion(name2, life2, attack2, armor2);
System.out.print("Quantos turnos você deseja executar?");
int turns = sc.nextInt();
for (int i = 1; i < turns+1; i++) {
	championOne.takeDamage(championTwo);
	championTwo.takeDamage(championOne);
	System.out.println("Resultado do turno " + i + " :");
	System.out.println(championOne.status());
	System.out.println(championTwo.status());
	if (championOne.getLife() == 0 || championTwo.getLife() == 0) {
        break;
    }
}
System.out.println("FIM DO COMBATE");
sc.close();
	}

}
