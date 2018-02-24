package com.eureka.server.eurekaserverservicepeer2;

public class User {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    private  String name;
    private  Integer age;


    private  Integer port;

    public User(){

    }
    public User(String name, Integer age){
        this.name=name;
        this.age=age;
    }
    public  String toString(){
        return "name="+name+",age="+age;
    }
}
