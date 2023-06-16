package com.masaischool.entity;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Issue {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int IssueID;
	  @Column(nullable = false)
	  private String desc;
	  @Enumerated(EnumType.STRING)
	  @Column(nullable = false)
	  private IssueStatus status=IssueStatus.getDefault() ;
	  @Column(nullable = false)
	  private LocalDate date;
	  private String feedback;
	  private String reply;
	  @ManyToOne (fetch = FetchType.LAZY)
	  @JoinColumn(name="CR_ID")
	  CustomerRepresentative represntative;
	  @ManyToOne (fetch = FetchType.LAZY)
	  @JoinColumn(name="Customer_ID")
	  Customer customer;
	public Issue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Issue(String desc, IssueStatus status, LocalDate date, String feedback, String reply,
			CustomerRepresentative represntative, Customer customer) {
		super();
		this.desc = desc;
		this.status = status;
		this.date = date;
		this.feedback = feedback;
		this.reply = reply;
		this.represntative = represntative;
		this.customer = customer;
	}
	public int getIssueID() {
		return IssueID;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public IssueStatus getStatus() {
		return status;
	}
	public void setStatus(IssueStatus status) {
		this.status = status;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public CustomerRepresentative getRepresntative() {
		return represntative;
	}
	public void setRepresntative(CustomerRepresentative represntative) {
		this.represntative = represntative;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	  
}
