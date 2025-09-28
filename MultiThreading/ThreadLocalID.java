import java.util.UUID;

class RequestContext {
    private static final ThreadLocal<String> requestIdThreadLocal = new ThreadLocal<>();
    public static void setRequestId(String requestId) {
        requestIdThreadLocal.set(requestId);
    }
    public static String getRequestId() {
        return requestIdThreadLocal.get();
    }
    public static void clear() {
        requestIdThreadLocal.remove();
    }
}
class Service {
    public void process() {
        String requestId = RequestContext.getRequestId();
        System.out.println("Processing request with ID: " + requestId + " in " + Thread.currentThread().getName());
    }
}
public class ThreadLocalID {
    public static void main(String[] args) throws InterruptedException {
        Runnable handleRequest = () -> {
            String requestId = UUID.randomUUID().toString();
            RequestContext.setRequestId(requestId);  
            try {
                Service service = new Service();
                service.process();  
                Thread.sleep(500);  
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                RequestContext.clear();  
            }
        };
        Thread t1 = new Thread(handleRequest, "Thread-1");
        Thread t2 = new Thread(handleRequest, "Thread-2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
