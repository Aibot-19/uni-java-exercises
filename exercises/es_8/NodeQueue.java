public class NodeQueue{

    private int n; // numero di elementi contenuti nella coda
    private Node[] queue; //struttura di base per rappresentare la queue
    //costruttore per coda vuota
    public NodeQueue(){
        n = 0;
        queue = new Node[0];
    }

    public Node[] queue(){
        return queue;
    }

    public int size(){
        return n;
    }
    //
    public Node peek(){
        return queue[n-1];
    }

    public Node poll(){
        n = n-1;
        Node poll = queue[n];
        Node[] arr = new Node[n];
        for(int i=0; i<n; i++){
            arr[i]=queue[i];
        }
        queue = arr;
        return poll;
    }
   //aggiunge un elemento alla coda di priorità
    public void add( Node nd ){
    Node[] arr = new Node[n + 1];
    int i = 0;
    //fin tanto che i è minore della dimensione della queue precedente e il nodo da inserire ha peso minore rispetto a tutti quelli 
    //già presenti nella coda allora li reinseriamo nella nuova coda
    while (i < n && nd.compareTo(queue[i]) <= 0) {
        arr[i] = queue[i];
        i++;
    }
    //se la condizione risulta false allora fermiamo il ciclo perché in quell'esatto indice i dobbiamo inserire il nostro nodo
    arr[i] = nd;
    //se rimangono altri elementi da inserire li inseriamo
    for (int j = i; j < n; j++) {
        arr[j + 1] = queue[j];
    }
    //la vecchia coda diventa quella nuova
    queue = arr;
    //la sua dimensione cresce di uno
    n = n + 1;
}

}
