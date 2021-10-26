 class hashmap {

    private class linkedlist {

        private class node {
            Integer key;
            Integer value;
            node next;

            public node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private node head, tail;
        private int size = 0;

        public linkedlist() {
            this.head = this.tail = null;
            this.size = 0;
        }

        public int Size() {
            return this.size;
        }

        public node getFirst() {

            if (this.size == 0)
                return null;

            return this.head;
        }

        public node removeFirst() {
            if (this.size == 0)
                return null;

            this.size--;
            node temp = this.head.next;
            this.head.next = null;
            node rv = this.head;

            this.head = temp;

            return rv;
        }

        public void addLast(int key, int val) {

            node node = new node(key, val);

            if (this.size == 0)
                this.head = this.tail = node;
            else {
                this.tail = node;
                this.tail = this.tail.next;
            }
            this.size++;

        }

    }

}