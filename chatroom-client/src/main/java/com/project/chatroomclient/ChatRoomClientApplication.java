package com.project.chatroomclient;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class ChatRoomClientApplication {

	//private static  Logger logger = LogManager.getLogger(ChatRoomClientApplication.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		logger.info("Info message");
//		logger.warning("warning message");
		SpringApplication.run(ChatRoomClientApplication.class, args);
		//logger.info("Client started");
	}

}
