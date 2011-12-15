<?php
class LoginController extends Controller {
	/**
	 * Declares class-based actions.
	 */
	public function actions() {
		return array (
			// captcha action renders the CAPTCHA image displayed on the contact page
			'captcha' => array (
				'class' => 'CCaptchaAction',
				'backColor' => 0xFFFFFF,

				
			),
			// page action renders "static" pages stored under 'protected/views/site/pages'
			// They can be accessed via: index.php?r=site/page&view=FileName
			'page' => array (
				'class' => 'CViewAction',
				
			),
			
		);
	}

	/**
	 * Display login page
	 */
	public function actionLogin() {
		$provinces = Provinces :: model()->findAll();
		foreach ($provinces as $province) {
			echo $province->name . "<br/>";
		}
		$identity = new UserIdentity("admin", "admin");
		if ($identity->authenticate())
			Yii :: app()->user->login($identity);
		$model = new LoginForm;
		if (isset ($_POST['LoginForm'])) {
			$model->attributes = $_POST['LoginForm'];
			if ($model->validate()) {
				$headers = "From: {$model->email}\r\nReply-To: {$model->email}";
				$this->refresh();
			}
		}
		$session = Yii :: app()->session;
		if (isset ($session['user'])) {
			echo 'login';
			die;
		}
		self :: setAuthUrl();

		$this->render('login', array (
			'model' => $model
		));
	}

	/**
	 * 处理callback
	 */
	public function actionCallback() {
		include_once (CONFIG_DIR . '/weibo-config.php');
		include_once (ROOT_DIR . '/lib/saet.ex.class.php');
		$session = Yii :: app()->session;
		$o = new SaeTOAuth(WB_AKEY, WB_SKEY, $session['keys']['oauth_token'], $session['keys']['oauth_token_secret']);

		$last_key = $o->getAccessToken($_REQUEST['oauth_verifier']);
		echo '************<br/>';
		$session['last_key'] = $last_key;

		var_dump($last_key);
		var_dump($session);

	}

	/**
	 * keys和aurl可以放入缓存（如apc），这样不用频繁生成
	 */
	public function setAuthUrl() {
		include_once (CONFIG_DIR . '/weibo-config.php');
		include_once (ROOT_DIR . '/lib/saet.ex.class.php');

		$o = new SaeTOAuth(WB_AKEY, WB_SKEY);

		$keys = $o->getRequestToken();
		$aurl = $o->getAuthorizeURL($keys['oauth_token'], false, CALLBACK_URL);

		$session = Yii :: app()->session;
		$session['keys'] = $keys;
		$session['aurl'] = $aurl;
	}

}