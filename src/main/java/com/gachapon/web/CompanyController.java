package com.gachapon.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/company")
public class CompanyController {
	/**
	 * 企業ユーザー初期画面表示
	 * @return
	 * @author okumura
	 */
	@RequestMapping
	public String index(){
		return "Compnay/login";
	}
	// TODO:ログイン処理
	
	// TODO:info.jsp遷移
	
	// TODO:edit.jsp遷移
	
	// TODO:企業情報編集処理
	
	// TODO:ガチャポン一覧表示処理(gachapon.jsp遷移)
	
	// TODO:ガチャポン登録処理
	
	// TODO:ガチャポン編集処理
	
	// TODO:ガチャポン削除処理
}
