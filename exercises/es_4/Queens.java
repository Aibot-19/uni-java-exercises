
/*
 * Rompicapo delle "n regine"
 *
 * Ultimo aggiornamento: 12/04/2018
 *
 *
 * Dato astratto "configurazione della scacchiera":  Board
 *
 * Operazioni:
 *
 *   new Board( int n )           :  costruttore (scacchiera vuota)
 *
 *   size()                       :  int
 *
 *   queensOn()                   :  int
 *
 *   underAttack( int i, int j )  :  boolean
 *
 *   addQueen( int i, int j )     :  Board
 *
 *   arrangement()                :  String
 *
 *
 * Board b;
 *
 *   new Board(n)           costruttore della scacchiera n x n vuota;
 *   b.size()               dimensione n della scacchiera b;
 *   b.queensOn()           numero di regine collocate nella scacchiera b;
 *   b.underAttack(i,j)     la posizione <i,j> e' minacciata?
 *   b.addQueen(i,j)        scacchiera che si ottiene dalla configurazione b
 *                          aggiungendo una nuova regina in posizione <i,j>
 *                          (si assume che la posizione non sia minacciata);
 *   b.arrangement() :      descrizione "esterna" della configurazione
 *                          (convenzioni scacchistiche).
 */
import queens.*; 

public class Queens {
    public static final SList<Board> NULL_BOARDLIST = new SList<Board>();

    /*
     * I. Numero di soluzioni:
     *
     *
     * Il numero di modi diversi in cui si possono disporre n regine
     *
     *   numberOfSolutions( n )
     *
     * in una scacchiera n x n e' dato dal numero di modi diversi in
     * cui si puo' completare la disposizione delle regine a partire
     * da una scacchiera n x n inizialmente vuota
     *
     *   numberOfCompletions( new Board(n) )
     */

    public static int numberOfSolutions( int n ) {

        return numberOfCompletions( new Board(n) );
    }

    /*
     * Il numero di modi in cui si puo' completare la disposizione
     * a partire da una scacchiera b parzialmente configurata
     *
     *   numberOfCompletions( b )   : int
     *
     * dove k regine (0 <= k < n) sono collocate nelle prime k righe
     * di b, si puo' determinare a partire dalle configurazioni
     * che si ottengono aggiungendo una regina nella riga k+1 in tutti
     * i modi possibili (nelle posizioni che non sono gia' minacciate)
     *
     *   for ( int j=1; j<=n; j=j+1 ) {
     *     if ( !b.underAttack(i,j) ) { ... b.addQueen(i,j) ... }
     *   }
     *
     * calcolando ricorsivamente per ciascuna di queste il numero
     * di modi in cui si puo' completare la disposizione
     *
     *   numberOfCompletions( b.addQueen(i,j) )
     *
     * e sommando i valori che ne risultano
     *
     *   count = count + numberOfCompletions( ... )
     *
     * Se invece la scacchiera rappresenta una soluzione (q == n)
     * c'e' un solo modo (banale) di completare la disposizione:
     * lasciare le cose come stanno!
     */

    private static int numberOfCompletions( Board b ) {

        int n = b.size();
        int q = b.queensOn();

        if ( q == n ) {

            return 1;

        } else {

            int i = q + 1;
            int count = 0;

            for ( int j=1; j<=n; j=j+1 ) {
                if ( !b.underAttack(i,j) ) {

                    count = count + numberOfCompletions( b.addQueen(i,j) );
                }}
            return count;
        }
    }
//metodo statico per creare la lista di tutte le soluzioni di una scacchiera nxn.
    public static SList<Board> listOfAllSolutions( int n ) {
//ritorna la funzione che crea la lista di tutte le possibili solzuioni
        return listOfAllCompletions( new Board(n) );
    }
//metodo per creare tutte le soluzioni in una lista di board
    private static SList<Board> listOfAllCompletions( Board b ) {

        int n = b.size();
        int q = b.queensOn();

        if ( q == n ) {
            // se il numero di regine è uguale ad n allora è una soluzione quindi creo la lista contente b
            // si potrebbe ritornare anche semplicemente b e al posto dell'append fare il cons
            return ( NULL_BOARDLIST.cons(b) );

        } else {

            int i = q + 1;
            SList<Board> solutions = NULL_BOARDLIST;

            for ( int j=1; j<=n; j=j+1 ) {
                if ( !b.underAttack(i,j) ) {
                    //continuo la ricorsione fino a quando listOfAllCompletions(b.addQueen(i,j)) non restituisce una b completa
                    //essendo in un for ci sono tanti rami ricorsivi quanti i cicli del for e ognuno di essi avrà un j aumentato di uno
                    solutions = solutions.append( listOfAllCompletions(b.addQueen(i,j)) );
                }}
            return solutions;
        }
    }
    //metodo statico per usare la GUI grafica
    public static void view(int n){
        //creo la lista con tutte le b complete di dim nxn
        SList<Board> list = listOfAllSolutions(n);
        //creo una scacchiera nxn
        ChessboardView gui = new ChessboardView( n );
        //fin tanto che la lista con tutte le soluzioni non è nulla allora il ciclo si mantiene
        while (!list.isNull()){
        //il metodo setQueens prende l'arrangement cioè la stringa delle posizioni di ciascuna regina e setta le regine nelle GUI
        gui.setQueens( list.car().arrangement() );
        //se clicco il codice va avanti cioè esegue le linee di codice successive, sennò la chessboard aspetta fino al click del mouse
        //proseguo con il resto della lista
        list = list.cdr();
    }
}
        
        



}  // class Queens
