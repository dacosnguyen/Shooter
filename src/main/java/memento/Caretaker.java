package memento;

/**
 *
 * @author Nguyen Duc Anh <nguyedu7@fit.cvut.cz>
 *
 *     The memento design pattern is used to save an actual game snapshot.
 */
public class Caretaker {
    // Can be upgraded. Can save more snapshots.
    // private List<Memento> savedStates = new ArrayList<Memento>();
    private static Memento savedState;
    
    public void saveMemento(final Memento m) {
        savedState = m;
    }
    
    public final Memento loadMemento() {
        return savedState;
    }
}
