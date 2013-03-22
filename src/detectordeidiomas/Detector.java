/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package detectordeidiomas;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bruno
 */
public class Detector {
    
    Map<String, String> unigramas = new HashMap<>();
    
    

    public Detector() {
    }
    
    public void treinamento(List<String> letras){
        int contadorUnigramas = letras.size();
        double probabilidadeUnigrama;
        //Atribuindo a chava ao HashMap
        for (String letra : letras) {
            if(!unigramas.containsKey(letra)){
                unigramas.put(letra, "");
            }
        }
        
        //Atribuindo valor ao HashMap
	for (Map.Entry<String, String> entry : unigramas.entrySet()) {
            int contador = 0;
            for (String letra : letras) {
                if(letra.equals(entry.getKey())){
                    contador++;
                }
            }
            entry.setValue(String.valueOf(contador));
	}
        
        //Imprimindo Chaves e Valores(Teste)
	for (Map.Entry<String, String> entry : unigramas.entrySet()) {
                probabilidadeUnigrama = (Double.parseDouble(entry.getValue()) / contadorUnigramas);
		System.out.println("Chave : " + entry.getKey() + "| Valor : "+ entry.getValue()+ "| Probabilidade : "+ probabilidadeUnigrama); 
	}
    }
}
