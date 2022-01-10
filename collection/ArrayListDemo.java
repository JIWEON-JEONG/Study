package collection;

import java.util.ArrayList;

public class ArrayListDemo {

    public void test() {
        ArrayList al1 = new ArrayList(); //List 요소 데이터타입 Object 로 저장
        ArrayList<String> al2 = new ArrayList<>();  //List 요소 데이터 타입 String 으로 저장
        al1.add("one");
        al1.add(2);
        al2.add("two");
        al2.add("three");

        for(int i=0;i<al1.size();i++){
            System.out.println("al1.get(i) = " + al1.get(i) +" & "+ al1.getClass());
        }

        for(int i=0;i<al2.size();i++){
            System.out.println("al2.get(i) = " + al2.get(i) + " & "+al2.getClass());
        }

    }

}
