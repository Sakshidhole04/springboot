package com.tns.springol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mobile {

	public static void main(String[] args) 
	{
        ApplicationContext Ac= new ClassPathXmlApplicationContext("Beans.xml");
        System.out.println("config loaded");
//        Airtel a=(Airtel) Ac.getBean("airtel");
//        a.calling();
//        a.data();
        
//        Jio j=Ac.getBean("jio", Jio.class);
//        j.calling();
//        j.data();

        Sim s=Ac.getBean("sim",Sim.class);
        s.calling();
        s.data();
	}

}
