import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class PracticaSocketClienteHilo{
	// TODO Auto-generated method stub
	//String serverAddress = System.console().readLine("Introduce la dirección IP del servidor de números aleatorios\n");
    public static void main(String[] args){
		// TODO Auto-generated method stub
		 try {
			   
		
			//Creamos el socket				 
			      Socket socket = new Socket("localhost", 9999);
			      System.out.println("H-Historia\nG-Geografia\nZ-Zoologia\nB-Biologia\nA-Antropologia\nq-salir");
			    while(true) {
					
				 	 String mensaje = System.console().readLine("Introduce una eleccion\n");
					//Enviar  al servidor
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
					out.println(mensaje);					
					//Recibimos la respuesta del servidor
					BufferedReader inputMensaje = new BufferedReader (new InputStreamReader(socket.getInputStream()));
					String answer = inputMensaje.readLine();

					//Verificamos la respuesta y la  y si es de salida salimos
				   if  (answer.equals("close")) 
			        {
						System.out.println("Que tenga un buen dia");
						socket.close();
						break;
			        }
					else 
					{
						System.out.println(answer);
						System.out.println("H Historia\nG Geografia\nZ Zoologia\nB Biologia\nA Antropologia\nq salir");
					}
				 }
		    }catch(IOException e)
			{
				
				e.printStackTrace();
			}
     }
}