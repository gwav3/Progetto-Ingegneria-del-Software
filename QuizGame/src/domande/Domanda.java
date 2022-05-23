package src.domande;
import java.util.ArrayList;


public class Domanda {
    String domanda ;
    ArrayList<String> opzioni = new ArrayList<>();
    int risposta;
    int inserito;

    Domanda(){}

    public void setDomanda(String domanda){this.domanda = domanda;}
    public void setOpzioni(String r1, String r2, String r3){opzioni.add(r1);opzioni.add(r2);opzioni.add(r3);}
    public void setRisposta(int risposta){this.risposta = risposta;}

    public int getRisposta(){return this.risposta;}

    public void printDomanda(){
        System.out.println(domanda);

        System.out.println("- " + opzioni.get(0) );
        System.out.println("- " + opzioni.get(1) );
        System.out.println("- " + opzioni.get(2) );
    }


}
