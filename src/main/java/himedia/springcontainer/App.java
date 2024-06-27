package himedia.springcontainer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		//	ClassPath의 XML을 기반으로 컨텍스트 만들기
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext("config/applicationContext.xml");
		
		//	타입(Class)으로 찾기
//		User user = ac.getBean(User.class);
//		System.out.println(user);
		
		//	id와 name으로 찾기
		User user1 = (User)ac.getBean("user");	//	id 검색
		User user2 = (User)ac.getBean("member");	//	name 검색
		
		System.out.println(user1 == user2);	//	스프링 컨테이너는 기본적으로 Singleton Factory
		System.out.println(ac.isSingleton("user"));
		
		User user3 = (User)ac.getBean("user3");
		
		System.out.println(user1 == user3);
	}
}
