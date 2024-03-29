Java 是一门面向对象的语言
java8: 函数式编程:
并行开发/基于事件的开发:

	$(function(){
		$('.click').click(function(){
			foo();
		})
	});

λ表达式基本语法: 
1. 参数列表 -> 表达式
   ア)参数列表的规范:
   a) 如果没有参数, ()必须保留;
   b) 如果只有一个参数, 而且写了参数类型,()不能省略;
   c) 如果没有写参数类型,()可以省略,直接写参数 x->foo();
   d) 如果有两个或多个参数, 无论写没写参数类型, ()都不可以省略;
   e) 如果参数要加修饰符, 参数一定要写出完整的类型和();
   イ)表达式的规范:
   a) 如果表达式的内容只有一行, 不需要写{}, 不能写return;
   b) 如果表达式的内容超过一行, 必须用{}包裹, 并且如果方法需要一个返回值, 就要写return去返回;
   ウ)变量类型: 
   a) 参数;
   b) 局部变量;
   c) 自由变量(不是表达式的参数,也不是表达式中声明的变量);
   lambda表达式中的自由变量会被保存, 无论什么时候执行lambda表达式都可以使用
   注意:  
   1.这些值不能被修改, (可以看做内部类使用外部成员变量, 这个变量要用final修饰), 操作自由变量的代码块, 称为闭包;
   2.参数和局部变量的使用方式,和普通的变量的使用方式相同;
   3.lambda表达式中的this, 指向lambda表达式的方法中的this,(如果是内部类的话,内部类的指向应该是该内部类,而不应该是外部的方法)
   エ) 函数式接口
   1. 能够写lambda表达式的地方, 应该是一个接口,且接口中只有一个抽象方法;
   2. 在java中, 把只有一个抽象方法的接口称为函数式接口, 如果一个接口是函数式接口, 我们可以在接口上添加@FunctionalInterface来标记这是一个函数式接口;
   3. 无论是否用@FunctionalInterface来标记, 只要满足函数式接口的定义的接口, java都会把这个接口当做函数式接口;
   4. 加了@FunctionalInterface标记的好处:
   	1) 编译器会检查,(如果在里面添加其他的方法, 编译器会报错)
   	2) 生成javadoc时,会自动生成函数式接口的标识;
   5. 简化函数式接口的使用是java中提供lambda表达式唯一的作用;
   6. 所谓的接口中只有一个抽象方法, 如果实现了Object中的方法如toString(), equals等, java编译器一样会认为这个接口是一个函数式接口, 也就是说实现这类的方法并不影响其作为一个函数式接口, 
   7. lambda表达式中的异常处理: 
    1) 要么直接在表达式中处理,try...catch;
    2) 要么在接口的方法中声明抛出 throws;
   オ) 方法引用: 
   1) 类::静态方法;
   2) 对象::方法;
   3) 静态方法;
   カ) 构造器引用:需要有一个无参的构造
   1) 类::new 构造器引用对应的函数式接口, 里面的方法格式一定是返回一个对象且方法没有参数;
   キ) 接口的默认方法(允许在接口中写实现的方法)
    1) 可以使用接口实现多重继承;
    2) 如果两个接口中出现了相同签名的默认方法, 子类必须重写这个方法, 指定使用哪个父接口的默认实现;
    3) 如果父类中一个方法和接口中一个默认方法有相同的方法签名, 那么使用父类里面的方法, 所以不要指望使用接口中的默认方法去覆盖父类的相同签名的方法
    4) 接口中可以直接写接口的静态方法了
    5) 常见的模式, 现在有了更好的方式实现;
    	a) 工具类: 以前: 先私有构造, 再用static提供相应的工具方法;
    		现在: 直接用接口并且在接口中写static方法就可以了, 因为接口本来就不可以实例化;
   		b) 适配器设计模式: 不需要实现接口中的大量空方法, 只需要在定义接口时将方法都定义成静态的,这样就实现了以前适配器模式的目标;
