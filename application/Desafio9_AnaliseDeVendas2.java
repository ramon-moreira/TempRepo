package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entities.Sale2;
import services.SaleService;

public class Desafio9_AnaliseDeVendas2 {

	public static void main(String[] args) {
		String path = "c:\\temp\\base-de-dados2.csv";

		List<Sale2> sales = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(",");
				Integer month = Integer.parseInt(fields[0]);
				Integer year = Integer.parseInt(fields[1]);
				String seller = fields[2];
				Integer items = Integer.parseInt(fields[3]);
				Double total = Double.parseDouble(fields[4]);

				sales.add(new Sale2(month, year, seller, items, total));
			}

			SaleService service = new SaleService();
			Map<String, Double> totalBySeller = service.totalSalesBySeller(sales);

			System.out.println("Total de vendas por vendedor:");
			totalBySeller.forEach((seller, total) -> System.out.printf("%s - R$ %.2f%n", seller, total));

		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}