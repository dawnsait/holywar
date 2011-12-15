<?php

session_start();
include_once( 'config.php' );
include_once( 'saet.ex.class.php' );
header( "Content-Type:text/html;charset=UTF-8 ");

$c = new SaeTClient( WB_AKEY , WB_SKEY , $_SESSION['last_key']['oauth_token'] , $_SESSION['last_key']['oauth_token_secret']  );
$ms  = $c->home_timeline(); // done


?>
<h2>发送新微博</h2>
<form action="weibolist.php" >
<input type="text" name="text" style="width:300px" />
&nbsp;<input type="submit" />
</form>
<?php

if( isset($_REQUEST['text']) )
{
$c->update( $_REQUEST['text'] );
// 发送微博
	//$o->post( "http://api.t.sina.com.cn/statuses/update.json" , array( 'status' => $_REQUEST['text'] ) );
	echo "<p>发送完成</p>";

}

?>

<?php if( is_array( $ms ) ): ?>
<?php foreach( $ms as $item ): ?>
<div style="padding:10px;margin:5px;border:1px solid #ccc">
<?=$item['text'];?>
</div>
<?php endforeach; ?>
<?php endif; ?>



