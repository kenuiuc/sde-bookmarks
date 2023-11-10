// queue
// take() and put() blocking calls
// maintain a size value
// TODO: How to do generics?

public class MyBlockingQueue<E> {
    private Queue<E> queue = new LinkedList<>();
    private int capacity = 0;
    private Lock lock = new ReentrantLock(); 
    private Condition notEmpty = lock.newCondition(); 
    private Condition notFull = lock.newCondition();
    
    public MyBlockingQueue(int size) {
        this.capacity = capacity;
    }

    public E take() {
        lock.lock();
        try {
            while(queue.isEmpty()) {
                notEmpty.await()
            }
            E element = queue.remove();
            notFull.signalAll();
            return element;
        } catch(Exception ex) {
          // handle exception
        } finally {
            lock.unlock();
        }
    }

    public void put(E element) {
        lock.lock();
        try {
            while(queue.isFull()) {
                notEmpty.await()
            }
            queue.add(key);
            notEmpty.signalAll();
        } catch(Exception ex) {
          // handle exception
        } finally {
            lock.unlock();
        }
    }
}
