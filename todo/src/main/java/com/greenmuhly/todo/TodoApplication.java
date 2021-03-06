package com.greenmuhly.todo;

import com.greenmuhly.todo.domain.Todo;
import com.greenmuhly.todo.domain.TodoRepository;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}




	/**
	 * 시작할 때 데이터 입력
	 * ex) 오늘 할일1, 현재시간, 체크X
	 */
//	@Bean
//	public CommandLineRunner runner(TodoRepository todoRepository) throws  Exception {
//		return args -> {
//			IntStream.rangeClosed(1, 10).forEach(index -> todoRepository.save(Todo.builder()
//					.content("오늘 할 일" + index)
//					.createDate(LocalDateTime.now())
//					.checked(false)
//					.build())
//			);
//		};
//	}

//	@Bean
//	public ServletWebServerFactory servletContainer() {
//		// Enable SSL Traffic
//		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
//			@Override
//			protected void postProcessContext(Context context) {
//				SecurityConstraint securityConstraint = new SecurityConstraint();
//				securityConstraint.setUserConstraint("CONFIDENTIAL");
//				SecurityCollection collection = new SecurityCollection();
//				collection.addPattern("/*");
//				securityConstraint.addCollection(collection);
//				context.addConstraint(securityConstraint);
//			}
//		};
//
//		// Add HTTP to HTTPS redirect
//		tomcat.addAdditionalTomcatConnectors(httpToHttpsRedirectConnector());
//
//		return tomcat;
//	}
//
//	/*
//    We need to redirect from HTTP to HTTPS. Without SSL, this application used
//    port 8082. With SSL it will use port 8443. So, any request for 8082 needs to be
//    redirected to HTTPS on 8443.
//     */
//	private Connector httpToHttpsRedirectConnector() {
//		Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
//		connector.setScheme("http");
//		connector.setPort(8080);
//		connector.setSecure(false);
//		connector.setRedirectPort(443);
//		return connector;
//	}
}


