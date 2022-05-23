package src.giocatori;
//prova comit

public class Giocatore {
    String username;
    int numeroPartite;
    int punteggioMax;

    public Giocatore(){username=""; numeroPartite = 0; punteggioMax = 0; }

    public Giocatore(String username,int punteggioMax){
        this.username = username;
        this.punteggioMax = punteggioMax;
    }

    public Giocatore(String username){
        this.username = username;
        this.numeroPartite = 0;
        this.punteggioMax = 0;
    }

    public String getUsername(){return this.username;}
    public int getPunteggioMax(){return this.punteggioMax;}
    
    public void addPartite(){this.numeroPartite = numeroPartite + 1;}
    
    public void setUsername(String username){this.username = username;}
    public void setNewMax(int max){this.punteggioMax = max;}

    public void info(){System.out.println("Player name : " + this.username + " Con un record di -> " + this.punteggioMax);}

    

}
