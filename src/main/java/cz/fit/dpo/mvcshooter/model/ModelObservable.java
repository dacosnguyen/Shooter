
package cz.fit.dpo.mvcshooter.model;

/**
 * @author Nguyen Duc Anh <nguyedu7@fit.cvut.cz>
 */
public interface ModelObservable {

    void registerObserver(ModelObserver observer);

    void notifyObserver();

}
