public class Queue {
    private int[] queue;
    private int NoOfEle;
    private int MaxCap;
    private int front;
    private int rear;

    Queue() {
        this(10);
    }

    Queue(int size) {
        init(size);
    }

    public void init(int size) {
        this.queue = new int[size];
        this.MaxCap = size;
        this.NoOfEle = 0;
        this.front = this.rear = 0;
    }

    protected void QueueOverflow() throws Exception {
        if (this.NoOfEle == this.MaxCap)
            throw new Exception("QueueOverflowException");
    }

    protected void QueueIsEmpty() throws Exception {
        if (this.NoOfEle == 0)
            throw new Exception("QueueIsEmptyException");
    }

    public boolean isEmpty() {
        return this.NoOfEle == 0;
    }

    public int Size() {
        return this.NoOfEle;
    }

    public void push(int value) throws Exception {
        QueueOverflow();
        this.NoOfEle++;
        this.queue[this.rear] = value;
        this.rear = (this.rear + 1) % this.MaxCap;

    }

    public int peek() throws Exception {
        QueueIsEmpty();

        return this.queue[this.front];
    }

    public int pop() throws Exception {
        QueueIsEmpty();
        this.NoOfEle--;
        int val = this.queue[this.front++];
        this.front = (this.front + 1) % this.MaxCap;
        return val;
    }
}
