import java.util.*;

/**
 * Aggiungi qui una descrizione della classe puzzle15
 * 
 * @author (il tuo nome) 
 * @version (un numero di versione o una data)
 */
public class puzzle15{
    private int n;
    private int[][] matrix;
    private String config;
    private final int EMPTY;

    public puzzle15(int n){
        this.n = n;
        this.EMPTY = n*n;
        config = "";
        matrix = new int[n][n];
        //creo array riempito di numeri da 1 a n*n
        int[] v = createArray(n*n);
        //mescola elementi nell'array
        shuffleArray(v);
        int k = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = v[k++];
            }
        }
        config(); // chiamo il metodo cconfig per aggiornare la configurazione

    }
    //costruisce un array di dimensione n e lo riempie con numeri che partono da uno fino a n
    private static int[] createArray(int n){
        int k = 1;
        int[] v = new int[n];
        for(int i=0;i<n;i++){
            v[i]= k++;
        }
        return v;
    }
    //shuffle con algoritmo Fisher-Yates
    private static void shuffleArray(int[] arr){
        Random rnd = new Random();
        for (int i = arr.length - 1; i > 0; i--){
            //genera un intero tra 0 e n-1 inclusi dove n è il numero inserito
            int index = rnd.nextInt(i + 1);
            //swap
            int a = arr[index];
            arr[index] = arr[i];
            arr[i] = a;
        }
    }

    public int getI(int k){ // ritorna indice I della cella con quel valore
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == k){
                    return i;
                }
            }
        }
        return -1; // ritorna un valore di errore se non trova la casella della matrice con quel numero k
    }

    public int getJ(int k){ // ritorna indice J della cella con quel valore
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == k){
                    return j;
                }
            }
        }
        return -1; // ritorna un valore di errore se non trova la casella della matrice con quel numero k
    }

    public int number(int i, int j){ //ritorna il valore della matrice con quegli indici
        return matrix[i][j];
    }

    public int size(){
        return n;
    }

    public String config(){ //ogni volta che viene chiamato questo metodo la configurazione si aggiorna
        config = "";
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                config = config + matrix[i][j] + " ";
            }

        }
        return config;
    }

    public boolean isSorted(){
        int k=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] != k++ ){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean canMoveU(int i, int j){

        return i > 0 && matrix[i-1][j] == EMPTY;
    }  

    public boolean canMoveD(int i, int j){

        return i < n-1 && matrix[i+1][j] == EMPTY;
    }

    public boolean canMoveL(int i, int j){

        return j > 0 && matrix[i][j-1] == EMPTY;
    }  

    public boolean canMoveR(int i, int j){

        return j < n-1 && matrix[i][j+1] == EMPTY;
    }

    public puzzle15 move(int i, int j){
        int temp = 0;
        if(canMoveU(i,j)){
            temp = matrix[i][j];
            matrix[i][j] = EMPTY;
            matrix[i-1][j] = temp;

        }else if(canMoveD(i,j)){
            temp = matrix[i][j];
            matrix[i][j] = EMPTY;
            matrix[i+1][j] = temp;

        }else if(canMoveL(i,j)){
            temp = matrix[i][j];
            matrix[i][j] = EMPTY;
            matrix[i][j-1] = temp;

        }else if(canMoveR(i,j)){
            temp = matrix[i][j];
            matrix[i][j] = EMPTY;
            matrix[i][j+1] = temp;
        }
        config(); //aggiorna la config. doppo la mossa di un tassello
        return this;
    }

    
    
    
}
