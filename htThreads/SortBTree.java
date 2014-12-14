package htThreads;

/**
 * Created by forenc on 13.12.2014.
 */
// класс принимающий для срртировки дерево объектов
public class SortBTree {
// эта вызываемая рекурсивно функция позволяет сортировщику ускорить обход
    public   void sortDesign(IMyBTree nd) {
        if (nd != null) {
            if (nd.getRight() != null) canoe(nd, nd.getRight());
            else if (nd.getLeft()!=null) canoe(nd, null);
            else if (nd.getRight()== null & nd.getLeft()==null)

                System.out.println("-" + nd.getvalue()+"-");//вывод значений вершины ветки
        }

    }
 // создает рекурсию при обходе, осуществляет "прыжки" на точки входа в ветки
    private void canoe(IMyBTree nr, IMyBTree nl){
       if(nr.getLeft()!=null ) {
           sortDesign(nr.getLeft());
       }
       System.out.print("-" + nr.getvalue() + "-"); //вывод значений ключа сортировки (кроме вершин веток)
        if (nl!=null) sortDesign(nl);
    }
}
