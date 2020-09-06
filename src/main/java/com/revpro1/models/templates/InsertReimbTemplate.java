package com.revpro1.models.templates;

import java.util.Objects;

public class InsertReimbTemplate {
	
	private double amount;
	private String description;
	private int author;
	private int type;

	public InsertReimbTemplate() {
		super();
	}

	public InsertReimbTemplate(double amount, String description, int author, int type) {
		super();
		this.amount = amount;
		this.description = description;
		this.author = author;
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, author, description, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InsertReimbTemplate other = (InsertReimbTemplate) obj;
		return Objects.equals(amount, other.amount) && author == other.author
				&& Objects.equals(description, other.description) && type == other.type;
	}

	@Override
	public String toString() {
		return "InsertReimbTemplate [amount=" + amount + ", description=" + description + ", author=" + author
				+ ", type=" + type + "]";
	}

}
