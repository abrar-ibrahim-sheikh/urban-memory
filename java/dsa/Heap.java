import java.util.ArrayList;

public interface Heap {

    int capacity();

    int size();

    void insert(int val);

    void insert(ArrayList<Integer> arrayList, int size, int val);

    int delete();

    int delete(ArrayList<Integer> arrayList, int count);



}
