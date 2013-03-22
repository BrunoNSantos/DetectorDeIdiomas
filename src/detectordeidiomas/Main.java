package detectordeidiomas;

import java.io.IOException;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

            Leitor leitor = new Leitor("texto.txt");
            Detector detector = new Detector();
            detector.treinamento(leitor.lerArquivo());
	}

}
