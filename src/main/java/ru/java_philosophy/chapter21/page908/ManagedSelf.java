package ru.java_philosophy.chapter21.page908;

public class ManagedSelf implements Runnable{

    private int countDown = 5;
    /**
     * Thread t;
     * */
    Thread t = new Thread(this);

    public ManagedSelf(){
        /**t = new Thread(this);*/
        t.start();
    }

    public String toString(){
        return Thread.currentThread().getName() + "("+countDown+")";
    }

    @Override
    public void run() {
        while (true){
            System.out.println(this);
            if (--countDown == 0){
                System.out.println("END " + this);
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++){
            new ManagedSelf();
        }
    }
}
