package com.gachapon.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * アカウント情報のEntity.
 * @author okumura
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	/** ID */
	private Integer id;
	/** ユーザー名 */
	private String userName;
	/** メールアドレス */
	private String mailaddress;
	/** パスワード */
	private String password;
	/** 最寄り */
	private String location;
	/** 登録日 */
	private Date registeredDate;
	/** 更新日 */
	private Date modifiedDate;
	/** スーパーユーザーフラグ */
	private boolean superFlag;
	/** 退会フラグ */
	private boolean resignFlag;
}
