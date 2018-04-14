package hw7;

class MyLinkedList <T> {

    private int size = 0;
    private MyNode first = null;
    private MyNode last = null;

    class MyNode<T> {
        private T element;
        private MyNode next;
        private MyNode prev;

        MyNode(T element) {
            this.element = element;
            this.prev = last;
            this.next = null;
            if (last != null){
                last.next = this;
            }
            if (first == null){
                first = this;
            }
            last = this;
            size += 1;
        }
    }

    public void addElem (T element){
        new MyNode(element);
    }
    public T getFirst(){
        return (T)first.element;
    }
    public T getLast(){
        return (T)last.element;
    }
    public int getSise (){
        return size;
    }
    public int getIndex (T element) {
        MyNode start = first;
        for (int index = 0; index < size; index++) {
            if (start.element.equals(element)) {
                return index;
            }
            else {start = start.next;}
        }
    return -1;
    }
    public T getElement (int index){
        if (index >= size || index < 0){
            return null;
        }
        MyNode start = first;
        for (int i = 0; i < index; i++) {
            start = start.next;
        }
        return (T) start.element;
    }
    public boolean remElement (T element){
        MyNode current = first;
        if(current == null){
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (current.element.equals(element)) {
                if(current.next != null){
                    current.next.prev = current.prev;
                }
                if (current.prev != null){
                    current.prev.next = current.next;
                }
                current = null;
                size -=1 ;
                return true;
            }
            else {current = current.next;}
        }
        return false;
    }
    public boolean insElement (int index, T element){
        if (index >= size || index < 0){
            return false;
        }
        MyNode current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        MyNode tmpLast = last;
        MyNode newNode = new MyNode<>(element);
        newNode.next = current;
        newNode.prev = current.prev;
        if (index != 0){
            current.prev.next = newNode;
        }
        current.prev = newNode;
        last = tmpLast;
        if (index == 0){
            first = newNode;
        }
        last.next = null;
        return true;
    }
    public void showArray (){
        MyNode current = first;
        for (int i = 0; i < size; i++) {
            System.out.print(current.element + ", ");
            current = current.next;
        }
        System.out.println();
    }
}

