<?php
@session_start();

include "../../env.php";
include SRC_DIR."/common/my_smarty.class.php";
include SRC_DIR."/common/global_function.php";

include_once (SRC_DIR.'/config/weibo-config.php');
include_once (SRC_DIR.'/lib/saet.ex.class.php');

$o = new SaeTOAuth(WB_AKEY, WB_SKEY, $_SESSION['keys']['oauth_token'], $_SESSION['keys']['oauth_token_secret']);

$last_key = $o->getAccessToken($_REQUEST['oauth_verifier']);
echo '************<br/>';
$_SESSION['last_key'] = $last_key;

var_dump($last_key);
var_dump($_SESSION);

?>