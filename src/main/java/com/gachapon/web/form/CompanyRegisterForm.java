package com.gachapon.web.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class CompanyRegisterForm {
	/** 企業名 */
	@NotEmpty
	@Size(min=1,max=100)
	private String companyName;
	@Size(min=1,max=100)
	private String location;
	
	private String imagePath;
	private String intro;
}