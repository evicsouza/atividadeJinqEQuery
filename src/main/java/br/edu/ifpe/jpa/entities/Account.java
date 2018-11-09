package br.edu.ifpe.jpa.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Account implements Cloneable {

	private Integer identifier;
	private String agency;
	private int number;
	private double balance;
	private Date creationDate;
	private Client client;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	public Integer getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	@Column(nullable = false)
	public String getAgency() {
		return agency;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Column(nullable = false)
	public int getNumber() {
		return number;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Column(nullable = false)
	public double getBalance() {
		return balance;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getCreationDate() {
		return creationDate;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@ManyToOne
	@JoinColumn(nullable = false, updatable=true)
	public Client getClient() {
		return client;
	}
	
	@Override
	public Account clone() {
		try {
			return (Account) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.getMessage());
		}
	}
}