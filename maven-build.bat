@echo off

:input_project_home
SET PROJECT_HOME=
SET /p PROJECT_HOME=������Ӧ�ø�Ŀ¼��Ĭ��Ϊ%cd%��
if /i "%PROJECT_HOME%"=="" SET PROJECT_HOME=%cd%
if not exist "%PROJECT_HOME%" ECHO �Ҳ���·��%PROJECT_HOME%
if not exist "%PROJECT_HOME%" goto input_project_home
cd /d %PROJECT_HOME%
ECHO Ӧ�ø�Ŀ¼Ϊ%PROJECT_HOME%

:mvn_command
ECHO ************************
ECHO ��ѡ����Ҫִ�еĳ�������(ע��:��ִ�в��Ե����ǻ��������ļ��Ͳ�����Դ�ļ�)
ECHO ************************
ECHO 1-����eclipse�����ļ�(ע��:����޷�����ͨ��,����ִ��ѡ��3����4)
ECHO 2-������,��ִ�в���
ECHO 3-������(��ѹwar��),��ִ�в���
ECHO 4-������,��ִ�в���
ECHO 5-������(��ѹwar��),��ִ�в���
ECHO 6-ִ���������̵Ĳ���
ECHO 7-ִ�е�����Ŀ�Ĳ���
ECHO 0-�˳��˵�
set isopt=
set /p isopt=��ѡ�����
if /i "%isopt%"=="1" goto mvn_eclipse
if /i "%isopt%"=="2" goto mvn_install_not_test
if /i "%isopt%"=="3" goto mvn_install_not_test_unzip_war
if /i "%isopt%"=="4" goto mvn_install_with_test
if /i "%isopt%"=="5" goto mvn_install_with_test_unzip_war
if /i "%isopt%"=="6" goto mvn_all_test
if /i "%isopt%"=="7" goto mvn_project_test
if /i "%isopt%"=="0" goto exit

echo "��Чѡ���ѡ��(0-7)"
goto mvn_command

:mvn_eclipse
	cd %PROJECT_HOME%\all
	echo ��ʼ����eclipse�����ļ�
	call mvn eclipse:eclipse -DdownloadSources=true -DdownloadJavadocs=true
	goto mvn_end
	
:mvn_install_not_test
	cd %PROJECT_HOME%\all
	ECHO ��ǰ·��Ϊ%cd%
	echo ��ʼ������,����ִ�в���
	call mvn clean install -DskipTests=true
	goto mvn_end
	
:mvn_install_not_test_unzip_war
	cd %PROJECT_HOME%\all
	ECHO ��ǰ·��Ϊ%cd%
	echo ��ʼ������(��ѹwar��),����ִ�в���
	call mvn clean install -DskipTests=true -Dunzip.war=true
	goto mvn_end

:mvn_install_with_test
	cd %PROJECT_HOME%\all
	ECHO ��ǰ·��Ϊ%cd%
	echo ��ʼ������,����ִ�в���
	call mvn clean install
	goto mvn_end

:mvn_install_with_test_unzip_war
	cd %PROJECT_HOME%\all
	ECHO ��ǰ·��Ϊ%cd%
	echo ��ʼ������(��ѹwar��),����ִ�в���
	call mvn clean install -Dunzip.war=true
	goto mvn_end

:mvn_all_test
	cd %PROJECT_HOME%\all
	echo ��ʼִ���������̵Ĳ���
	call mvn clean test
	goto mvn_end
	
:mvn_project_test
	cd %PROJECT_HOME%
	echo ��ǰ·��Ϊ%cd%
	echo Ӧ�ø�Ŀ¼Ϊ%PROJECT_HOME%
	set /p subprj=��������Ŀ·������biz\service��
	if /i "%subprj%"=="" goto mvn_project_test
	if not exist "%PROJECT_HOME%\%subprj%" ECHO �Ҳ���·��%PROJECT_HOME%\%subprj%
	if not exist "%PROJECT_HOME%\%subprj%" goto mvn_project_test
	cd %PROJECT_HOME%\%subprj%
	echo ��Ŀ����·��Ϊ%PROJECT_HOME%\%subprj%
	echo ��ʼִ�е�����Ŀ�Ĳ���
	call mvn clean test
	goto mvn_end
	
:mvn_end
cd %PROJECT_HOME%
pause
goto mvn_command

:exit
cd %PROJECT_HOME%