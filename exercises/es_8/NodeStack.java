public class NodeStack{
    private int n; // numero di elementi contenuti nello stack
    private Node[] stack; //struttura di base per lo stack
    private boolean empty; //bool per capire se è vuoto oppure no
    
    //costruttore per inizializzare uno stack vuoto
    public NodeStack(){
        n = 0;
        stack = new Node[0];
        empty = true;
    }

    public boolean empty(){
        return empty;
    }

    public Node[] stack(){
        return stack;
    }

    public int size(){
        return n;
    }
    //restituisce l'elemento più recentemente inserito nello stack, cioè l'ultimo
    public Node peek(){
        return stack[n-1];
    }
    //restituisce l'ultimo elemento inserito nello stack e lo rimuove da esso
    public Node pop(){
        n = n - 1;
        Node pop = stack[n];
        Node[] arr = new Node[n];
        if(n == 0){
            stack = new Node[0];
            empty= true;
            return pop;
        }else{
            for(int i=0; i<n; i++){
                arr[i]=stack[i];
            } 
            stack = arr;
        }

        return pop;
    }
    //inserisce un elemento nello stack, cioè alla fine di esso
    public void push( Node nd ){
        Node[] arr = new Node[n+1];
        for(int i=0;i<n;i++){
            arr[i]=stack[i];
        }
        arr[n]=nd;
        stack=arr;
        n = n + 1;
        empty=false;
    }

}
