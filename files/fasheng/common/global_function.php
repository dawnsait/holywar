<?php
/*
 * Created on 2011-12-24
 *
 * To change the template for this generated file go to
 * Window - Preferences - PHPeclipse - PHP - Code Templates
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

?>
