package com.gachapon.web.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class SuperUserLoginForm {
	/** メールアドレス */
	@NotEmpty
	@Size(min=1,max=100)
	@Email
	private String mailaddress;
	
	/** パスワード */
	@NotEmpty
	@Size(min=1,max=20)
	private String password;
}
