package br.univel;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Leitura {
	
	public static void main(String[]args){
		
		Cliente clLido;
		
		File file = new File("arquivo.dat");
		
		try(FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			
			clLido = (Cliente) ois.readObject();
			System.out.println(clLido.getId());
			System.out.println(clLido.getNome());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
