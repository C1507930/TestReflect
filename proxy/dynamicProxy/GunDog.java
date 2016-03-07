/**
 * Created by C1507930 on 2015/12/4.
 */
public class GunDog implements Dog {
    @Override
    public void info() {
        System.out.println("这是一只猎狗");
    }

    @Override
    public void run() {
        System.out.println("奔跑迅速");
    }
}
