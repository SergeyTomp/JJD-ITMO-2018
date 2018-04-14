package hw7;

class MyStack <S> {

    private int size = 0;
    private SNode first = null;
    private SNode last = null;

    class SNode<S> {
        private S element;
        private SNode next;
        private SNode prev;

        SNode(S element) {
            this.element = element;
            this.prev = last;
            this.next = null;
            if (last != null) {
                last.next = this;
            }
            if (first == null) {
                first = this;
            }
            last = this;
            size += 1;
        }
    }
    public void pushElem (S element){
        new SNode(element);
    }
    public S popElement (){
        if (last == null){
            return null;
        }
        S tmp = (S) last.element;
        if (last.prev != null){
            last.prev.next = null;
        }
        last = last.prev;
        size -= 1;
        return tmp;
    }
    public void showStack (){
        SNode current = first;
        for (int i = 0; i < size; i++) {
            System.out.print(current.element + ", ");
            current = current.next;
        }
        System.out.println();
    }
}

