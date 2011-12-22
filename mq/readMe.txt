开发环境搭建
1. 安装 rabbit-mq
(1) 安装Erlang Windows Binary File.地址：http://www.erlang.org/download.html。安装成功后，设置环境变量ERLANG_HOME
(2) 进入mq模块中的rabbitmq_server-2.7.0下的sbin目录，运行命令rabbitmq-service.bat，安装成功后，查看服务器是否已
服务形式安装（service.msc），具体命令参看：http://www.rabbitmq.com/manpages.html
 
2. 安装 rabbitmqadmin.监控queue
(1) 进入mq模块中的rabbitmq_server-2.7.0下的sbin目录，运行 rabbitmq-plugins enable rabbitmq_management。插件激活后，需要
重新安装服务，依次执行命令序列：rabbitmq-service.bat stop rabbitmq-service.bat install rabbitmq-service.bat start。
(2) 访问：http://127.0.0.1:55672/mgmt/              (guest/guest)




http://repo1.maven.org/maven2/org/mortbay/jetty/jetty-maven-plugin/
http://wiki.eclipse.org/Jetty/Feature/Jetty_Maven_Plugin