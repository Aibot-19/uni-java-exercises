

public class StringSList{
    public static final StringSList NULL_STRLIST = new StringSList();
    private boolean empty;
    private String first;
    private StringSList rest;

    public StringSList() {
        empty = true;
        first = "";
        rest = null;
    }
 
    public StringSList(String e, StringSList r) {
        empty = false;
        first = e;
        rest = r;
    }

    public boolean isNull(){
        return empty;
    }

    public String car(){
        return first;
    }

    public StringSList cdr(){
        return rest;
    }

    public StringSList cons(String e){
        return new StringSList(e, this);
    }

    public String toString(){
        if(isNull()){ //si dovrebbe scrivere this. ma non serve (è implicito)
            return "()";
        }else{
            String s = "("+car();
            StringSList r = cdr();
            while(!r.isNull()){
                s = s + " " + r.car();
                r = r.cdr();
            }
            return s +")";
        }

    }

    public int length(){
        int len = 0;
        StringSList r = this;
        while(!r.isNull()){
            len = len +1;
            r = r.cdr();
        }
        return len;
    }

    public StringSList append(StringSList t){
        if(isNull()){
            return t;
        }else{
            return (cdr().append(t)).cons(car()); 
        }
    }

    public StringSList reverse(){
        StringSList rev = NULL_STRLIST;
        StringSList s = this;
        while(! s.isNull()){
            rev = rev.cons(s.car());
            s = s.cdr();
        }
        return rev;
    }

    public String listRef(int n){
        StringSList r = this;
        int i = 0;
        while(i<n){
            r = r.cdr();
            i++;
        }
        return r.car();
    }

    public String listRefRec(int n) {
        if (n == 0) {
            return car();
        } else {
            return cdr().listRefRec(n - 1);
        }
    }
    public boolean equals(StringSList sl){
        StringSList list = this;
        if(list == StringSList.NULL_STRLIST){
            return true;
        }else if(list.car() == sl.car()){
            return cdr().equals(sl.cdr());
        }else{
            return false;
        }
    }

    
}