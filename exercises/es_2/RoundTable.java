/*
 * Classe RoundTable
 *
 * Risolve la variante del problema di Giuseppe Flavio (versione con eliminazione ogni tre cavalieri).
 * Utilizza due liste:
 *  - servingKnights: contiene A e B, cioè il cavaliere con la brocca e quello subito alla sua sinistra;
 *  - tail: contiene da C in poi, cioè i cavalieri che si incontrano successivamente in senso orario.
 *
 * Ad ogni turno:
 *   - C (il primo in tail) viene servito e abbandona la tavola;
 *   - La brocca passa al cavaliere che si trovava alla sinistra di C (cioè D).
 */

public class RoundTable {

  private final int num;                      // Numero di cavalieri ancora seduti
  private final IntSList servingKnights;      // Cavalieri A e B che hanno la brocca
  private final IntSList tail;                // Cavalieri successivi (da C in poi)

  /**
   * Costruttore principale.
   * Inizializza una tavola con n cavalieri numerati da 1 a n.
   * La brocca parte al cavaliere 1, seguito dal 2. I restanti sono in tail.
   */
  public RoundTable(int n) {
    num = n;
    servingKnights = new IntSList(1, new IntSList().cons(2));  // A = 1, B = 2
    tail = intervallo(3, n);                                   // C, D, ...
  }

  /**
   * Costruttore ausiliario, usato per aggiornare lo stato dopo ogni turno.
   */
  private RoundTable(int n, IntSList serving, IntSList t) {
    num = n;
    servingKnights = serving;
    tail = t;
  }

  /**
   * Crea una lista contenente tutti gli interi da inf a sup, in ordine crescente.
   * Esempio: intervallo(3, 6) → (3, 4, 5, 6)
   */
  private static IntSList intervallo(int inf, int sup) {
    if (inf > sup) {
      return IntSList.NULL_INTLIST;
    } else {
      return intervallo(inf + 1, sup).cons(inf);
    }
  }

  /**
   * Restituisce il numero di cavalieri ancora presenti alla tavola.
   */
  public int numberOfKnights() {
    return num;
  }

  /**
   * Restituisce la coppia di cavalieri che possiedono la brocca (A e B).
   */
  public IntSList servingKnights() {
    return servingKnights;
  }

  /**
   * Serve il cavaliere C (il primo in tail) che quindi si alza e lascia la tavola.
   * Ritorna una nuova RoundTable con un cavaliere in meno.
   */
  public RoundTable serveNeighbour() {
    if (num < 3) {
      return this;  // Non si può più servire nessuno
    } else {
      return new RoundTable(num - 1, servingKnights, tail.cdr());  // Rimuove C
    }
  }

  /**
   * Passa la brocca al cavaliere D (alla sinistra di C, che ora è il nuovo A).
   * Riorganizza le liste in base al numero di cavalieri rimasti in tail.
   */
  public RoundTable passJug() {
    if (num < 3) {
      return this;  // Nessun passaggio possibile
    } else if (tail.length() == 2) {
      // Solo C e D rimasti dopo A e B
      // Brocca → [C, D], tail → [A, B]
      return new RoundTable(num, tail, servingKnights);
    } else if (tail.length() == 1) {
      // Solo C rimasto → brocca: [C, A], tail vuota
      return new RoundTable(num,
        new IntSList(tail.car(), new IntSList().cons(servingKnights.car())),
        IntSList.NULL_INTLIST.cons(servingKnights.cdr().car())
      );
    } else {
      // Caso generale → brocca: [C, D], tail: da E in poi + A, B (ciclo)
      IntSList nuovaBrocca = new IntSList(tail.car(), new IntSList().cons(tail.cdr().car()));
      IntSList nuovaTail = tail.cdr().cdr().append(servingKnights);
      return new RoundTable(num, nuovaBrocca, nuovaTail);
    }
  }
}
