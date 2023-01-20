package com.tns.springaw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Body {

	public static void main(String[] args) 
	{
        ApplicationContext Ac= new ClassPathXmlApplicationContext("Beans.xml");
        Human human = Ac.getBean("human",Human.class);
        human.startPumping();
	}

}
