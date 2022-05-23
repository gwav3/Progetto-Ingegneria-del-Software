package src.domande;
import java.util.ArrayList;


public class ElencoDomande {

    public ArrayList<Domanda> domanda = new ArrayList<Domanda>();

    public ElencoDomande(String difficolta){
        if(difficolta.equalsIgnoreCase("FACILE")){domandeFacili(); return;}
		else if(difficolta.equalsIgnoreCase("MEDIO")){domandeMedie();return;}
		else if(difficolta.equalsIgnoreCase("DIFFICILE")){domandeDifficili();return;}
    }

    public void domandeFacili(){

        Domanda n1 = new Domanda();
        n1.setDomanda("\nQuale delle seguenti unità di memoria è volatile?");
        n1.setOpzioni("CPU","ROM","RAM");
        n1.setRisposta(3);
        domanda.add(n1);

        Domanda n2 = new Domanda();
        n2.setDomanda("\nA cosa corrisponde un byte?");
        n2.setOpzioni("10bit","8bit","2bit");
        n2.setRisposta(2);
        domanda.add(n2);

        Domanda n3 = new Domanda();
        n3.setDomanda("\nQuale fra questi NON è un sistema operativo?");
        n3.setOpzioni("Windows","Linux","Excelle");
        n3.setRisposta(3);
        domanda.add(n3);

        Domanda n4 = new Domanda();
        n4.setDomanda("\nQuale delle seguenti voci è un componente funzionale della CPU?");
        n4.setOpzioni("AGP","ALU","ISA");
        n4.setRisposta(2);
        domanda.add(n4);

        Domanda n5 = new Domanda();
        n5.setDomanda("\nIl linguaggio macchina è:");
        n5.setOpzioni("Un qualsiasi linguaggio usato per programmare.","Il linguaggio capito dalla CPU.","Un linguaggio di programmazione non più in uso.");
        n5.setRisposta(2);
        domanda.add(n5);
	}

    public void domandeMedie(){

        Domanda n1 = new Domanda();
        n1.setDomanda("\nQual e il nome dell'estensione di un file Excelle?");
        n1.setOpzioni(".xls",".dot",".xml");
        n1.setRisposta(1);
        domanda.add(n1);

        Domanda n2 = new Domanda();
        n2.setDomanda("\nQual e l'acronimo che indica l'interfaccia grafica");
        n2.setOpzioni("IG","LCD","GUI");
        n2.setRisposta(3);
        domanda.add(n2);

        Domanda n3 = new Domanda();
        n3.setDomanda("\nQuale tra le seguenti non e' una configurazione di rete locale?");
        n3.setOpzioni("Ad anello","A cavo dritto","A stella");
        n3.setRisposta(2);
        domanda.add(n3);

        Domanda n4 = new Domanda();
        n4.setDomanda("\nQuante informazioni distinte si possono rappresentare con 8 bit?");
        n4.setOpzioni("256","16","255");
        n4.setRisposta(1);
        domanda.add(n4);

        Domanda n5 = new Domanda();
        n5.setDomanda("\nCosa si intende per spaghetti code?");
        n5.setOpzioni("Un codice ricco di metodi e classi","Un codice complesso e/o incomprensibile.","Non esiste il termine spaghetti code");
        n5.setRisposta(2);
        domanda.add(n5);
	}

    public void domandeDifficili(){

        Domanda n1 = new Domanda();
        n1.setDomanda("In Java cosa rappresenta lo stream?");
        n1.setOpzioni("Un metodo che manda in output un oggetto","Una classe astratta","Una sequenza di elementi sui cui eseguire operazioni intermedie o terminali.");
        n1.setRisposta(3);

        Domanda n2 = new Domanda();
        n2.setDomanda("A cosa serve il Design Pattern Singleton?");
        n2.setOpzioni("Garantisce che di una determinata classe venga creata una e una sola istanza","Suddivide un frammento di codice in piu' sotto-frammenti per rendere il tutto piu' leggibile","Il Singleton non e' un Design Pattern");
        n2.setRisposta(1);

        Domanda n3 = new Domanda();
        n3.setDomanda("Quale fra questi NON è un sistema operativo?");
        n3.setOpzioni("Windows","Linux","Excelle");
        n3.setRisposta(3);

        Domanda n4 = new Domanda();
        n4.setDomanda("Quale delle seguenti voci è un componente funzionale della CPU?");
        n4.setOpzioni("AGP","ALU","ISA");
        n4.setRisposta(2);

        Domanda n5 = new Domanda();
        n5.setDomanda("Il linguaggio macchina è:");
        n5.setOpzioni("Un qualsiasi linguaggio usato per programmare.","Il linguaggio capito dalla CPU.","Un linguaggio di programmazione non più in uso.");
        n5.setRisposta(2);
	}


}
