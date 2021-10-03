package StackAndQueueConstruction;
public class DynamicStack extends Stack {

    DynamicStack(int size) {
        super(size);
    }

    DynamicStack() {
        super();
    }

    @Override
    public void push(int value) throws Exception {

        int max = super.MaxSize();

        int curr = super.Size();
        if (curr == max) {
            int[] temp = new int[max];
            int idx = max - 1;
            while (super.Size() != 0) {
                temp[idx--] = super.pop();
            }

            super.initialize(2 * max);
            for (int i = 0; i < max; i++) {
                super.push(temp[i]);
            }

        }
        super.push(value);

    }
}
