package br.univel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.transform.stream.StreamResult;

public class Gravacao {
	
	public static void main(String[]args){
		
		Cliente c = new Cliente();
		c.setId(1);
		c.setNome("Pontin");
		
		StringWriter out = new StringWriter();
		JAXBContext context = null;
		
		try{
			context = JAXBContext.newInstance(c.getClass());
			Marshaller marhaller = context.createMarshaller();
			marhaller.setProperty(
					javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT,
					Boolean.TRUE
			);
			marhaller.marshal(c, new StreamResult(out));
		}catch(PropertyException e){
			e.printStackTrace();
		}catch(JAXBException e){
		e.printStackTrace();
		}
		System.out.println("Executo");
	}
}