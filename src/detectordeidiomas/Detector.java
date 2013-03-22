/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package detectordeidiomas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Bruno
 */
public class Detector {
    
    Map<String, String> unigramas = new HashMap<>();
    List<Double> probabilidades = new ArrayList<Double>();
    
    

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
            double contador = 0;
            for (String letra : letras) {
                if(letra.equals(entry.getKey())){
                    contador++;
                }
            }
            probabilidadeUnigrama = contador / contadorUnigramas;
            probabilidades.add(probabilidadeUnigrama);
            entry.setValue(String.valueOf(probabilidadeUnigrama));
	}
        
    //Imprimindo Chaves e Valores(Teste)
	Map<String, String> treemap = new TreeMap<String, String>(unigramas);
	for (Map.Entry<String, String> entry : treemap.entrySet()) {
		
		//System.out.println("Chave : " + entry.getKey() + "| Valor : "+ entry.getValue()); 
	}
	List<Double> probOrdenada = new ArrayList<Double>();
	Collections.sort(probabilidades);
	for (int i = probabilidades.size()-1; i >= 0; i--) {
		probOrdenada.add(probabilidades.get(i));
	}
	
	for (int i = 0; i < probabilidades.size(); i++) {
		//System.out.println(probOrdenada.get(i));
	}
	
	//Set<String> valores = (Set<String>) unigramas.values();
	
	
	List<String> chaves = new ArrayList<String>();
	for (Map.Entry<String, String> entry : treemap.entrySet()) {
		for (int i = 0; i < 10; i++) {
			if(Double.parseDouble(entry.getValue())== probOrdenada.get(i)){
				chaves.add(entry.getKey());
			}
		}
	}
	
	for (String string : chaves) {
		System.out.println(string + "\n");
	}
	
    }
}
