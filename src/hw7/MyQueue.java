package hw7;

 class MyQueue <Q> {

    private int size = 0;
    private QNode first = null;
    private QNode last = null;

    class QNode <Q> {
        private Q element;
        private QNode next;
        private QNode prev;

        QNode(Q element) {
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
    public void addElem (Q element){
        new QNode(element);
    }
    public Q peekElem (){
        if (first == null){
            return null;
        }
        return (Q)first.element;
    }
    public Q pollElement (){
        if (first == null){
            return null;
        }
        Q tmp = (Q) first.element;
        if (first.next != null){
            first.next.prev = null;
        }
        first = first.next;
        size -= 1;
        return tmp;
    }
     public void showQueue (){
         QNode current = first;
         for (int i = 0; i < size; i++) {
             System.out.print(current.element + ", ");
             current = current.next;
         }
         System.out.println();
     }

}
