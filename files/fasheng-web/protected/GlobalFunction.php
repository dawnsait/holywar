<?php
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