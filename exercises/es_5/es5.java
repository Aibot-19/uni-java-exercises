
public class es5    {
    // costante usata per memoization
    private static final int UNKNOWN = -1;

    public static int llis( int[] s ) { // s[i] > 0 per i in [0,n-1], dove n = s.length
        return llisRec( s, 0, 0 );
    }

    private static int llisRec( int[] s, int i, int t ) {
        //se l'indice che scorre l'array ha raggiunto la lunghezza dell'array allora l'array è finito e la sequenza più lunga di un array vuoto
        //è 0
        if ( i == s.length ) {                // i = n : coda di s vuota
            return 0;
        } else if ( s[i] <= t ) {             // x = s[i] ≤ t : x non può essere scelto
            return llisRec( s, i+1, t );
        } else {                              // x > t : x può essere scelto o meno
            return Math.max( 1+llisRec(s,i+1,s[i]), llisRec(s,i+1,t) );
        }
    }
    //funzione che preso un array di interi restituisce la lunghezza della sottosequenza più lunga crescente
    public static int llisTD( int[] s ) {
        int n = s.length;
        //creo una matrice di grandezza n+1 e n+1 per rappresentare tutti i casi
        int[][] mem = new int[n+1][n+1];
        //inizializzo la matrice di UNKNOWN per applicare la memoization
        for(int i=0;i<=n;i++){
            for(int j=0; j<=n; j++){
                mem[i][j]= UNKNOWN;
            }
        }
        // restituisco il risultato della procedura contenente s, mem come parametri che verranno effettivamente utilizzati e 0, 0 come indici iniziali
        return llisRecTD( s, mem, 0, 0 );
    }
    //cuore della procedura, questa versione funziona solo se ogni valore contenuto in s[] è minore o uguale a n
    private static int llisRecTD( int[] s, int[][] mem, int i, int t) {
        //se l'indice che scorre l'array ha raggiunto la lunghezza dell'array allora l'array è finito e la sequenza più lunga di un array vuoto
        //è 0
        if ( mem[i][t]==UNKNOWN ) {
            if( i == s.length ){
                mem[i][t] = 0;
            }else if ( s[i] <= t ) { // x = s[i] ≤ t : x non può essere scelto
                return  mem[i][t] = llisRecTD( s, mem, i+1, t );
            } else { // x > t : x può essere scelto o meno
                return  mem[i][t] = Math.max(
                    1 + llisRecTD(s, mem, i+1, s[i]),
                    llisRecTD(s, mem, i+1, t)
                );
            }
        }
        return mem[i][t];
    }
//stesso funzionamento di llisTD ma ora utilizziamo un indice per codificare l'elemento da controllare
    public static int llisTDv2( int[] s ) {
        int n = s.length;
        int[][] mem = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0; j<=n; j++){
                mem[i][j]= UNKNOWN;
            }
        }
        //passo la lunghezza dell'array come indice j per dire che l'elemento massimo in questo momento non c'è perché siamo all'inizio dell'array
        return llisRecTDv2( s, mem, 0, s.length );
    }

    private static int llisRecTDv2( int[] s, int[][] mem, int i, int j){
        //t è 0 se siamo all'inzio oppure è la cella corrispondente a j se è diverso dalla lunghezza massima dell'array
        int t = ( j==s.length ) ?  0 : s[j];
        if ( mem[i][j]==UNKNOWN ) {
            if( i == s.length ){
                mem[i][j] = 0;
            }else if ( s[i] <= t ) { // x = s[i] ≤ t : x non può essere scelto
                return  mem[i][j] = llisRecTDv2( s, mem, i+1, j );
            } else { // x > t : x può essere scelto o meno
                return  mem[i][j] = Math.max(
                    1 + llisRecTDv2(s, mem, i+1, i), //se scelgo l'elemento allora il massimo si trova ora in posizione i
                    llisRecTDv2(s, mem, i+1, j)
                );
            }
        }
        return mem[i][j];
    }

    
}
