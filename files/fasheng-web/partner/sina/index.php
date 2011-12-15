<?php

session_start();
if( isset($_SESSION['last_key']) ) header("Location: weibolist.php");
include_once( 'config.php' );
include_once( 'saet.ex.class.php' );
header( "Content-Type:text/html;charset=UTF-8 ");

$o = new SaeTOAuth( WB_AKEY , WB_SKEY  );

$keys = $o->getRequestToken();
$aurl = $o->getAuthorizeURL( $keys['oauth_token'] ,false , CALLBACK_URL); //'http://' . $_SERVER['HTTP_APPNAME'] . '.sinaapp.com/callback.php');

//echo 'http://' . $_SERVER['HTTP_APPNAME'] . '.sinaapp.com/callback.php';

//print_r($keys);

$_SESSION['keys'] = $keys;


?>
<a href="<?=$aurl?>">Use Oauth to login</a>