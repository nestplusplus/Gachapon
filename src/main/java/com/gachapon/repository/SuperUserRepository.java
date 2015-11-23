package com.gachapon.repository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.gachapon.domain.Account;

@Repository
public class SuperUserRepository {
	/**
	 * JDBCテンプレート
	 */
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	/**
	 * マッパー
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
	
	private static final RowMapper<Account> LOGIN_ROW_MAPPER = (rs, i) -> {
		Integer id = rs.getInt("id");
		String name = rs.getString("user_name");
		Account account = new Account();
		account.setId(id);
		account.setUserName(name);
		return account;
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
					"SELECT id, user_name, mailaddress, password, location, registered_date, modified_date, super_flag, resign_flag"
					+ " FROM ACCOUNT "
					+ "WHERE mailaddress = :mailaddress AND password = :password", 
					param, 
					ACCOUNT_ROW_MAPPER);
		} catch (Exception e) {}
		return account;
	}
}