package com.gachapon.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.gachapon.domain.Account;
import com.gachapon.domain.Company;

@Repository
public class SuperUserRepository {
	/**
	 * JDBCテンプレート
	 */
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	/**
	 * アカウント検索用マッパー
	 */
	private static final RowMapper<Account> ACCOUNT_ROW_MAPPER = (rs, i) -> {
		Integer id 			= rs.getInt("id");
		String name 		= rs.getString("user_name");
		String mailaddress 	= rs.getString("mailaddress");
		String password 	= rs.getString("password");
		String location 	= rs.getString("location");
		Date registeredDate = rs.getDate("registered_date");
		Date modifiedDate 	= rs.getDate("modified_date");
		boolean superFlag 	= rs.getBoolean("super_flag");
		boolean resignFlag  = rs.getBoolean("resign_flag");
		return new Account(id,name,mailaddress,password,location,registeredDate,modifiedDate,superFlag,resignFlag);
	};
	
	/**
	 * メールアドレスとパスワードからアカウント情報を取得
	 * @param mailaddress
	 * @param password
	 * @return
	 */
	public Account findByMailAndPassword (String mailaddress, String password){
		Account account = null;
		try {
			SqlParameterSource param = new MapSqlParameterSource()
					.addValue("mailaddress", mailaddress)
					.addValue("password",password);
			account = jdbcTemplate.queryForObject(
					"SELECT id, user_name, mailaddress, password, location, registered_date, modified_date, super_flag, resign_flag "
					+ "FROM ACCOUNT "
					+ "WHERE mailaddress = :mailaddress AND password = :password AND super_flag = TRUE", 
					param, 
					ACCOUNT_ROW_MAPPER);
		} catch (Exception e) {}
		return account;
	}
	
	/**
	 * 企業情報全検索用マッパー
	 */
	private static final ResultSetExtractor<List<Company>> COMPANY_ROW_MAPPER = (rs) -> {
		List<Company> companyList = new ArrayList<>();
		while (rs.next()) {
			Company company = new Company();
			company.setId(rs.getInt("id"));
			company.setCompanyName(rs.getString("company_name"));
			company.setLocation(rs.getString("location"));
			company.setImagePath(rs.getString("imagePath"));
			company.setIntro(rs.getString("intro"));
			companyList.add(company);
		}
		return companyList;
	};
	
	/**
	 * 企業情報を取得
	 * @return
	 */
	public List<Company> findCompanyList() {
		SqlParameterSource param = new MapSqlParameterSource();
		String sql = "SELECT id, company_name, loation, imagePath, intro FROM company ORDER BY id";
		return jdbcTemplate.query(sql, param, COMPANY_ROW_MAPPER);
	}
	
	/**
	 * 企業情報を登録
	 * @param company
	 */
	public void registerCompany (Company company) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(company);
		jdbcTemplate.update(
				"INSERT INTO company (company_name, location, image_path, intro, registered_date, modified_date, delete_flag) "
				+ "VALUES (:companyName, :location, :imagePath, :intro, :registeredDate, :modifiedDate, :deleteFlag);",
				param);
	}
}