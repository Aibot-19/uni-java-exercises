
/**
 * IntSList: liste di interi nello stile di scheme, con tutte le sue operazioni
 * cons(e); tipo: lista l'elemnto possiamo posizionarlo all'interno delle parentesi, mentre la lista sarà l'oggetto prima del metodo (prima del .)
 * car(); tipo: intero
 * cdr(); tipo: IntSList
 * isNull; tipo: boolean
 * 
 * IntSList s, t; dichiarazione di oggetti
 * 
 * 
 * costruttore: serve per creare gli oggetti
 * new IntSList(); tipo: IntSList ci restituisce la lista senza elementi (null)
 * 
 * 
 */

public class IntSList{
    public static final IntSList NULL_INTLIST = new IntSList();
    private boolean empty;
    private int first;
    private IntSList rest;

    public IntSList() {
        empty = true;
        first = 0;
        rest = null;
    }

    public IntSList(int e, IntSList r) {
        empty = false;
        first = e;
        rest = r;
    }

    public boolean isNull(){
        return empty;
    }

    public int car(){
        return first;
    }

    public IntSList cdr(){
        return rest;
    }

    public IntSList cons(int e){
        return new IntSList(e, this);
    }

    public String toString(){
        if(isNull()){ //si dovrebbe scrivere this. ma non serve (è implicito)
            return "()";
        }else{
            String s = "("+car();
            IntSList r = cdr();
            while(!r.isNull()){
                s = s + " " + r.car();
                r = r.cdr();
            }
            return s +")";
        }

    }

    public int length(){
        int len = 0;
        IntSList r = this;
        while(!r.isNull()){
            len = len +1;
            r =r.cdr();
        }
        return len;
    }

    public IntSList append(IntSList t){
        if(isNull()){
            return t;
        }else{
            return (cdr().append(t)).cons(car()); 
        }
    }

    public IntSList reverse(){
        IntSList rev = NULL_INTLIST;
        IntSList s = this;
        while(! s.isNull()){
            rev = rev.cons(s.car());
            s = s.cdr();
        }
        return rev;
    }

    public int listRef(int n){
        IntSList r = this;
        int i = 0;
        while(i<n){
            r = r.cdr();
            i++;
        }
        return r.car();
    }

    public int listRefRec(int n) {
        if (n == 0) {
            return car();
        } else {
            return cdr().listRefRec(n - 1);
        }
    }

    
}