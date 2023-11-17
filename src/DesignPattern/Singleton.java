package DesignPattern;

public class Singleton {
    public static void main(String[] args) {
        SingleObject object = SingleObject.getInstance();
        object.showMessage();
    }
}

class SingleObject {
    private static SingleObject instance = new SingleObject();

    private SingleObject() {
    }

    public static SingleObject getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("hello world!");
    }
}

class SingleObjectLazyUnsafe {
    private static SingleObjectLazyUnsafe instance;

    private SingleObjectLazyUnsafe() {
    }

    public static SingleObjectLazyUnsafe getInstance() {
        if (instance == null) {
            instance = new SingleObjectLazyUnsafe();
        }
        return instance;
    }
}

// 多线程的时候，可能两个线程同时进到instance == null
class SingleObjectLazySafe {
    private static SingleObjectLazySafe instance;

    private SingleObjectLazySafe() {
    }


    public static synchronized SingleObjectLazySafe getInstance() {
        if (instance == null) {
            instance = new SingleObjectLazySafe();
        }
        return instance;
    }
}

// 饿汉式 类在加载的时候就初始化了，浪费内存
class SingleObjectHungry {
    private static SingleObjectHungry instance = new SingleObjectHungry();

    private SingleObjectHungry() {
    }

    public static SingleObjectHungry getInstance() {
        return instance;
    }
}

// 双检锁/双重检验锁（DCL-double-checked locking）
class SingleObjectDCL{
    private volatile static SingleObjectDCL instance;
    private SingleObjectDCL(){}

    public static SingleObjectDCL getInstance(){
        if (instance == null){
            // 进入同步块，保证只有一个线程可以执行下面的代码
            synchronized (SingleObjectDCL.class) {
                // 第二次检查，确保进入同步块之后，实例仍然为null。因为可能在多个线程同时
                // 通过第一次检查，只有一个线程能够获取锁进入同步块，其他线程会在这里面阻塞等待
                if (instance == null) {
                    instance = new SingleObjectDCL();
                }
            }
        }
        return instance;
    }
}

