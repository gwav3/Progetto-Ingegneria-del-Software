package src.giocatori;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;



public class FileGiocatori {

    public ArrayList<Giocatore> elencoGiocatori = new ArrayList<>();
    File file = new File("Punteggi.txt");
    
    public FileGiocatori() throws IOException{
        if(!file.exists()){file.createNewFile();}
        inserisciUsernameRecord();
    }



    public void inserisciUsernameRecord() throws IOException{
        String[] user0_record1;
        int record_temp;
        String linea;

        try (BufferedReader leggiRiga = new BufferedReader(new FileReader("Punteggi.txt"))) {
            
            while((linea = leggiRiga.readLine()) != null){
                user0_record1 = linea.split(";");
                record_temp = Integer.parseInt(user0_record1[1]);
                Giocatore giocatore = new Giocatore(user0_record1[0], record_temp);
                elencoGiocatori.add(giocatore);
            }

        } catch (NumberFormatException e) {e.printStackTrace();}
    }

    public void printPunteggi(){
        int i = 0;
        for(Giocatore s : elencoGiocatori){
            System.out.println(s.getUsername() + " Record -> " + s.getPunteggioMax());
            i = i + 1;
        }
    }
    
    private void inserisciGiocatore(Giocatore giocatore) throws IOException{
        elencoGiocatori.add(giocatore);
        this.carica();
    }

    private void carica() throws IOException{
        int i = 0;
        try (FileWriter aggiungi = new FileWriter("Punteggi.txt")) {
            for(Giocatore s : elencoGiocatori){
                aggiungi.write(s.getUsername() + ";" + s.getPunteggioMax() + "\n");
                i = i +1;
            }
        }
        
    }
    
    public boolean giocatorePresente(Giocatore giocatore){
        long controllo = elencoGiocatori.parallelStream()
                            .filter(g -> g.getUsername().equals(giocatore.getUsername()))
                            .count();
        if(controllo >= 1 ){return true;}
        return false;
    }

    public void salvaGiocatore(Giocatore giocatore) throws IOException, InterruptedException{
        System.out.println("Salvataggio del Giocatore " + giocatore.getUsername() + " in corso...\n"); Thread.sleep (2000) ;

        if(giocatorePresente(giocatore)){
            System.out.println("\n\n**Sei gia' registrato come: **\n\n" );
            ritornaPlayer(giocatore).info();
            aggiornaPunteggio(giocatore);
            carica();
        
        }

        else {inserisciGiocatore(giocatore);}
    }

    public Giocatore ritornaPlayer(Giocatore giocatore){
        if(giocatorePresente(giocatore)){
            for(Giocatore g : elencoGiocatori){
                if(g.getUsername().equals(giocatore.getUsername())){
                    return g;
                }
            }
        }
        return null;
    }

    public void aggiornaPunteggio(Giocatore giocatore){
        if(giocatorePresente(giocatore)){
            for(Giocatore g : elencoGiocatori){
                if(g.getUsername().equals(giocatore.getUsername())){
                    if(giocatore.punteggioMax >= giocatore.punteggioMax){
                        System.out.println("\n\nSovrasrivo il punteggio...\n\n");
                        g.setNewMax(giocatore.punteggioMax);
                        return;
                    }   
                else {System.out.println("\n\nProva di nuovo per superare il tuo record!!!\n\n"); return;}
                }
            }   
        
        }
        return;
    }

}