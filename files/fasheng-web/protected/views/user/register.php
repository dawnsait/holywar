<?php
$this->pageTitle=Yii::app()->name . ' - Register Form';
$this->breadcrumbs=array(
	'register form',
);
?>

<h1>Register Form</h1>


<div class="form">

<?php $form=$this->beginWidget('CActiveForm', array(
	'id'=>'register_form',
	'enableClientValidation'=>true,
	'clientOptions'=>array(
		'validateOnSubmit'=>true,
	),
)); ?>

	<p class="note">Fields with <span class="required">*</span> are required.</p>

	<?php echo $form->errorSummary($model); ?>

  <table>
    <tr>
      <td><?php echo $form->labelEx($model,'username'); ?></td>
      <td><?php echo $form->textField($model,'username'); ?></td>
      <td><?php echo $form->error($model,'username'); ?></td>
    </tr>
    <tr>
      <td><?php echo $form->labelEx($model,'email'); ?></td>
      <td><?php echo $form->textField($model,'email'); ?></td>
      <td><?php echo $form->error($model,'email'); ?></td>
    </tr>
    <tr>
      <td><?php echo $form->labelEx($model,'password'); ?></td>
      <td><?php echo $form->textField($model,'password'); ?></td>
      <td><?php echo $form->error($model,'password'); ?></td>
    </tr>    
    <tr>
      <td><?php echo $form->labelEx($model,'confirm_password'); ?></td>
      <td><?php echo $form->textField($model,'confirm_password'); ?></td>
      <td><?php echo $form->error($model,'confirm_password'); ?></td>
    </tr>    
	<tr>
      <td><?php echo CHtml::submitButton('Submit'); ?></td>
      <td></td>
      <td></td>
    </tr>    
  </table>

<?php $this->endWidget(); ?>
</div><!-- form -->