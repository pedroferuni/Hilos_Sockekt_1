import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;


public class PracticaSocketsHiloServ implements Runnable{
	private Socket clienteSocket;
	public PracticaSocketsHiloServ(Socket clientSocket)
	{
	this.clienteSocket=clientSocket;	
	}

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		try {
				ServerSocket listenerserv = new ServerSocket(9999);	
				System.out.println("servidor chat iniciado");
			
			int i=0;
				while(true)
				{	
			
					Socket clientSocket2 = listenerserv.accept();
					System.out.println("Cliente conectado desde"+ clientSocket2.getInetAddress());
					i++;
					new Thread(new PracticaSocketsHiloServ(clientSocket2),"Cliente" + i).start();
				}
				
					
		 }
		catch(IOException e)
		{
			
			e.printStackTrace();
		}
	

 }

	@Override
	public void run() {
		String InputLine;
		// TODO Auto-generated method stub
		try {
			PrintWriter outserver = new PrintWriter(clienteSocket.getOutputStream(), true);
			BufferedReader inServer = new BufferedReader (new InputStreamReader(clienteSocket.getInputStream()));			
		
			while((InputLine =inServer.readLine()) != null) 
			{
			
     		if  (InputLine.equals("H")) 
		        {
					  
					outserver.println("La historia​ es la narración de los sucesos del pasado generalmente los de la humanidad,aunque,también puede no estar centrada en el humano.Hay quien más breve y concisamente afirma que la historia es el conocimiento del pasado humano.​ Asimismo, es una disciplina académica que estudia dichos acontecimientos.");
		  
		        }
				else if  (InputLine.equals("G")) 
		        {
					 outserver.println("La geografía es la ciencia que estudia las relaciones entre la sociedad y el espacio, pero a diferencia de otras disciplinas, la geografía parte de una visión integral desde diferentes campos, empezando por la enseñanza, en donde se requiere dar interpretaciones globales sobre el mundo.");
					
		        }
				else if  (InputLine.equals("Z")) 
		        {
					outserver.println("La zoología es la rama, dentro de la biología, que se encarga del estudio de los animales. Algunos de los aspectos que aborda la zoología tienen que ver con: La distribución y el comportamiento de los animales. Las descripciones anatómicas y morfológicas de cada especie.");
					
		        }
				else if (InputLine.equals("B")) 
		        {
					      outserver.println("La biología es la ciencia que trata de los seres vivos considerando su estructura, funcionamiento, evolución, distribución y relaciones");
		        }
				else if  (InputLine.equals("A")) 
		        {
					  outserver.println("La antropología es el estudio de la humanidad, de los pueblos antiguos y modernos y de sus estilos de vida. Dada la amplitud y complejidad del tema, las diferentes ramas de la antropología se centran en distintos aspectos o dimensiones de la experiencia humana..");
		        }				
				else if  (InputLine.equals("q")) 
		        {
      	        outserver.println("close");
		        clienteSocket.close(); 	 
		        break;
		        }
		        else 
		        {
		        outserver.println("No has introducido ningun tema correcto para poder hablarte sobre el");	
		        }
		    	
			
			}     
		}catch(IOException e)
		{
				
			e.printStackTrace();
		}
		
	}
}

