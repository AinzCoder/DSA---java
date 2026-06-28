import java.util.Scanner;

public class DesignCircularQueue {
    private final int[] data;
    private final int cap;
    private int head;
    private int size;

    public DesignCircularQueue(int k){
        data=new int[k];
        cap=k;
        head=0;
        size=0;
    }

    //insert rear
    private boolean enQueue(int val){
        if(isFull()) return false;
        int tail = ( head + size ) % cap;
        data[tail]=val;
        size++;
        return true;
    }

    //remove from front
    private boolean deQueue(){
        if(isEmpty()) return false;
        head =( head + 1 ) % cap;
        size--;
        return true;
    }

    //get front
    private int front(){
        return isEmpty()? -1 : data[head];
    }
    
    //get rear
    private int rear(){
        if(isEmpty()) return -1;
        int tail =( head + size - 1 ) % cap;
        return data[tail];
    }
    
    //chech empty
    private boolean isEmpty(){
        return size==0;
    }

    //check isfull
    private boolean isFull(){
        return size==cap; //size equals capacity
    }

    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter the number of elements: ");
        int n = scan.nextInt();
        DesignCircularQueue cir = new DesignCircularQueue(n);

        System.out.println("Enter the elements: ");
        for(int i=0;i<n;i++){
            int val = scan.nextInt();
            cir.enQueue(val);
        }

        System.out.println("Deleted: "+ cir.deQueue());
        System.out.println("Front: "+cir.front());
        System.out.println("Rear: "+cir.rear());
        System.out.println("isEmpty: "+cir.isEmpty());
        System.out.println("isFull: "+cir.isFull());

        scan.close();
    }
}
