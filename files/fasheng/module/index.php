<?php
include "../env.php";
include SRC_DIR."/common/my_smarty.class.php";
include SRC_DIR."/common/global_function.php";

class Index {
	function get() {
		echo "get...";
	}
	
	function display() {
		$mySmarty = new MySmaty;
		$mySmarty->display("index.tpl");
	}	
}

run('Index');

?>