package br.edu.ifpe.jpa;

import java.util.Date;
import java.util.List;

public interface IReportGenerator {

	/**
	 * Retorna uma lista com o nome de todos os clientes que nasceram no intervalo de datas informados.
	 * A lista final é ordenada alfabeticamente
	 * 
	 * @param initialDate data inicial
	 * @param finalDate data final
	 * @return Retorna uma lista com o nome dos clientes que nasceram durante o período informado 
	 */
	List<String> getClientNames(Date initialDate, Date finalDate);
	
	/**
	 * Retorna valor total em dinheiro que o cliente possui no banco, somando todas as suas contas
	 * 
	 * @param email e-mail do cliente
	 * @return Retorna a soma dos saldos de todas as contas do cliente
	 */
	double getClientTotalCash(String email);
	
	/**
	 * Retorna uma lista (ranking) com os e-mails dos clientes que possuem mais dinheiro no banco, somando 
	 * todas suas contas. Além disso, a lista é ordenada de acordo com a quantidade de dinheiro que 
	 * o cliente possui. Caso o valor seja igual, é considerada a ordem alfabetica.
	 *  
	 * @param agency agência a ser considerada
	 * @param rankingSize quantidade de clientes que devem constar no ranking
	 * @return Retorna uma lista com os e-mails dos clientes que possuem o maior valor guardado no banco. 
	 */
	List<String> getBestClientsEmails(String agency, int rankingSize);
}
