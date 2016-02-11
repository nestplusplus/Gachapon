package com.gachapon.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gachapon.domain.Account;
import com.gachapon.domain.Company;
import com.gachapon.repository.SuperUserRepository;
import com.gachapon.web.form.CompanyRegisterForm;
import com.gachapon.web.form.SuperUserLoginForm;

@Service
public class SuperUserService {
	@Autowired
	private SuperUserRepository repository;

	/**
	 * アカウント検索
	 * @param form
	 * @return
	 */
	public Optional<Account> findSuperUser(SuperUserLoginForm form) {
		String mailaddress = form.getMailaddress();
		String password = form.getPassword();
		Account account = repository.findByMailAndPassword(mailaddress, password);
		return Optional.ofNullable(account);
	}
	
	/**
	 * 企業情報検索
	 * @return
	 */
	public List<Company> findComapnyList() {
		return repository.findCompanyList();
	}
	
	/**
	 * 企業情報登録
	 * @param form
	 */
	public void registerCompany(CompanyRegisterForm form) {
		Company company = new Company();
		BeanUtils.copyProperties(form, company);
		company.setRegisteredDate(new Date());
		company.setModifiedDate(new Date());
		company.setDeleteFlag(false);
		repository.registerCompany(company);
	}

}
