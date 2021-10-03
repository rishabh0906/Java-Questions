package Adapters;

public class Client {

    public static void main(String[] args) throws Exception {

        Queue q = new Queue();

        q.push(10);
        q.push(4);
        q.push(5);

        while (q.Size() != 0) {

            System.out.println(q.pop());
        }

    }
}
