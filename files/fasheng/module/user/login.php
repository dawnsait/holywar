<?php
@session_start();

include "../../env.php";
include SRC_DIR."/common/my_smarty.class.php";
include SRC_DIR."/common/global_function.php";

class Login {
	function get() {
		
	}
	
	function post() {
		
	} 	
	
	function display() {
		$weiboLoginUrl = $this->getAuthUrl();
		$mySmarty = new MySmaty;
		$mySmarty->assign('loginUrl', $weiboLoginUrl);
		$mySmarty->display("user/login.tpl");
	}
	
	// FIXME 获取requestToken这个需要写成全局方法的
	function getAuthUrl() {
		include_once (SRC_DIR.'/config/weibo-config.php');
		include_once (SRC_DIR.'/lib/saet.ex.class.php');

		$o = new SaeTOAuth(WB_AKEY, WB_SKEY);

		$keys = $o->getRequestToken();
		$aurl = $o->getAuthorizeURL($keys['oauth_token'], false, CALLBACK_URL);

		$_SESSION['keys'] = $keys;     //FIXME 不要放session，放在全局的缓存中
		return $aurl;
	}
}
run('Login');
?>
