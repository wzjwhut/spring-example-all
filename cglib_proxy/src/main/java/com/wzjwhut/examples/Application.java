package com.wzjwhut.examples;

import lombok.extern.log4j.Log4j2;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Log4j2  //lombok自动生成log4j2的log对象
public class Application {

    public static class MyClass {

        public String hello(String name){
            log.info("[cglib] hello");
            return "hello " + name;
        }
    }

    public interface MyInterface{
        String doHello(String name);

         String hello(String name);
    }

    public static void main(String[] args){

        {   //使用cglib的动态代理
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MyClass.class);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    log.info("before..., method: {}", method);
                    Object object = proxy.invokeSuper(obj, args);
                    log.info("after...");
                    return object;
                }
            });
            MyClass proxy = (MyClass) enhancer.create();
            String ret = proxy.hello("wzj");
            log.info("ret: {}", ret);
        }

        {
            //使用jdk的动态代理
            MyInterface proxy = (MyInterface) Proxy.newProxyInstance(Application.class.getClassLoader(),
                    new Class[]{MyInterface.class}, new InvocationHandler(){
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            log.info("[jdk proxy] invoke, args: {}", args);
                            log.info("[jdk proxy] invoke, method: {}", method);
                            log.info("[jdk proxy] isDefault: {}", method.isDefault());
                            return "hello " + args[0];
                        }
                    });
            String ret = proxy.hello("wzj");
            log.info("ret: {}", ret);
        }
    }
}