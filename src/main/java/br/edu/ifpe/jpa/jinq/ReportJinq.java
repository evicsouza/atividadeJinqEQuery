package br.edu.ifpe.jpa.jinq;

import java.util.Date;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import br.edu.ifpe.jpa.IReportGenerator;
import br.edu.ifpe.jpa.entities.Account;
import br.edu.ifpe.jpa.entities.Client;

public class ReportJinq implements IReportGenerator {

	static EntityManagerHelper helper = EntityManagerHelper.getInstance();

	@Override
	public List<String> getClientNames(Date initialDate, Date finalDate) {
		return helper.execute(Client.class, streams ->
		streams
		.where(client -> client.getBirthDate().after(initialDate))
		.where(client -> client.getBirthDate().before(finalDate))
		.select(Client::getName)
		.sortedBy(client -> client)
		.toList()
				); 
	}

	@Override
	public double getClientTotalCash(String email) {		
		return helper.execute(Account.class, streams ->
		streams
		.where(account -> account.getClient().getEmail().equals(email))
		.sumDouble(account -> account.getBalance())	

				);

	}

	@Override
	public List<String> getBestClientsEmails(String agency, int rankingSize) {
		return helper.execute(Account.class, streams ->
		streams
		.where(account -> account.getAgency().equals(agency))
		.sumDouble(account -> account.getBalance())
		.select(Account::getClient().getEmail())
		.limit(rankingSize)
		.toList()

				);

	}
}
