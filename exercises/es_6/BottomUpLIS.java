
public class BottomUpLIS {


  // Length of Longest Increasing Subsequence (LLIS):
  // Programmazione dinamica bottom-up
  
  public static int llisDP( int[] s ) {
    int t;
    int n = s.length;
    
    int[][] mem = new int[ n+1 ][ n+1 ];
    
    // Matrice: valori delle ricorsioni di llisRec
    // relativi a diversi valori degli argomenti
    for ( int j=0; j<=n; j=j+1 ) {
      mem[n][j] = 0;
    }
    
    for ( int i=n-1; i>=0; i=i-1 ) {
      for ( int j=0; j<=n; j=j+1 ) {
        if ( j == s.length ){
             t = 0;
        }else{
            t = s[j];
        }
        if ( s[i] <= t ) {
            mem[i][j] = mem[i+1][j];
        }else{
            mem[i][j] = Math.max(1 + mem[i+1][i], mem[i+1][j]);
        }
        
      
    }}
    
    // ----------------------------------------------------
    //  Inserisci di seguito l'elemento della matrice
    //  il cui valore corrisponde a llis(s) :
    
    return  mem[0][n];
    
    // ----------------------------------------------------
  }

  
  // Longest Increasing Subsequence (LIS):
  // Programmazione dinamica bottom-up
  
  public static int[] lisDP( int[] s ) {
  
    int n = s.length;
    
    int[][] mem = new int[ n+1 ][ n+1 ];
    
    // 1. Matrice: valori delle ricorsioni di llisRec
    //    calcolati esattamente come per llisDP
    
        for ( int j=0; j<=n; j=j+1 ) {
      mem[n][j] = 0;
    }
    
    for ( int i=n-1; i>=0; i=i-1 ) {
      for ( int j=0; j<=n; j=j+1 ) {
        int t = ( j == n ) ? 0 : s[j];
        if ( s[i] <= t ) {
            mem[i][j] = mem[i+1][j];
        }else{
            mem[i][j] = Math.max(1 + mem[i+1][i], mem[i+1][j]);
        }
        
      
    }}
    
    // 2. Cammino attraverso la matrice per ricostruire
    //    un esempio di Longest Increasing Subsequence
    
    // ----------------------------------------------------
    //  Inserisci di seguito l'elemento della matrice
    //  il cui valore corrisponde a llis(s) :

    int m =  mem[0][n];
    
    // ----------------------------------------------------
    
    int[] r = new int[ m ];  // per rappresentare una possibile LIS
    
    int i = 0, j = n, k=0;

    while ( mem[i][j] > 0 ) {
      int t = ( j == n ) ? 0 : s[j];
      //se la cella è minore di t allora non va messo all'interno della LIS
     if (s[i] <= t) {
        i++;
    //se invece è maggiore allora controllo qual è il massimo tra i due
    } else {
        //mem nel nostro caso rappresenta la lunghezza della LIS partendo da s[i] e come riferimento per il minimo s[j]
        //se è più grande 1 + mem[i+1][i] rispetto a mem[i+1][j] allora significa che dobbiamo scegliere s[i] perché fa parte della sottosequenza crescente
        //più lunga, se invece non è così allora non lo scegliamo e quindi controllo la cella successiva
    if (1 + mem[i+1][i] >= mem[i+1][j]) {
      r[k] = s[i];
      k++; //serve come indice per far scorrere l'array della LIS
      j = i;
    }
    i++;
  }
}
    
    return r;                // = LIS relativa alla sequenza s
  }

}

