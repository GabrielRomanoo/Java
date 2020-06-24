/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula.pkg14;

import java.util.HashMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.Map;
import java.util.Set;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Urna {
    private HashMap<Integer,Candidato> candidatos = new HashMap<Integer,Candidato>(); //Chave do tipo Integer e os valores do tipo Candidato
    private Vector<Integer> votos = new Vector<Integer>(); //no máximo 5 votos
    private Properties table;
    
    public Urna() {
        /*
        Candidato c1 = new Candidato();
        
        c1.setNome("Bozo");
        c1.setNumero(71);
        
        Candidato c2 = new Candidato();
        c2.setNome("Maldad");
        c2.setNumero(31);
        */
        /*
        candidatos.add(c1);
        candidatos.add(c2);
        */
        
        table = new Properties();
        loadProperties();
        
        Candidato c1 = new Candidato();
        c1.setNome(table.getProperty("Candidato1"));
        c1.setNumero(Integer.parseInt(table.getProperty("numero1")));
        Candidato c2 = new Candidato();
        c2.setNome(table.getProperty("Candidato2"));
        c2.setNumero(Integer.parseInt(table.getProperty("numero2")));
        
        
        candidatos.put(71, c1);
        candidatos.put(31, c2);
    }
    
    public Candidato getCandidato(int numero) throws UrnaException {
        Integer num = numero;
        if(candidatos.containsKey(num)) {
            return candidatos.get(num);
        }
        throw new UrnaException("Cadidato não encontrado!");
    }
    
    public TreeSet<Candidato> getCandidatos() {
        Set<Integer> keys = candidatos.keySet();
        TreeSet<Candidato> value = new TreeSet<Candidato>();
        for(Integer key : keys) {
            value.add(candidatos.get(key));
        }
        return value;       
    }
    
    public void inserirVoto(int numero) {
        votos.add(numero);
    }
    
    public Vector<Integer> getVotos() {
        return this.votos;
    }
    
    public TreeSet<Candidato> contabilizar() {
        TreeSet<Candidato> t = new TreeSet<Candidato>();
        int total;
        Set<Integer> keys = candidatos.keySet();
        TreeSet<Candidato> value = new TreeSet<Candidato>();
        for (Integer key : keys) {
            total = 0;
            Candidato c = candidatos.get(key);
            for(int v : votos) {
                if (c.getNumero() == v) total++;
            }
            c.setTotal(total);
            t.add(c);
        }
        //this.candidatos = t;
        return t;
    }

     // carrega propriedades de um arquivo
    public void loadProperties()  {
      // carrega conteúdo da tabela
      try  {
         FileInputStream input = new FileInputStream( "./properties/dados.properties" );
         table.load( input ); // carrega propriedades
         input.close();
         //System.out.println( "Após carregar as propriedades" );
         //listProperties(); // exibe os valores da propriedade
      } // fim do try
      catch ( IOException e )  {
         e.printStackTrace();
      } // fim do catch
    } // fim do método loadPropertie
    
}
