package com.gachapon.web;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gachapon.domain.Account;
import com.gachapon.page.SuperUserPage;
import com.gachapon.service.SuperUserService;
import com.gachapon.web.form.CompanyRegisterForm;
import com.gachapon.web.form.SuperUserLoginForm;

@Controller 							// コントローラーであることを示す
@RequestMapping(value="/superUser")  	// アドレスの指定。ここで指定するのはクラス自体のアドレス。他のメソッド参考にしてください。
@SessionAttributes("superUserPage")		// セッション変数の指定
public class SuperUserContoroller {
	// 遷移先格納用
	private String url;
	
	// 遷移先指定用 単純遷移の時はこっち
	private final static String INDEX 		= "SuperUser/index";
	private final static String COMPANY_LIST = "SuperUser/top";
	
	// リダイレクト用 他の処理を通す時はこっち
	private final static String TOP		= "redirect:/superUser/top";
	private final static String LOGOUT 		= "redirect:/superUser";
	
	// エラーメッセージ用
	private final static String errorMsg 	= "errorMsg";
	
	@Autowired 							// DI。どのクラスと関連付けるか。コントローラーなのでサービスクラスを指定
	SuperUserService service;
	
	@ModelAttribute						// 利用する入力フォームの初期化
	private SuperUserLoginForm loginForm(){
		return new SuperUserLoginForm();
	}
	
	@ModelAttribute
	private CompanyRegisterForm companyRegisterForm() {
		return new CompanyRegisterForm();
	}
	
	/**
	 * スーパーユーザーの初期画面表示
	 * @return
	 * @author okumura
	 */
	@RequestMapping // valueの指定がないので、クラス自体のアドレスだけの際にはこのメソッドが呼び出される[http://localhost:8080/superUser]
	public String displaySuperUserIndex(){ // 戻り値はhtmlのファイル名を返すのでString
		return INDEX; // 呼び出すhtml(jsp)を指定。この場合[SuperUserフォルダのindex.jsp]を呼び出している。
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
		
		// サービスクラスからアカウント情報を取得
		Optional<Account> account = service.findSuperUser(form);
		
		// 取得できなかったときの処理
		if(!account.isPresent()){
			ObjectError error = new ObjectError(errorMsg,"ユーザー認証に失敗しました"); // エラー情報の格納
			result.addError(error);
			url = displaySuperUserIndex(); // 遷移先指定
		}
		
		// 正常時の処理
		account.ifPresent(superUser ->{
			SuperUserPage superUserPage = new SuperUserPage();
			BeanUtils.copyProperties(superUser, superUserPage); // 取得した値を表示用クラスにコピー
			model.addAttribute("superUserPage", superUserPage); // 取得できたアカウント情報を次の画面に渡すための処理
			url = TOP;
		});
		return url;
	}
	// ログアウト
	/**
	 * ログアウト
	 * @param sessionStatus
	 * @return
	 */
	@RequestMapping(value="logout")
	public String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return LOGOUT;
	}
	
	// 企業一覧
	/**
	 * 企業一覧画面(ログイン後の初期表示画面)
	 * @return
	 */
	@RequestMapping(value="top")
	public String displayCompanyList(){
		
		return COMPANY_LIST;
	}
	
	// 企業ユーザー追加
	@RequestMapping(value="registerCompany", method = { RequestMethod.POST })
	public String registerCompany(
			CompanyRegisterForm form,
			BindingResult result,
			Model model, 
			HttpSession session, 
			SessionStatus sessionStatus,
			RedirectAttributes redirectAttributes) {
		service.registerCompany(form);
		return TOP;
	}
	
	// ユーザー削除
}
