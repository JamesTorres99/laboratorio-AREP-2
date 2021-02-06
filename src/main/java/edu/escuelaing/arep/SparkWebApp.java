package edu.escuelaing.arep;

import static spark.Spark.*;
import edu.escuelaing.arep.Calculadora;

/**
 * 
 * @author Alexander Torres
 *
 */
public class SparkWebApp {

	public static void main(String[] args) {
		port(getPort());
		get("/hello", (req, res) -> "Hello World");
		
	}	
	
	
	
	
	
	
	
	
	static int getPort() {
		if (System.getenv("PORT") != null) {
		return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
		}
	
}