
//import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import src.domande.*;
import src.giocatori.*;

public class Gioco {
    
    ElencoDomande elenco;
    int punteggio = 0;
    Scanner scan = new Scanner(System.in);

    Gioco(){}

    public void start() throws IOException, InterruptedException {
            System.out.println("*************************\n*    QUIZ GAME TECH     *\n*************************\n\n* Inserire un username  *\n");
            
            
            
            String username = scan.nextLine();
            Giocatore giocatore = new Giocatore(username);

            giocatore.info();

            selezioneDifficolta();

            System.out.println("\n\nCongrautulazioni ** "+ username +" ** Hai ottenuto un punteggio di " + this.punteggio + "\n\n"); 
            giocatore.setNewMax(this.punteggio);
            FileGiocatori fileGiocatori = new FileGiocatori();
            fileGiocatori.salvaGiocatore(giocatore);

    }

    
    private void selezioneDifficolta() throws IOException, InterruptedException{
        System.out.println("\n\n\n* Inserire un livello di Difficolta fra:\n\n- FACILE\n\n- MEDIO\n\n- DIFFICILE \n");
            String linea = scan.nextLine();
            if(linea.equalsIgnoreCase("FACILE") || linea.equalsIgnoreCase("MEDIO") || linea.equalsIgnoreCase("DIFFICLE")){
                elenco = new ElencoDomande(linea);
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
            //int risp = 0;
            ElencoDomande elencoDomande = new ElencoDomande(difficolta);
            for(int i = 0; i < 5; i++){
                domandaIndice(i, elencoDomande);
                /*risp = Integer.parseInt(scan.nextLine());;
                if(risp == elencoDomande.domanda.get(i).getRisposta()){System.out.println("\n\n** RISPOSTA CORRETTA!! **\n\n");this.punteggio += 10;}
                else if(risp < 1 && risp > 3){System.out.println("\n\n** VALORE NON CORRETTO. REINSERISCI UN VALORE **\n\n");}
                else {System.out.println("\n\n** Risposta errata!! **\n\n");}
                
                Thread.sleep (2000) ; */
                risposta(elencoDomande, i);
                Thread.sleep (1000) ;
        }

    }

    public void risposta( ElencoDomande elencoDomande, int i) throws IOException{
            int risp = inserisciRisposta();
            if(risp == elencoDomande.domanda.get(i).getRisposta()){System.out.println("\n\n** RISPOSTA CORRETTA!! **\n\n");this.punteggio += 10;}
            else {System.out.println("\n\n** Risposta errata!! **\n\n");}
    }

    public int inserisciRisposta(){
            int risp = scan.nextInt();
            if(risp > 0 && risp <= 3){return risp;}
            else{ 
                System.out.println("!! INSERISCI UN VALORE CORRETTO !!");
                inserisciRisposta();
            }
        return 0;
    }

    


    private void domandaIndice(int i, ElencoDomande elenco){
        int indiceDomanda = i+1;
        System.out.println("Domanda numero " + indiceDomanda);
        elenco.domanda.get(i).printDomanda();
    }

    public static void main(String [] args) throws IOException, InterruptedException{
        Gioco gioco = new Gioco();
        gioco.start();
    }

}

