
public class Client {

    public static void main(String[] args) throws Exception {

        Stack st = new Stack(4);
        st.push(10);
        st.push(5);
        st.push(7);

        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }

    }
}
