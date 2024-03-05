package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Box <T>{

    private HashMap<String, T> box;

    public Box(){
        box = new HashMap<>();
    }

    public void put(List<String> keys, Inventory<T> values){
        IntStream.range(0, keys.size())
                .parallel()
                .peek(i->box.put(keys.get(i), values.get(i)))
                .forEach(i-> System.out.println(keys.get(i) + " : " + box.get(keys.get(i))));
    }

    public T put(String key, T t){  return box.put(key, t); }

    public T get(String key){   return box.get(key);    }

    public int size(){    return box.size();    }

    public void clear(){    box.clear();     }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> k = new ArrayList<>();
        Inventory<String> v = new Inventory<>();
        Box<String> b = new Box<>();
        for(int i = 0; i < 3; i++){
            k.add(scan.next());     v.add(scan.next());
        }
        b.put(k, v);
    }

}
