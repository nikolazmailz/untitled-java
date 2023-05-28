package ru.java_philosophy.chapter21.page908;

public class SimpleThread extends Thread{

    private int countDown = 5;
    public static int countThread = 0;

    public SimpleThread(){
        /***
         * before
         * super();
         * this.countThread = countThread;
         */
        super(Integer.toString(++countThread));
        this.start();
    }

    public String toString(){
        return "#" + getName() + "(" + countDown + ")";
    }

    public void run(){
        /**
         * while (countDown > 0){
         *             countDown--;
         *             System.out.println(this);
         *         }
         * */
        while (true){
            System.out.println(this);
            if(--countDown == 0){
                System.out.println("END " + this);
                return;
            }
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 5 ; i++){
            new SimpleThread();
        }
    }

}
