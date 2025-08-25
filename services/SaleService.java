package services;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import entities.Sale2;

public class SaleService {

	public Map<String, Double> totalSalesBySeller(List<Sale2> sales) {
		Set<String> sellers = sales.stream().map(Sale2::getSeller).collect(Collectors.toSet());
		return sellers.stream().collect(Collectors.toMap(seller -> seller,
				seller -> sales.stream().filter(s -> s.getSeller().equals(seller)).mapToDouble(Sale2::getTotal).sum()));
	}
}