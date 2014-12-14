package htThreads;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by forenc on 07.12.2014.
 */

// Демонстрация сортировки бинарного дерева
public class DriveBTree {
    public static void main(String[] args) {
// Создаем клас дерева с произвольным ключем в корне
        final IMyBTree<Integer> myBTree = new MyBTree<>(DriveBTree.generateIt(50));
//создаем масив потоков, для заполнения дерева
        List<Thread> threads = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            threads.add(new Thread(){
                @Override
                public void run() {
                    myBTree.add(DriveBTree.generateIt(50));
                }
            });
        }
// Запускаем потоки заполнения дерева
        for (Thread t:threads){
            t.start();
        }
// делаем паузу на долю секуеды, чтобы потоки успели отработать
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        SortBTree sortBTree = new SortBTree();//создаем объект-сортировщик
        sortBTree.sortDesign(myBTree);//передаем ему дерево, и смотрим результат на выходе
        System.out.println("");
    }
    public  static int generateIt(int max){
        return (int)(Math.random()*max);
    }
//
}
