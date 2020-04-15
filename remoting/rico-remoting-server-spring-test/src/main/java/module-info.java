module dev.rico.remoting.server.spring.test {

    exports dev.rico.server.remoting.test;

    requires transitive dev.rico.remoting.server.spring;
    requires transitive dev.rico.remoting.client;

    requires org.apiguardian.api;
    requires spring.beans;
    requires spring.context;
    requires spring.web;
    requires spring.test;
    requires spring.boot.test;
    requires java.servlet;
    requires testng;
    requires junit;
}