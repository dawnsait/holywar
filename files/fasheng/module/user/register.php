<?php
include "../../env.php";
include SRC_DIR."/common/my_smarty.class.php";
include SRC_DIR."/common/global_function.php";

class Register {
	function get() {
		$userRegisterParam = array ('userName' => $_GET['username'] ,'email' => $_GET['email'], 'password' => $_GET['password']);				
		$postArray = array ('requestInfo' => json_encode($userRegisterParam));
		$result = getHttpPostResult("http://127.0.0.1:8080/user/register",$postArray);
		echo $result;
	}

	function post() {
		$userRegisterParam = array ('userName' => $_POST['username'] ,'email' => $_POST['email'], 'password' => $_POST['password']);		
		$postArray = array ('requestInfo' => json_encode($userRegisterParam));
		$resultStr = getHttpPostResult("http://127.0.0.1:8080/user/register",$postArray);
		
		$result = json_decode($resultStr);
		echo $result->{'userId'};
		
		$url="../index.php";
		header("Location: $url");
		
	}
	
	function display() {
		$mySmarty = new MySmaty;
		$mySmarty->display("user/register.tpl");
	}	
}

run('Register');

?>