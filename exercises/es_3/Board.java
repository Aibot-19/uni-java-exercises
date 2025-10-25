
/**
 * 
 * Board b;
 * int n;
 * 
 * 
 * b = new Board(n);
 * 
 * b.size() = dimensione scacchiera, int
 * b.queensOn = n di regine disposte, int
 * 
 * b.underAttack(i, j) = boolean, se è sotto attacco true
 * 
 * b.addQueen(i, j) = aggiunge una regina nelle coordinate indicate, tipo Board
 * 
 * b.arrangement() = l'insieme delle coordinate di una soluzione, tipo String
 */
import java.util.function.*;

public class Board{
    private static final String ROWS = " 123456789ABCDEF";
    private static final String COLS = " abcdefghijklmno";
    private final int n;
    private final int q;
    //  private final BiPredicate<Integer, Integer> attack;
    private final String config;
    private final IntSList rows;
    private final IntSList cols;
    private final IntSList diagAsc;
    private final IntSList diagDisc;

    public Board(int n){
        this.n = n; //sono due n diversi, quella sinistra è la variabile d'istanza quella a dx è il parametro
        q = 0;
        // attack = (x, y) -> false; // qualsiasi casella io gli metta dentro ovviamente non è minacciata == false.
        config = " ";
        rows = IntSList.NULL_INTLIST;
        cols = IntSList.NULL_INTLIST;
        diagAsc = IntSList.NULL_INTLIST;
        diagDisc = IntSList.NULL_INTLIST;
    }
    //costruttore privato utilizzato nel metodo addQueen
    //costruisce una nuova Board con una nuova regina posizionata nella casella di indici i e j
    //aggiunge a tutte le liste gli indici combinati rispettando la consegna
    private Board(int i, int j, Board b){
        n = b.size();
        q = b.queensOn() + 1;
        // attack = (x, y) -> ( (x == i) || (y == j) || (x-y == i-j) || (x+y == i+j) || b.underAttack(x,y) );
        config = b.arrangement() + COLS.substring(j, j+1) + ROWS.substring(i, i+1) + " ";
        rows = b.rows.cons(i);
        cols = b.cols.cons(j);
        //codifica per diagonale ascendente
        diagAsc = b.diagAsc.cons(i-j);
        //codifica per diagonale discendente
        diagDisc = b.diagDisc.cons(i+j); 
    }

    public int size(){
        return n;
    }

    public int queensOn(){
        return q;
    }

    public IntSList rows(){
        return rows;
    }

    public IntSList cols(){
        return cols;
    }

    public IntSList diagAsc(){
        return diagAsc;
    }

    public IntSList diagDisc(){
        return diagDisc;
    }
 //procedura che serve per controllare se la casella di indice i e j è sotto attacco.
    public boolean underAttack(int i, int j){
        return checkLists(i, j , rows, cols, diagAsc, diagDisc);
    }
//------------Procedura per controllare le liste contenenti gli indici---------
    private boolean checkLists(int i, int j, IntSList r, IntSList c, IntSList a, IntSList d){
        //se la prima lista è nulla allora l'indice non era presente in tale lista
        //indifferente quale lista controlliamo tanto hanno tutte la stessa lunghezza quindi se r è vuota lo saranno tutte
        if(r.isNull()){  
            return false;
        }
        //controllo dei vari indici se è presente allora return true che è il risultato di underAttack, la cella di indice i e j è sotto attacco
        if(r.car() == i || c.car() == j || a.car() == (i - j) || d.car() == (i + j)){
            return true;
        //se non l'ha trovato allora bisogna procedere e controllare tutta la lista
        }else{
            return checkLists(i, j, r.cdr(), c.cdr(), a.cdr(), d.cdr());
        }
    }

    public Board addQueen(int i, int j){
        return new Board(i, j, this);
    }

    public String arrangement(){
        return config;
    }

    public String toString(){
        return "[" + arrangement() + "]";
    }

    
    
    
    
}
