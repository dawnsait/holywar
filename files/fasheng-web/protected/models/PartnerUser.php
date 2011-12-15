<?php

/**
 * This is the model class for table "partner_user".
 *
 * The followings are the available columns in table 'partner_user':
 * @property integer $id
 * @property string $gmt_create
 * @property string $gmt_update
 * @property integer $user_id
 * @property string $access_token
 * @property string $refresh_token
 * @property string $version
 * @property integer $type
 */
class PartnerUser extends CActiveRecord
{
	/**
	 * Returns the static model of the specified AR class.
	 * @return PartnerUser the static model class
	 */
	public static function model($className=__CLASS__)
	{
		return parent::model($className);
	}

	/**
	 * @return string the associated database table name
	 */
	public function tableName()
	{
		return 'partner_user';
	}

	/**
	 * @return array validation rules for model attributes.
	 */
	public function rules()
	{
		// NOTE: you should only define rules for those attributes that
		// will receive user inputs.
		return array(
			array('user_id, type', 'numerical', 'integerOnly'=>true),
			array('access_token, refresh_token', 'length', 'max'=>256),
			array('version', 'length', 'max'=>6),
			array('gmt_create, gmt_update', 'safe'),
			// The following rule is used by search().
			// Please remove those attributes that should not be searched.
			array('id, gmt_create, gmt_update, user_id, access_token, refresh_token, version, type', 'safe', 'on'=>'search'),
		);
	}

	/**
	 * @return array relational rules.
	 */
	public function relations()
	{
		// NOTE: you may need to adjust the relation name and the related
		// class name for the relations automatically generated below.
		return array(
		);
	}

	/**
	 * @return array customized attribute labels (name=>label)
	 */
	public function attributeLabels()
	{
		return array(
			'id' => 'ID',
			'gmt_create' => 'Gmt Create',
			'gmt_update' => 'Gmt Update',
			'user_id' => 'User',
			'access_token' => 'Access Token',
			'refresh_token' => 'Refresh Token',
			'version' => 'Version',
			'type' => 'Type',
		);
	}

	/**
	 * Retrieves a list of models based on the current search/filter conditions.
	 * @return CActiveDataProvider the data provider that can return the models based on the search/filter conditions.
	 */
	public function search()
	{
		// Warning: Please modify the following code to remove attributes that
		// should not be searched.

		$criteria=new CDbCriteria;

		$criteria->compare('id',$this->id);
		$criteria->compare('gmt_create',$this->gmt_create,true);
		$criteria->compare('gmt_update',$this->gmt_update,true);
		$criteria->compare('user_id',$this->user_id);
		$criteria->compare('access_token',$this->access_token,true);
		$criteria->compare('refresh_token',$this->refresh_token,true);
		$criteria->compare('version',$this->version,true);
		$criteria->compare('type',$this->type);

		return new CActiveDataProvider($this, array(
			'criteria'=>$criteria,
		));
	}
}