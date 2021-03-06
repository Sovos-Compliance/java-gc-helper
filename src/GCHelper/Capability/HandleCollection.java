package GCHelper.Capability;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class HandleCollection<THandleClass, THandle> implements Iterable<HandleContainer<THandleClass, THandle>>
{
    private final ConcurrentHashMap<HandleContainer<THandleClass, THandle>, Integer> _container;

    public HandleCollection() {
        _container = new ConcurrentHashMap<>();
    }

    public boolean Add(THandleClass handleClass, THandle dep)
    {
        return _container.putIfAbsent(new HandleContainer<>(handleClass, dep), 0) == null;
    }

    public boolean Remove(THandleClass handleClass, THandle dep)
    {
        return _container.remove(new HandleContainer<>(handleClass, dep)) != null;
    }

    public Iterator<HandleContainer<THandleClass, THandle>> iterator(){
        return _container.keySet().iterator();
    }
}
