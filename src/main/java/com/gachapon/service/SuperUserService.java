package com.gachapon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gachapon.domain.Account;
import com.gachapon.repository.SuperUserRepository;
import com.gachapon.web.SuperUserLoginForm;

@Service
public class SuperUserService {
	@Autowired
	private SuperUserRepository repository;

	public Account findSuperUser(SuperUserLoginForm form) {
		String mailaddress = form.getMailaddress();
		String password = form.getPassword();
		Account account = repository.findByMailAndPassword(mailaddress, password);
		return account;
	}

}
