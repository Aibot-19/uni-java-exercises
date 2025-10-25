public class Test{


    public static IntSList intervallo(int inf, int sup){
        if(inf > sup){
            return IntSList.NULL_INTLIST;
        }else{
            return intervallo(inf+1, sup).cons(inf);
        }
    }
    

    public static IntSList josephus (int n){
        RoundTable rt = new RoundTable(n);
        while(rt.numberOfKnights()>2){
            rt=rt.serveNeighbour();
            rt=rt.passJug();
        }
        return rt.servingKnights();
    }
    
    
    
    
    
    


}