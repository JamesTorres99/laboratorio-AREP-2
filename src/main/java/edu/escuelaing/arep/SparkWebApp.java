package edu.escuelaing.arep;

import static spark.Spark.*;
import spark.Request;
import spark.Response;
import edu.escuelaing.arep.Linkedlist;
import edu.escuelaing.arep.Calculadora;

/**
 * 
 * @author Alexander Torres
 *
 */
public class SparkWebApp {

	
	public static void main(String[] args) {
		port(getPort());
		//staticFiles.location("/public");
		
		get("/hello", (req, res) -> {
			 
			//res.redirect("/calculadora.html");
			String paginaInicial
             = "<!DOCTYPE html>"
             + "<html>"
             + "<h:head>"
             + "<style>"
             + "body {background-color: LightSteelBlue;}"
             + "h1   {color: blue;}"
             + "p    {color: White;}"
             + "</style>"
             + "</h:head>"
             + "<body>"
             + "<div class=\"center\">"
             + "<h1><p align=\"center\" style=\"font-size:40px;\">Calculadora Estadistica</p></h1>"
             + "<h3> <p align=\"center\">James Alexander Torres</p></h3>"
             + "<center><img src=\"https://media.tenor.com/images/de2a9b7bb8147c9c93a0d4e474550fbe/tenor.gif\" alt=\"programing\" align=\"middle\" style=\"width:120px;height:100px;\"></img></center>"
             + "</div>"
             + "<h3> <p align=\"center\"></p></h3>"
             + "<h3 style=\"	color:black;text-align:center\">Datos de la muestra ( separados por coma (,) )</h3>"
             + "<br>"
             + "<form action=\"/final\">"
             + "<center><input align=\"middle\" id=\"datos\" placeholder=\"Ingrese los valores\" name=\"numero\" value=\"\" /></center>"
             + "<br>"
             + "<center><input align=\"middle\" type=\"submit\" align=\"center\" style=\"background-color: #3CBC8D\" update=\"calculadora_form\" onclick=\"\"></input></center>"
             + "</form>"
             + "<br><br>"   
             + "<img src=\"https://concepto.de/wp-content/uploads/2018/08/Estadistica-inferencial-min-e1533841684477.jpg\" alt=\"Trulli\" width=\"49%\" height=\"170\"></img>"
             + "<img src=\"https://developingthebusiness.com/wp-content/uploads/2018/05/Estadisticas-de-ventas.jpg\" alt=\"Trulli\" width=\"50%\" height=\"170\"></img>"
             + "</body>"
             + "</html>";
			
			return paginaInicial;});
		
		get("/final", (req, res) -> {
			Calculadora calculadora = new Calculadora();
			Linkedlist<Double> lista= new Linkedlist<Double>();
			String[] listaa = req.queryParams("numero").split(",");
			for(int i=0;i<listaa.length;i++){
	            lista.addini(Double.parseDouble(listaa[i]));
	        }
			String paginaFinal
             = "<!DOCTYPE html>"
             + "<html>"
             + "<h:head>"
             + "<style>"
             + "body {background-color: LightSteelBlue;}"
             + "h1   {color: blue;}"
             + "p    {color: White;}"
             + "</style>"
             + "</h:head>"
             + "<body>"
             + "<div class=\"center\">"
             + "<h1><p align=\"center\" style=\"font-size:40px;\">Calculadora Estadistica</p></h1>"
             + "<h3> <p align=\"center\">James Alexander Torres</p></h3>"
             + "<center><img src=\"https://media.tenor.com/images/de2a9b7bb8147c9c93a0d4e474550fbe/tenor.gif\" alt=\"programing\" align=\"middle\" style=\"width:120px;height:100px;\"></img></center>"
             + "</div>"
             + "<h3> <p align=\"center\"></p></h3>"
             + "<h3 style=\"	color:black;text-align:center\">Resultado</h3>"
             + "<br>"
             + "<h3> <p align=\"center\">Mean: "+calculadora.mean(lista)+"</p></h3>"
             + "<br>"
             + "<h3> <p align=\"center\">Std. Dev: "+calculadora.standarD(lista)+"</p></h3>"
             + "<br><br>"   
             + "<img src=\"https://concepto.de/wp-content/uploads/2018/08/Estadistica-inferencial-min-e1533841684477.jpg\" alt=\"Trulli\" width=\"49%\" height=\"170\"></img>"
             + "<img src=\"https://developingthebusiness.com/wp-content/uploads/2018/05/Estadisticas-de-ventas.jpg\" alt=\"Trulli\" width=\"50%\" height=\"170\"></img>"
             + "</body>"
             + "</html>";
			
			return paginaFinal;});
	}
	
	
			
	static int getPort() {
		if (System.getenv("PORT") != null) {
		return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
		}
	
}