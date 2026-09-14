class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;

        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void addNode(Node node) {
        Node last = this.tail.prev;
        last.next = node;
        node.prev = last;
        node.next = this.tail;
        this.tail.prev = node;
    }

    public void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            addNode(node);

            return node.value;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            removeNode(map.get(key));
        }
        Node node = new Node(key, value);
        map.put(key, node);
        addNode(node);

        if(map.size() > capacity) {
            Node lru = this.head.next;
            removeNode(lru);
            map.remove(lru.key);
        }
    }
}
