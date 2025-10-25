import puzzleboard.PuzzleBoard;
public class View{
    public static void puzzleGame(int n){
        
    PuzzleBoard gui = new PuzzleBoard( n );
    
    puzzle15 p = new puzzle15(n);
    
    for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                gui.setNumber( i, j, p.number(i-1,j-1) );   
            }
        }
        while(!p.isSorted()){
        // ottengo il valore di quella cella con il click del mouse
        int k = gui.get();
        //prendo l'indice i e l'indice j corrispondenti a quel valore, però sono 0-based
        int i = p.getI(k);
        int j = p.getJ(k);
        //controllo se la casella si può muovere
        if(p.canMoveU(i, j) || p.canMoveD(i, j) || p.canMoveR(i, j) || p.canMoveL(i, j)){
            //se opero con la gui devo sommare 1 perché il package opera in 1-based.
            //se si può muovere elimino la casella nella GUI (creo lo spazio)
            gui.clear(i+1, j+1);
            //sposto la casella all'interno del puzzle
            p.move(i, j);
            //prendo i nuovi indici i e j dello stesso valore ( quello che ho spostato )
            i = p.getI(k);
            j = p.getJ(k);
            //setto il numero nella GUI (+1 sempre per l'1-based)
            gui.setNumber( i+1,j+1, p.number(i,j) );
            //aggiorno il puzzle
            gui.display();
        }else{
            System.out.println("La cassella di indice " + (i+1) + " e " + (j+1) +" non si può spostare.");        
        }
        
    }
    
    }
    
}
