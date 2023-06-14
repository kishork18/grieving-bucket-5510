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
}
