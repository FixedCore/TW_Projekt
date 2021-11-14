package active_object;

import active_object.method_request.StoreRequest;
import active_object.method_request.TakeRequest;
import active_object.resource.Resource;

import java.util.List;

public class Proxy {
    private final Scheduler scheduler;
    public Proxy(Scheduler scheduler)
    {
        this.scheduler = scheduler;
    }

    public Future<Integer> put(List<Resource> resources)
    {
        StoreRequest request = new StoreRequest(resources);
        Future<Integer> future = request.getFuture();
        scheduler.enqueue(request);
        return future;
    }

    public Future<List<Resource>> get(int n)
    {
        TakeRequest request = new TakeRequest(n);
        Future<List<Resource>> future = request.getFuture();
        scheduler.enqueue(request);
        return  future;
    }
}
