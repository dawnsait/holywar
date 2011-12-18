<?php

/**
 * RegisterForm class.
 * RegisterForm is the data structure for keeping
 * user login form data. It is used by the 'register' action of 'SiteController'.
 */
class RegisterForm extends CFormModel
{
	public $username;
	public $email;
	public $password;
	public $confirm_password;

	private $_identity;

	/**
	 * Declares the validation rules.
	 * The rules state that username and password are required,
	 * and password needs to be authenticated.
	 */
	public function rules()
	{
		return array(
			// username and password are required
			array('username, password, email, confirm_password', 'required'),		
		);
	}

	/**
	 * Logs in the user using the given username and password in the model.
	 * @return boolean whether register is successful
	 */
	public function register()
	{
		$userRegisterParam = array ('username' => $this->username,'email' => $this->email,'password' => $this->password);
		
		echo json_encode($userRegisterParam);
		
		$postArray = array ('requestInfo' => json_encode($userRegisterParam));
		$result = getHttpPostResult("http://192.168.1.101:8080/web/user/register",$postArray);
		echo $result;
//		if($this->_identity===null)
//		{
//			$this->_identity=new UserIdentity($this->username,$this->password);
//			$this->_identity->authenticate();
//		}
//		if($this->_identity->errorCode===UserIdentity::ERROR_NONE)
//		{
//			$duration=$this->rememberMe ? 3600*24*30 : 0; // 30 days
//			Yii::app()->user->login($this->_identity,$duration);
//			return true;
//		}
//		else
			return false;
	}
}
