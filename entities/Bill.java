package entities;

public class Bill {
	public char gender;
	public int beer;
	public int barbecue;
	public int softDrink;

	public double cover() {
		if (feeding() < 30.0) {
			return 4.00;
		} else {
			return 0.00;
		}
	}

	public double feeding() {
		double beerCost = beer * 5.0;
		double barbecueCost = barbecue * 7.0;
		double softDrinkCost = softDrink * 3.0;
		return beerCost + barbecueCost + softDrinkCost;
	}

	public double ticket() {
		if (gender == 'f' || gender == 'F') {
			return 8.00;
		} else {
			return 10.00;
		}
	}

	public double total() {
		return cover() + feeding() + ticket();
	}

	//Como eu queria deixar toda a responsabilidade na Classe Bill, inclusive a responsabilidade de validação que seria na interface, procurei na documentação, e achei esse modo de trazer o toString() modificado. Embora não entenda bem, preferi utilizar, o que deixa mais claro e definido tudo.
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("RELATÓRIO:\n");
		sb.append(String.format("Consumo = R$ %.2f\n", feeding()));
		if (cover() == 0.00) {
			sb.append("Isento de couvert\n");
		} else {
			sb.append(String.format("Couvert = R$ %.2f\n", cover()));
		}
		sb.append(String.format("Ingresso = R$ %.2f%n", ticket()));
		sb.append(String.format("Valor a pagar = R$ %.2f\n", total()));
		return sb.toString();
	}
}
