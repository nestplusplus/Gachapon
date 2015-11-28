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
	
	// TODO:ログイン画面遷移
	
	// TODO:新規登録画面遷移
	
	// TODO:新規登録処理
	
	// TODO:ログイン処理
	
	// TODO:マイページ遷移処理
	
	// TODO:編集画面遷移
	
	// TODO:編集処理
	
	// TODO:企業詳細画面遷移
	
	// TODO:ガチャ
}