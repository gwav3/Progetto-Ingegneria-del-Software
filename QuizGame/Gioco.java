import java.io.IOException;
import java.util.Scanner;

import src.domande.*;
import src.giocatori.*;

public class Gioco {
    
    ElencoDomande elencoDomande;
    FileGiocatori fileGiocatori;
    int punteggio = 0;
    Giocatore giocatore;
    Scanner scan = new Scanner(System.in);

    Gioco(){}

    public void start() throws IOException, InterruptedException {
            giocatore = creaGiocatore();
            selezioneDifficolta();
            salvaPunteggio();
            mostraClassifica();
    }

    private Giocatore creaGiocatore(){
        System.out.println("*************************\n*    QUIZ GAME TECH     *\n*************************\n\n* Inserire un username  *\n");
        String username = scan.nextLine();
        Giocatore giocatore = new Giocatore(username);
        System.out.println("\nBenvenuto " + username);
        return giocatore;
    }

    private void salvaPunteggio() throws IOException, InterruptedException{
        System.out.println("\n\nCongrautulazioni ** "+ this.giocatore.getUsername() +" ** Hai ottenuto un punteggio di " + this.punteggio + "\n\n"); 
        this.giocatore.setNewMax(this.punteggio);
        this.fileGiocatori = new FileGiocatori();
        fileGiocatori.salvaGiocatore(this.giocatore);
    }
  
    private void selezioneDifficolta() throws IOException, InterruptedException{
        System.out.println("\n\n**************************************\nInserire un livello di Difficolta fra:\n\n- FACILE\n\n- MEDIO\n\n- DIFFICILE \n");
            String linea = scan.nextLine();
            if(linea.equalsIgnoreCase("FACILE") || linea.equalsIgnoreCase("MEDIO") || linea.equalsIgnoreCase("DIFFICLE")){
                this.elencoDomande = new ElencoDomande(linea);
                System.out.println("\nDifficolta selezionata: "+linea +"\n");
                Thread.sleep (2000) ;
                startDomande(linea);
            }
            else{
                System.out.print("Inserisci correttamente il livello di Difficolta\n\n");
                selezioneDifficolta();
                Thread.sleep (1000) ;
            }
        
    }

    private void startDomande(String difficolta) throws IOException, InterruptedException {
            this.elencoDomande = new ElencoDomande(difficolta);
            for(int i = 0; i < 5; i++){
                domandaIndice(i);
                risposta(i);
                Thread.sleep (1000) ;
        }

    }

    private void risposta(int i) throws IOException{
            int risp = inserisciRisposta();
            if(risp == elencoDomande.domanda.get(i).getRisposta()){System.out.println("\n\n** RISPOSTA CORRETTA!! **\n\n");this.punteggio += 10;}
            else {System.out.println("\n\n** Risposta errata!! **\n\n");}
    }

    private int inserisciRisposta(){
            int risp = scan.nextInt();
            if(risp > 0 && risp <= 3){return risp;}
            else{ 
                System.out.println("!! INSERISCI UN VALORE CORRETTO !!");
                inserisciRisposta();
            }
        return 0;
    }

    private void domandaIndice(int i){
        int indiceDomanda = i+1;
        System.out.println("Domanda numero " + indiceDomanda);
        this.elencoDomande.domanda.get(i).printDomanda();
    }

    private void mostraClassifica() throws IOException{
        System.out.println("\n***ECCO TUTTI I PUNTEGGI***\n");
        this.fileGiocatori.printPunteggi();
        System.out.println("\n***************************");
    }
}

