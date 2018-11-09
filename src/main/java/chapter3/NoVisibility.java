package chapter3;
public class NoVisibility{

    public static boolean ready;
    public static int number;
    // 输出0的情况在x86上复现不了,因为x86不允许写入重排，也就是ready的写入一定发生在number的写入之后。
    private static class ReaderThread extends Thread{
        public void run(){
            while (!ready){
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args){


        new ReaderThread().start();
        number = 42;
        ready = true;

    }
}