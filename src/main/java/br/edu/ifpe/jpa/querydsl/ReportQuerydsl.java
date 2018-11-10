package br.edu.ifpe.jpa.querydsl;

import java.util.Date;
import java.util.List;

import br.edu.ifpe.jpa.IReportGenerator;
import br.edu.ifpe.jpa.entities.QAccount;
import br.edu.ifpe.jpa.entities.QClient;

public class ReportQuerydsl implements IReportGenerator {

	static EntityManagerHelper helper = EntityManagerHelper.getInstance();

	@Override
	public List<String> getClientNames(Date initialDate, Date finalDate) {
		QClient client = QClient.client;

		return helper.execute(query ->
		query
		.select(client.name)
		.from(client)
		.where(client.birthDate.after(initialDate).and(client.birthDate.before(finalDate)))
		.orderBy(client.birthDate.asc())
		.fetch()
				);
	}

	@Override
	public double getClientTotalCash(String email) {
		QAccount account = QAccount.account;

		return helper.execute(query ->
		query
		.select(account.balance.sum())
		.where(account.client.email.eq(email))
		.groupBy(account.balance)
		.fetchOne()
				);
	}

	@Override
	public List<String> getBestClientsEmails(String agency, int rankingSize) {
		QAccount account = QAccount.account;

		return helper.execute(query ->
		query
		.select(account.client.email)
		.where(account.agency.eq(agency))
		.orderBy(account.balance.sum().asc())
		.limit(rankingSize)
		.fetch()
				);
	}
}
