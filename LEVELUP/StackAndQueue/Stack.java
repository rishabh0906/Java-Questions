
public class Stack {

    private int[] stack;
    private int MaxCap;
    private int NoOfEle;
    private int tos;

    public Stack(int size) {

        initialize(size);

    }

    public Stack() {
        this(10);
    }

    protected void initialize(int size) {

        this.NoOfEle = 0;
        this.stack = new int[size];
        this.MaxCap = size;
        this.tos = -1;
    }

    protected void StackOverFlowException() throws Exception {

        if (this.NoOfEle == this.MaxCap)
            throw new Exception("StackOverFlowException");

    }

    protected void StackIsEmptyException() throws Exception {

        if (this.NoOfEle == 0)
            throw new Exception("StackIsEmptyException");
    }

    public boolean isEmpty() {

        return this.NoOfEle == 0;
    }

    public int Size() {

        return this.NoOfEle;
    }

    private void push_(int value) {

        this.stack[++this.tos] = value;
        this.NoOfEle++;
    }

    public void push(int value) throws Exception {
        StackOverFlowException();
        push_(value);
    }

    private int peek_() {
        return this.stack[this.tos];
    }

    public int peek() throws Exception {
        StackIsEmptyException();

        return peek_();

    }

    private int pop_() {

        int value = this.stack[this.tos--];
        this.NoOfEle--;
        return value;
    }

    public int pop() throws Exception {
        StackIsEmptyException();

        return pop_();

    }

}
