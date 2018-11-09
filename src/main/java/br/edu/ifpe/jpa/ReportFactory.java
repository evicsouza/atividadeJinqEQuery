package br.edu.ifpe.jpa;

import br.edu.ifpe.jpa.jinq.ReportJinq;

public class ReportFactory {

	private static IReportGenerator instance;
	
	public static IReportGenerator getInstance() {
		if (instance == null) {
			instance = new ReportJinq();
		}
		
		return instance;
	}
}
