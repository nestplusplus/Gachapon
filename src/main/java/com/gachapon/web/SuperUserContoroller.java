package com.gachapon.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gachapon.domain.Account;
import com.gachapon.service.SuperUserService;

@Controller 							// コントローラーであることを示す
@RequestMapping(value="/superUser")  	// アドレスの指定。ここで指定するのはクラス自体のアドレス。他のメソッド参考にしてください。
public class SuperUserContoroller {
	@Autowired 							// DI。どのクラスと関連付けるか。コントローラーなのでサービスクラスを指定
	SuperUserService service;
	
	@ModelAttribute						// 利用する入力フォームの初期化
	private SuperUserLoginForm loginForm(){
		return new SuperUserLoginForm();
	}
	
	/**
	 * スーパーユーザーの初期画面表示
	 * @return
	 * @author okumura
	 */
	@RequestMapping // valueの指定がないので、クラス自体のアドレスだけの際にはこのメソッドが呼び出される[http://localhost:8080/superUser]
	public String displaySuperUserIndex(){ // 戻り値はhtmlのファイル名を返すのでString
		return "SuperUser/index"; // 呼び出すhtml(jsp)を指定。この場合[SuperUserフォルダのindex.jsp]を呼び出している。
	}
	
	/**
	 * スーパーユーザーのログイン処理
	 * ログイン後はメニュー画面へ遷移　/　エラーの場合はログイン画面へ再遷移
	 * @param form
	 * @param result
	 * @param model
	 * @param session
	 * @param sessionStatus
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value="login") // クラス自体のアドレスと結びついて[http://localhost:8080/superUser/login]になる
	public String login(
			SuperUserLoginForm form,
			BindingResult result,
			Model model, 
			HttpSession session, 
			SessionStatus sessionStatus,
			RedirectAttributes redirectAttributes){
		Account account = service.findSuperUser(form); // サービスクラスからアカウント情報を取得
		if(account == null){ // 取得できなかったときの処理
			ObjectError error = new ObjectError("errorMsg","メールアドレスかパスワードが違います。");
			result.addError(error);
			return displaySuperUserIndex();
		}
		model.addAttribute("account", account); // 取得できたアカウント情報を次の画面に渡すための処理
		return "SuperUser/menu";
	}
	// ログアウト
}
