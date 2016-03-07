/**
 * Created by C1507930 on 2015/12/4.
 */
public class Test {
    public static void main(String[] args) throws Exception{
        //被代理对象，目标
        Dog target = new GunDog();
        Dog dog = (Dog)MyProxyFactory.getProxy(target);
        dog.info();
        dog.run();

        Dog target1 = new GunDog();
        Dog dog1 = (Dog)new MyInvocationHandler(target1).createProxyInstance();
        dog1.info();
        dog1.run();
    }
}
