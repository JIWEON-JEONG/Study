package thread;

public class Ramen {
    public static void play(String[] args) {
        try{
            RamenCook ramenCook = new RamenCook(10);
            new Thread(ramenCook,"A").start();
            new Thread(ramenCook,"B").start();
            new Thread(ramenCook,"C").start();
            new Thread(ramenCook,"D").start();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}





