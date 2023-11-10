// queue
// take() and put() blocking calls
// maintain a size value
// TODO: How to do generics?

public class MyBlockingQueue {
    private Queue<Integer> queue;
    private int capacity;
    private Lock lock;
    private Condition notEmpty;
    private Condition notFull;
    
    public MyBlockingQueue(int size) {
        this.capacity = capacity;
        queue = new LinkedList<>();
        lock = new ReentrantLock();
        notEmpty = lock.condition();
        notFull = lock.condition();
    }

    public int take() {
        lock.lock();
        try {
            while(queue.isEmpty()) {
                notEmpty.await()
            }
            int firstElement = queue.removeFirst();
            notFull.signalAll();
            return firstElement;
        } catch(Exception ex) {
          // handle exception
        } finally {
            lock.unlock();
        }
    }

    public void put(int key) {
        lock.lock();
        try {
            while(queue.isFull()) {
                notEmpty.await()
            }
            queue.addLast(key);
            notEmpty.signalAll();
        } catch(Exception ex) {
          // handle exception
        } finally {
            lock.unlock();
        }
    }
}
