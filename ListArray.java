import java.util.ArrayList;

public class ListArray {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
    

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(1, 9);

        System.out.println(list);

        //Get Operation -- 0(1)
       // int element = list.get(2);
        //System.out.println(element);

        //delet
       //list.remove(2);
        //System.out.println(list);

        //contains
        //System.out.println(list.contains(12));

        //list.get(3);
        //System.out.println(list.size());

        //reverse print
        for(int i = list.size()-1; i>= 0; i--){
            System.out.println(list.get(i) + " ");

        }
        System.out.println();
    }
    
}
