package sg.nus.iss.sdf.workshop;

import java.util.Collections;
import java.util.List;

//import javax.swing.Spring;

import org.slf4j.LoggerFactory;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class WorkshopApplication {
	//Create logger object (one-time only)
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(WorkshopApplication.class); 

	//This is the default port-number. 
	//Should be treated as a constant (thus set to final)
	private static final String DEFAULT_PORT= "3000"; 

	public static void main(String[] args) {
	logger.info("main method has started......"); 

	//This intializes the spring app
	SpringApplication app = new SpringApplication(WorkshopApplication.class); 
	
	//read args arrat and check for "port" parameter
	DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args); 
	//Create a list of option values that have "port"
	List opsValues = appArgs.getOptionValues("port"); 
	String portNumber = null;
	//if you dont pass parameter from command line, it will be null
	//(Task 3) if port number is not in argument 
		portNumber = System.getenv("PORT"); 
		
		if(opsValues==null||opsValues.get(0) ==null){
			//read port number from envrionment variable (Part ii) 
			//part iii
			if(portNumber==null){
				portNumber=DEFAULT_PORT;
			} }
			else{
				//pass port number from CLI
				//portNumber = (String) opsValues.get(0); 
			}

			if(portNumber !=null){
				//Setting port number in the spring-boot config 
				app.setDefaultProperties(Collections.singletonMap("server.port", portNumber)); 
			}

	
	//Launch spring boot app
	app.run(args); 
	//SpringApplication.run(WorkshopApplication.class, args);

	}

}
