public class minHeap {
    private int[] heap;
    private int capacity;
    private int size;

    public minHeap(int capacity){
        this.capacity=capacity;
        this.size=0;
        heap = new int[capacity];
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }
    private boolean isLeft(int i) {return i >= size / 2 && i < size;} //given node is leaf node or not

    //insert new element into the heap
    public void insert(int element){
        if(size==capacity){
            throw new IllegalStateException("Heap is full");
        }
        heap[size]=element;//insert element at very last position of the heap
        int current = size;
        size++;

        //heapify operation
        while(heap[current] < heap[parent(current)]){
            swap(current,parent(current));
            current=parent(current);
        }
    }

    //remove the root of the heap
    public int removeMin(){
        if(size==0){
            throw new IllegalStateException("Heap is empty");
        }
        int min=heap[0];
        heap[0]=heap[--size];
        heapify(0);
        return min;
    }

    //modify the heap starting from a given index
    public void heapify(int i){
        if(isLeft(i)) return;

        int left=leftChild(i);
        int right=rightChild(i);
        int samllest=i;

        if(left<size && heap[left] < heap[i]){
            samllest=left;
        }
        if(right<size && heap[right] < heap[samllest]){
            samllest=right;
        }
        if(samllest != i){
            swap(i,samllest);
            heapify(samllest);
        }
    }

    private void swap(int i,int j){
        int temp=heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }
    public static void main(String []args){
        minHeap heap = new minHeap(5);
        heap.insert(5);
        heap.insert(4);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);

        System.out.println("min Value: "+heap.removeMin());
    }    
}
