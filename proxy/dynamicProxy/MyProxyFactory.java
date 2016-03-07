import java.lang.reflect.Proxy;

/**
 * Created by C1507930 on 2015/12/4.
 * 动态代理对象的工厂
 */
public class MyProxyFactory {
    public static Object getProxy(Object target) throws Exception{
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.setTarget(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),handler);
    }
}
