package es.joaquinjimenez.Lectura.utils;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


import es.joaquinjimenez.Lectura.conexion.ServerConnection;

@XmlRootElement(name="servers")
public class WrapperForXML {
	@XmlElement(name="server")
	
	
		
	
	
public static void saveFile(ServerConnection sc) {
		
		try {
			JAXBContext j=JAXBContext.newInstance(ServerConnection.class);
			Marshaller m=j.createMarshaller();
			m.setProperty(m.JAXB_FORMATTED_OUTPUT,true);
			m.marshal(sc,new File("servers.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	public static void loadFile(ServerConnection sc) {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(ServerConnection.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		     
		    //We had written this file in marshalling example
		    ServerConnection newServer = (ServerConnection) jaxbUnmarshaller.unmarshal(new File( "servers.xml" ));
		    
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}