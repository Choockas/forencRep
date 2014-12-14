package htThreads;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by forenc on 05.12.2014 2:46
*  Образец класса двоичного дерева, принимающего объекты наследующие класс Comparable
 */

public class MyBTree  <T extends Comparable<T>> implements IMyBTree<T>{

    private  IMyBTree left;
    private  IMyBTree right ;
    private  final T  value;
    private AtomicInteger count = new AtomicInteger(1);
//    Конструктор принимает при создании дерева первый объект, тип его определяется в вызывающем модуле
    public MyBTree( T ivalue) {
        this.value = ivalue;
    }

//переопределяем функции интерфейса класса
    @Override
    public IMyBTree getLeft() {
        return this.left;
    }

    @Override
    public IMyBTree getRight() {
        return this.right;
    }

    @Override
    public T getvalue() {
        return this.value;
    }

    @Override  // в стандртную процедуру заполнения дерева включили функцию инкркмента, оптимизированую для thread
    public void add(T value) {
        if (value.equals(this.value)) {
            increment();
        }
        else if ( value.compareTo(getvalue())< 0) {
            addLeft(value);
        }
        else{
           addRight(value);
        }
    }
//Инкримент атомарным типом предотвращает колизии в потоках
    @Override
    public AtomicInteger getcount() {
        return count;
    }

      private void addLeft(T value) {
        if (getLeft() == null){
        setLeft(new MyBTree<>(value) );
        }else getLeft().add(value);
    }

    private void addRight(T value) {
        if (getRight() == null){
        setRight(new MyBTree<>(value) );
        }else getRight().add(value);
    }

    private void increment(){
       getcount().incrementAndGet();
        Thread.yield(); // оптимизирует выполнение в потоке
        setCount(count);
    }

    public void setLeft(IMyBTree left) {
        this.left = left;
    }

    public void setRight(IMyBTree right) {
        this.right = right;
    }

    public void setCount(AtomicInteger count) {
        this.count = count;
    }




}
