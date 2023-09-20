package com.in28minutes.microservices.currencyexchangeservice.model;

import java.math.BigDecimal;

//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
//@Entity
public class CurrencyExchange {

//	@Id
	private Long id;

//	@Column(name = "currency_from")
	private String from;

//	@Column(name = "currency_to")
	private String to;

//	@Column(name = "amount")

	private BigDecimal amount;
	private String environment;

	public CurrencyExchange() {
	}

	public CurrencyExchange(Long id, String from, String to, BigDecimal amount, String environment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.amount = amount;
		this.environment = environment;
	}

	public Long getId() {
		return id;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	@Override
	public String toString() {
		return "CurrencyExchange [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiple="
				+ amount + ", environment=" + environment + "]";
	}

}
