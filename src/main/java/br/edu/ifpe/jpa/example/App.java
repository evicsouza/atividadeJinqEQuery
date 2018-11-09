package br.edu.ifpe.jpa.example;

import java.util.Date;
import java.util.List;

import br.edu.ifpe.jpa.IReportGenerator;
import br.edu.ifpe.jpa.ReportFactory;

public class App {
	
	public static void main(String[] args) {
		IReportGenerator generator = ReportFactory.getInstance();
		
		List<String> clients = generator.getClientNames(new Date(), new Date());
		System.out.println(clients);
	}
}
