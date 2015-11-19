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
		return "index";
	}
}