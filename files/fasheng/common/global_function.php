<?php
/*
 * Created on 2011-12-24
 *
 * To change the template for this generated file go to
 * Window - Preferences - PHPeclipse - PHP - Code Templates
 */

/**
 * 页面统一入口
 */
function run($className) {
   $obj = new $className;
   if($_GET == null && $_POST == null) {
      $obj->display();
   }
   else if($_GET != null) {
      $obj->get();
   } 
   else if($_POST != null) {
      $obj->post();
   } 
}

/**
 * 调用json api
 */
function getHttpPostResult($url, $fields) {
	$data = http_build_query($fields);

    $opts = array( 
      'http'=>array( 
        'method'=>"POST", 
        'header'=>"Content-type: application/x-www-form-urlencoded\r\n". 
                  "Content-length:".strlen($data)."\r\n" .   
                  "\r\n", 
        'content' => $data, 
      ) 
    ); 

	$context = stream_context_create($opts);
	$result = file_get_contents($url, false, $context);

	return $result;
}

/**
 * 设置session, 超时时间以分为单位
 */
function setSession($key, $value, $expireTime=30) {
	$seconds = $expireTime * 60;
	session_set_cookie_params($seconds);
	$_SESSION[$key] = $value;
}

function delSession($key) {
	unset($_SESSION[$key]);
}

?>
