package observer;

import java.util.ArrayList;

public interface IObserver {
	void addListener(IListener listener);
    void removeListener(IListener listener);
    void notifyListeners(Object event);
}
