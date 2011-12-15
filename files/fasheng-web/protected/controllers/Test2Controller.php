<?php

class Test2Controller extends Controller
{
	/**
	 * Declares class-based actions.
	 */
	public function actions()
	{
		return array(
			// captcha action renders the CAPTCHA image displayed on the contact page
			'captcha'=>array(
				'class'=>'CCaptchaAction',
				'backColor'=>0xFFFFFF,
				
			),
			// page action renders "static" pages stored under 'protected/views/site/pages'
			// They can be accessed via: index.php?r=site/page&view=FileName
			'page'=>array(
				'class'=>'CViewAction',
			),
		);
	}

	/**
	 * Displays the contact page
	 */
	public function actionTest2()
	{
		$model=new Test2Form;
		if(isset($_POST['Test2Form']))
		{
			$model->attributes=$_POST['Test2Form'];
			if($model->validate())
			{
				$headers="From: {$model->email}\r\nReply-To: {$model->email}";
				$this->refresh();
			}
		}
		$this->render('test2',array('model'=>$model));
	}

}