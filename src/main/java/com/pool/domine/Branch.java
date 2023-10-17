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
}
