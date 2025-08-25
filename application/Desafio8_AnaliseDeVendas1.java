
package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Sale;

public class Desafio8_AnaliseDeVendas1 {

	public static void main(String[] args) {
	    List<Sale> sales = new ArrayList<>();

	    try (BufferedReader br = new BufferedReader(new FileReader("C:\\temp\\base-de-dados.csv"))) {
	        String line;
	        while ((line = br.readLine()) != null) {
	            String[] fields = line.split(",");
	            Integer month = Integer.parseInt(fields[0]);
	            Integer year = Integer.parseInt(fields[1]);
	            String seller = fields[2];
	            Integer items = Integer.parseInt(fields[3]);
	            Double total = Double.parseDouble(fields[4]);
	            sales.add(new Sale(month, year, seller, items, total));
	        }
	    } catch (IOException e) {
	        System.out.println("Erro: " + e.getMessage());
	        return;
	    }

	    System.out.println("Cinco primeiras vendas de 2016 de maior preço médio");
	    sales.stream().filter(s -> s.getYear() == 2016).sorted((s1, s2) -> s2.averagePrice().compareTo(s1.averagePrice())).limit(5).forEach(System.out::println);
	    double totalLogan = sales.stream().filter(s -> s.getSeller().equals("Logan")).filter(s -> s.getMonth() == 1 || s.getMonth() == 7).mapToDouble(Sale::getTotal).sum();

	    System.out.printf("Valor total vendido pelo vendedor Logan nos meses 1 e 7 = %.2f%n", totalLogan);
}
}