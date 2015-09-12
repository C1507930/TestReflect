package test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestConstructor {
	public static void main(String[] args) {
		Class<Person> ps = Person.class;
		//获得构造器
		Constructor<?>[] ca = ps.getConstructors();
		System.out.println("构造器名称\t\t参数列表");
		
		//输出构造器名称和参数类型
		for(Constructor<?> tempc:ca){
			System.out.println(tempc.getName()+"\t\t");	
			Class<?>[] pa = tempc.getParameterTypes();
			if(pa.length==0){
				System.out.println("没有参数");
			}else{
				for (Class<?> p : pa) {
					System.out.println(p.getName() + " ");
				}
				
			}
		}
		
		try {
			//使用反射调用无参构造器创建对象
			Person person = (Person) ca[0].newInstance(new Object[0]);
			person.rich();
			//使用反射调用有参构造器创建对象
			person = (Person)ca[1].newInstance(new Object[]{1,"我帅",5500});
			double money = person.getMoney();
			System.out.println(money);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
