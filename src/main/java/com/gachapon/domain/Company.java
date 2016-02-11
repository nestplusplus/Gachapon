package com.gachapon.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
	private Integer id;
	private String companyName;
	private String location;
	private String imagePath;
	private String intro;
	private Date registeredDate;
	private Date modifiedDate;
	private boolean deleteFlag;
}
