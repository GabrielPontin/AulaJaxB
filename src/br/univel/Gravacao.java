package br.univel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.transform.stream.StreamResult;

public class Gravacao {
	
	public static void main(String[]args){
		
		try{
			FileReader fr = new FileReader("arq.xml");
			BufferedReader br = new BufferedReader(fr);
			
			StringBuilder sb = new StringBuilder();
			String line = null;
			
			while((line = br.readLine())!= null){
				sb.append(line).append("\n");
		}
			
			catch(){
			
		}
		
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
		
	String xml = out.toString();
	FileWriter fw = new FileWriter("arq.xml");
	fw.write(xml);
	fw.close();
		
	}
}