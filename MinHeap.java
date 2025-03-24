public class MinHeap {
    int maxsize,heapsize;
    int[] arr;
    MinHeap(int maxsize)
    {
        this.maxsize=maxsize;
        arr=new int[maxsize];
        heapsize=0;
    }
    int parent(int i)
    {
        return (i-1)/2;
    }
    int lchild(int i)
    {
        return 2*i+1;
    }
    int rchild(int i)
    {
        return 2*i+2;
    }
    int curSize()
    {
        return heapsize;
    }
    int getMin()
    {
        return arr[0];
    }
    void minHeapify(int i)
    {
        int l=lchild(i);
        int r=rchild(i);
        int large=i;
        if(l<heapsize && arr[l]<arr[i])
        {
            large=l;
        }
        if(r<heapsize && arr[r]<arr[large])
        {
            large=r;
        }
        if(large!=i)
        {
            int temp=arr[i];
            arr[i]=arr[large];
            arr[large]=temp;
            minHeapify(large);
        }
    }
    void removeMin()
    {
        if(heapsize<=0)
        {
            System.out.println("heap is empty");
        }
        if(heapsize==1)
        {
            heapsize--;
        }
        else
        {
            arr[0]=arr[heapsize-1];
            heapsize--;
            minHeapify(0);
        }
    }
    void insertKey(int x)
    {
        if(heapsize==maxsize)
        {
            System.out.println("heap overflow");
        }
        int i=heapsize;
        arr[i]=x;
        heapsize++;
        while(i!=0 && arr[parent(i)]>arr[i])
        {
            int temp=arr[i];
            arr[i]=arr[parent(i)];
            arr[parent(i)]=temp;
            i=parent(i);
        }
    }
    public static void main(String[] args)
    {
        MinHeap h=new MinHeap(15);
        int elements[]={10,20,30,40};
        for(int e:elements)
        {
            h.insertKey(e);
        }
        System.out.println("the current size of the heap"+h.curSize());
        System.out.println("the current maximum element is"+h.getMin());
        h.removeMin();
        System.out.println("the current size of the heap size is"+h.curSize());
        h.insertKey(15);
        h.insertKey(5);
        System.out.println("the current maximum element is"+h.getMin());
        System.out.println("the current size of the heap is"+h.curSize());
    }
}
