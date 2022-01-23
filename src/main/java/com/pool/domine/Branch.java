package com.pool.domine;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Setter
@Getter
public class Branch {
	private String branchName;
	private String concession;
	private String startPoint;
	private String endPoint;
	private Double fairAmount;

	public Branch() {

	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getConcession() {
		return concession;
	}

	public void setConcession(String concession) {
		this.concession = concession;
	}

	public String getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public Double getFairAmount() {
		return fairAmount;
	}

	public void setFairAmount(Double fairAmount) {
		this.fairAmount = fairAmount;
	}

	@Override
	public String toString() {
		return "Branch [branchName=" + branchName + ", concession=" + concession + ", startPoint=" + startPoint
				+ ", endPoint=" + endPoint + ", fairAmount=" + fairAmount + "]";
	}

}
