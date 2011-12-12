@echo off

:input_project_home
SET PROJECT_HOME=
SET /p PROJECT_HOME=【输入应用根目录，默认为%cd%】
if /i "%PROJECT_HOME%"=="" SET PROJECT_HOME=%cd%
if not exist "%PROJECT_HOME%" ECHO 找不到路径%PROJECT_HOME%
if not exist "%PROJECT_HOME%" goto input_project_home
cd /d %PROJECT_HOME%
ECHO 应用根目录为%PROJECT_HOME%

:mvn_command
ECHO ************************
ECHO 请选择需要执行的常用命令(注意:不执行测试但还是会编译测试文件和测试资源文件)
ECHO ************************
ECHO 1-生成eclipse工程文件(注意:如果无法正常通过,请先执行选项3或者4)
ECHO 2-编译打包,不执行测试
ECHO 3-编译打包(解压war包),不执行测试
ECHO 4-编译打包,并执行测试
ECHO 5-编译打包(解压war包),并执行测试
ECHO 6-执行整个工程的测试
ECHO 7-执行单个项目的测试
ECHO 0-退出菜单
set isopt=
set /p isopt=【选择命令】
if /i "%isopt%"=="1" goto mvn_eclipse
if /i "%isopt%"=="2" goto mvn_install_not_test
if /i "%isopt%"=="3" goto mvn_install_not_test_unzip_war
if /i "%isopt%"=="4" goto mvn_install_with_test
if /i "%isopt%"=="5" goto mvn_install_with_test_unzip_war
if /i "%isopt%"=="6" goto mvn_all_test
if /i "%isopt%"=="7" goto mvn_project_test
if /i "%isopt%"=="0" goto exit

echo "无效选项，请选择(0-7)"
goto mvn_command

:mvn_eclipse
	cd %PROJECT_HOME%\all
	echo 开始生成eclipse工程文件
	call mvn eclipse:eclipse -DdownloadSources=true -DdownloadJavadocs=true
	goto mvn_end
	
:mvn_install_not_test
	cd %PROJECT_HOME%\all
	ECHO 当前路径为%cd%
	echo 开始编译打包,但不执行测试
	call mvn clean install -DskipTests=true
	goto mvn_end
	
:mvn_install_not_test_unzip_war
	cd %PROJECT_HOME%\all
	ECHO 当前路径为%cd%
	echo 开始编译打包(解压war包),但不执行测试
	call mvn clean install -DskipTests=true -Dunzip.war=true
	goto mvn_end

:mvn_install_with_test
	cd %PROJECT_HOME%\all
	ECHO 当前路径为%cd%
	echo 开始编译打包,并且执行测试
	call mvn clean install
	goto mvn_end

:mvn_install_with_test_unzip_war
	cd %PROJECT_HOME%\all
	ECHO 当前路径为%cd%
	echo 开始编译打包(解压war包),并且执行测试
	call mvn clean install -Dunzip.war=true
	goto mvn_end

:mvn_all_test
	cd %PROJECT_HOME%\all
	echo 开始执行整个工程的测试
	call mvn clean test
	goto mvn_end
	
:mvn_project_test
	cd %PROJECT_HOME%
	echo 当前路径为%cd%
	echo 应用根目录为%PROJECT_HOME%
	set /p subprj=【输入项目路径，如biz\service】
	if /i "%subprj%"=="" goto mvn_project_test
	if not exist "%PROJECT_HOME%\%subprj%" ECHO 找不到路径%PROJECT_HOME%\%subprj%
	if not exist "%PROJECT_HOME%\%subprj%" goto mvn_project_test
	cd %PROJECT_HOME%\%subprj%
	echo 项目完整路径为%PROJECT_HOME%\%subprj%
	echo 开始执行单个项目的测试
	call mvn clean test
	goto mvn_end
	
:mvn_end
cd %PROJECT_HOME%
pause
goto mvn_command

:exit
cd %PROJECT_HOME%