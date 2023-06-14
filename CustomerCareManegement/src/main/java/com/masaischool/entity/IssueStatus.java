package com.masaischool.entity;

public enum IssueStatus {
  OPEN,
  CLOSED,
  RESOLVED;
	public static IssueStatus getDefault() {
		return OPEN;
	}
}
