package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o caminho completo para o arquivo de saida: ");
		String path = sc.nextLine();
		File sourceFile = new File(path);
		
		String outputFolderStr = sourceFile.getParent();
		File outputFolder = new File(outputFolderStr);
		
		if(!outputFolder.exists()) {
			outputFolder.mkdir();
		}
		
		System.out.print("Digite a mensagem que deseja salvar: ");
		String message = sc.nextLine();
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
			
			bw.write(message);
			bw.newLine();
			
			System.out.println("Mensagem salva com sucesso em: " + path);
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			sc.close();
		}

	}

}
