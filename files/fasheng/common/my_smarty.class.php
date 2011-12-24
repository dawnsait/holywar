<?php

class MySmaty {

	private $_engine;
	
    public function __construct() {
		include(SRC_DIR."/lib/Smarty/Smarty.class.php");
    	$this->_engine = new Smarty();
        $this->_engine->template_dir = SRC_DIR.'/templates';
        $this->_engine->compile_dir = SRC_DIR.'/templates_c';
        $this->_engine->cache_dir = SRC_DIR.'/cache';
        $this->_engine->caching = false;
        $this->_engine->cache_lifetime = 300;
    }
    
    public function getEngine(){
        return $this->_engine;
    }

    public function __set($key, $val){
        $this->_engine->assign($key, $val);
    }

    public function __get($key){
        return $this->_engine->get_template_vars($key);
    }

    public function __isset($key){
        return $this->_engine->get_template_vars($key) !== null;
    }

    public function __unset($key){
        $this->_engine->clear_assign($key);
    }

    public function assign($spec, $value = null){
        if (is_array($spec)) {
            $this->_engine->assign($spec);
            return;
        }
        $this->_engine->assign($spec, $value);
    }

    public function clearVars(){
        $this->_engine->clear_all_assign();
    }

    public function render($name){
        return $this->_engine->fetch(strtolower($name));
    }
    
    public function display($name){
        $this->_engine->display($name); 
    }
    

    public function _run(){ 
    	
    }
}
?>