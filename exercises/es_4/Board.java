
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
    //lista di liste dove le liste "atomiche" sono rappresentative delle coordinate i j di tutte le caselle occupate dalle regine
    private final SList<SList<Integer>> coordinates;
    
    public Board(int n){
        this.n = n; //sono due n diversi, quella sinistra è la variabile d'istanza quella a dx è il parametro
        q = 0;
        config = " ";
        coordinates = new SList<SList<Integer>>();
    }
    
    private Board(int i, int j, Board b){
        n = b.size();
        q = b.queensOn() + 1;
        config = b.arrangement() + COLS.substring(j, j+1) + ROWS.substring(i, i+1) + " ";
        //aggiungo le nuove coordinate alla lista di liste prima inserisco j e dopo i così da avere l'ordine corretto.
        coordinates = b.coordinates().cons(new SList<Integer>().cons(j).cons(i));
    }
    public int size(){
        return n;
    }
    public int queensOn(){
        return q;
    }
    public SList<SList<Integer>> coordinates(){
        return coordinates;
    }
    
    public boolean underAttack(int i, int j){
       return checkLists(i, j, this.coordinates);
}
//------------Procedura per controllare le liste contenenti gli indici---------
    private boolean checkLists(int i, int j, SList<SList<Integer>> c){
        //se la lista di coordinate è vuota allora significa che la casella rappresentata dagli indici i e j non è sotto attacco
        if(c.isNull()){ 
            return false;
        }
        //l'indice i è rappresentato dal primo elemento di una lista "atomica"
        int x = c.car().car();
        //l'indice j è rappresentato dal primo elemento del resto di una lista atomica
        int y = c.car().cdr().car();
        //stesse condizioni per singoli indici e diagonali disc. e asc.
        if(x == i || y == j || x-y == (i - j) || x+y == (i + j)){
            return true;
        }else{
           return checkLists(i, j, c.cdr());
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
