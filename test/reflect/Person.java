package test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Person {

	private int id;
	private String name;
	private double money = 1200;
	
	public Person(){
		
	}
	
	public Person(int id, String name, double money) {
		this.id = id;
		this.name = name;
		this.money = money;
	}



	public void show(){
		System.out.println(this.name);
		
	}
	
	public void rich(){
		if(this.money>1000.0){
			System.out.println("rich");
			
		}else{
			System.out.println("notRich");
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public static void main(String[] args) throws IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		Field[] fields = Person.class.getDeclaredFields();
		for(Field field:fields){
			System.out.println(field.getType());
		}
		
		try {
			Person tr =  Person.class.newInstance();
			
			//getDeclaredMethods()能获取所有访问限制类型的方法，但不包括继承过来的
			//Method[] methods = tr.getClass().getDeclaredMethods();
			
			Method[] methods = tr.getClass().getMethods();
			for(Method method:methods){
				if(method.getName().equals("rich")){
					method.invoke(tr, new Object[0]);
				}
			}
			
			Constructor<?>[] constructors = Person.class.getDeclaredConstructors();
			for(Constructor<?> constructor:constructors){
				System.out.println(constructor);
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
