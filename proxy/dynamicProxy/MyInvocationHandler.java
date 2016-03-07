import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by C1507930 on 2015/12/4.
 * 动态代理，在运行时才知道被代理对象到底是谁
 */
public class MyInvocationHandler implements InvocationHandler {
    //被代理对象是未知类型的，只有在运行时才知道到底是什么具体类型，这就是动态代理
    private Object target;

    public MyInvocationHandler() {
    }

    public MyInvocationHandler(Object target){
        this.target = target;
    }
    public void setTarget(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        DogUtil du = new DogUtil();
        du.method1();
        Object result = method.invoke(target,args);
        du.method2();
        return result;
    }

    public Object createProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
