public class es_1{
    public static StringSList intervallo(int inf, int sup){
        StringSList lista = StringSList.NULL_STRLIST;
        for(int i=sup;i>=inf;i--){
            lista = lista.cons("" + i);
        }
        return lista;
    }

    public static int btrVal(String btr){
        int k = btr.length() - 1; 
        if(k == 0){
            return btdVal(btr);
        }else{
            return ((btrVal(btr.substring(0, k)))*3) + btdVal(btr.substring(k));
        }

    }

    public static int btdVal(String btd){
        if(btd.equals("-")){
            return -1;
        }else if(btd.equals(".")){
            return 0;
        }else{
            return +1;
        }
    }
    
    public static String btrRep(int n){
         int q = n / 3;
         int r = n % 3;
        if(Math.abs(n) < 2){
            return btdRep(n);
        }else{
            if(r == -2){
               return btrRep(q - 1) + (btdRep(+1));
            }else if(r == +2){
                return btrRep(q + 1) + (btdRep(-1));
            }else{
                return btrRep(q) + (btdRep(r));
            }
        }
    }
    public static String btdRep(int n){
        if(n == -1){
            return "-";
        }else if(n == 0){
            return ".";
        }else{
            return "+";
        }
    }
    //l'obiettivo della funzione è rappresntare tutti gli n numeri in btr successivi alla stringa btr inserita
    public static StringSList btrRange(String btr, int n){
        //converto in intero la stringa di partenza
        int inf = btrVal(btr); 
        //inizializzo una lista vuota per le soluzioni
        StringSList lista = StringSList.NULL_STRLIST; 
        for(int i=inf+n-1;i>=inf;i--){
            // dobbiamo rappresentare una lista in un certo range, il nostro range è formato da inf+n-1 e inf inserisco prima con il cons
            // la rappresentazione di inf+n-1 poi -2 e così via fino a inf cioè la mia stringa di partenza.
            // si poteva anche fermare il ciclo un'iterazione prima e fare il cons di btr direttamente.
            lista = lista.cons("" + btrRep(i));
        }
        return lista;
    }
    
}