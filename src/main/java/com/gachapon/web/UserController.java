package com.gachapon.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ユーザー関連のコントローラー
 * @author okumura
 */
@Controller
@RequestMapping(value="/")
public class UserController {
	/**
	 * 初期画面表示
	 * @return
	 * @author okumura
	 */
	@RequestMapping
	public String index(){
		return "index"; // index.jspからUser/top遷移するか、そもそもUser/topに遷移する処理にするかは任せます
	}

	// TODO:topログイン画面遷移
	@RequestMapping(value = "top")
	public String top(){
		return "User/top";
	}
	// TODO:Userログイン画面遷移
	@RequestMapping(value = "login")
	public String login(){
		return "User/login";
	}
	// TODO:User企業詳細画面遷移
	@RequestMapping(value = "companyDetail")
	public String companyDetail(){
		return "User/companyDetail";
	}
	// TODO:register新規登録画面遷移
	@RequestMapping(value = "register")
	public String register(){
		return "User/register";
	}
	// TODO:gachaponガチャ画面遷移
	@RequestMapping(value = "gachapon")
	public String gachapon(){
		return "User/gachapon";
	}
	// TODO:mypageマイページ遷移処理
	@RequestMapping(value = "mypage")
	public String mypage(){
		return "User/mypage";
	}
	// TODO:edit編集画面遷移
	@RequestMapping(value = "edit")
	public String edit(){
		return "User/edit";
	}
	// TODO:新規登録処理

	// TODO:ログイン処理

	// TODO:編集処理


}