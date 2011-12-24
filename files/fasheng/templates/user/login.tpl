<html> 
<head> 
<title>用户登录</title> 
<meta http-equiv="Content-Type" content="text/html; charset=utf8"> 
<link href="style.css" rel="stylesheet" type="text/css"/>
</head> 

<body> 
<div id="login_div">
<form name="form1" method="post" action="index.php"> 
<table width="300" border="0" align="center" cellpadding="2" cellspacing="2"> 
<tr> 
<td width="150"><div align="right">用户名：</div></td> 
<td width="150"><input type="text" name="username"></td> 
</tr> 
<tr> 
<td><div align="right">密码：</div></td> 
<td><input type="password" name="pwd"></td> 
</tr> 
</table> 
<p align="center"> 
<input type="submit" name="Submit" value="确定"> 
</p> 
</form> 
</div>
<div>
	<a href="{$loginUrl}">新浪微博</a> <span style="color:#ccc;padding:0 5px">|</span>
	
</div>
</body> 
</html> 
