import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by C1507930 on 2015/12/4.
 */
public class MyInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---正在执行的方法：" + method);
        if(args!=null){
            System.out.println("下面是执行该方法时传入的参数：");
            for(Object val:args){
                System.out.println(val);
            }
        }else{
            System.out.println("调用方法没有实参!");
        }
        return null;
    }

    public static void main(String[] args) throws Exception{
        InvocationHandler handler = new MyInvocationHandler();
        Person p = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(),new Class[]{Person.class},handler);
        p.walk();
        p.sayHello("孙悟空");
    }
}
