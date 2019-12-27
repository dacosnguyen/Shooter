package memento;

/**
 *
 * @author Nguyen Duc Anh <nguyedu7@fit.cvut.cz>
 */
public class Memento {
    private MementoCrate mementoCrate;
    
    public Memento(final MementoCrate mementoCrate) {
        this.mementoCrate = mementoCrate;
    }
    
    public MementoCrate getMementoCrate() {
        return mementoCrate;
    }
}
