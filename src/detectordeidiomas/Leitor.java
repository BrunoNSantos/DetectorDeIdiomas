package detectordeidiomas;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Leitor {

	
	private File arquivo;
	int [] quantidades;
	HashMap<String, Integer> mapLetras;
	
	
	public Leitor(String arquivo){
		this.arquivo = new File(arquivo);
	}
	
	public List<String> lerArquivo(){
		
		List<String> letras = new ArrayList<>();
		
		
		try {
			FileInputStream inputStream = new FileInputStream(this.arquivo);
			InputStreamReader reader = new InputStreamReader(inputStream);
			BufferedReader buffer = new BufferedReader(reader);
			String linha = "";
			
			while(buffer.ready()){
				linha = buffer.readLine();
				linha = linha.replace(" ", "").replace(",", "");
				for (int i = 0; i < linha.length(); i++) {
					letras.add(i, linha.substring(i, i+1));
				}
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		} catch(IOException ex){
		}
                return letras;
	}

}
