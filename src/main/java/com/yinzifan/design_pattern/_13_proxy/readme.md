代理模式的基本概念及分类: 为其他对象提供一种代理, 以控制这个对象的访问
远程代理,虚拟代理,保护代理,智能引用代理



Spring AOP 的优点

RMI框架远程调用框架, 支持java语言, 使用的不多.

延迟加载


代理的分类: 分为: 静态代理和动态代理, 

静态代理: 代理和被代理对象在代理之前是确定的, 他们都实现相同的接口或者继承相同的抽象类
动态代理(cglib, jdk)

jdk动态代理: 位于java.lang.reflect包下, 一般主要涉及以下两个类: 
1. Interface InvocationHandler: 该接口中仅定义了一个方法:

	public object invoke(Object obj, Method method, Object[] args);
	在实际使用中, 第一个参数obj一般指代理类, method是被代理的方法, args为该方法的参数数组, 这个抽象方法在代理类中动态实现 
2. Proxy: 该类即为动态代理类

	static Object newProxyInstance(ClassLoader loader, Class[] interfaces, InvocationHandler h):
	返回代理类中的一个实例, 返回后的代理类可以当作被代理类使用(可使用被代理类的再接口中声明过的方法)
实现步骤: 
1. 创建一个实现接口InvocationHandler的类, 它必须实现invoke方法
2. 创建被代理的类以及接口
3. 调用Proxy的静态方法, 创建一个代理类

	Proxy.newProxyInstance(Classloader loader, Class[] interfaces, InvocationHandler h)
4. 通过代理调用方法
	
cglib动态代理: 


cglib和jdk动态代理的区别?
jdk动态代理: 
	1.只能代理实现了接口的类
	2. 没有实现接口的类不能实现jdk的动态代理
cglib动态代理: 
	1. 针对类来实现代理
	2. 对指定目标类产生一个自雷, 通过方法拦截技术拦截所有父类方法的调用
	
动态代理的实现思路: 实现功能: 通过Proxy的newProxyInstance返回代理对象
1. 声明一段源码(动态产生代理)
2. 编译源码(JDK Compiler API), 产生新的类(代理类) 

	//拿到Java编译器
	JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
	/**
	 * diagnosticListener: 用于非致命诊断信息的诊断监听器, 如果为null, 则使用编译器的默认方法来报告诊断信息 
	 * locale: 格式化诊断信息时必要的语言环境, 如果是null, 则使用系统默认的语言环境
	 * charset: 用于解码字节的字符集, 如果为null, 则使用平台默认的字符集
	 * return: 标准的文件管理器
	 */
	StandardJavaFileManager fileMgr = compole.getStandardJavaFileManager(DiagnosticListener diagnosticListener, Locale locale, Charset charset);
	// 根据文件名获得管理文件的数据
	Iterable units = fileMgr.getJavaFileObjects(filename);
	// 编译
	/**
	 * out - 用于来自编译器的其他输出的 Writer；如果为 null，则使用 System.err  
	 * fileManager - 文件管理器；如果为 null，则使用编译器的标准文件管理器  
	 * diagnosticListener - 诊断侦听器；如果为 null，则使用编译器的默认方法报告诊断信息  
	 * options - 编译器选项；null 表示没有选项  
	 * classes - 类名称（用于注释处理），null 表示没有类名称  
	 * compilationUnits - 要编译的编译单元；null 表示没有编译单元   
	 * 返回：  表示编译的对象   
	 * 抛出：   
	 * RuntimeException - 如果在用户提供的组件中发生不可恢复的错误。cause 为用户代码中的错误。   
	 * IllegalArgumentException - 如果给定的任一编译单元具有不同于 source 的类型  
	 */
	CompilationTask t = JavaCompiler.CompilationTask getTask(Writer out, JavaFileManager fileManager, DiagnosticListener<? super JavaFileObject> diagnosticListener, Iterable<String> options, Iterable<String> classes, Iterable<? extends JavaFileObject> compilationUnits)
	// 使用给定组件和参数创建编译任务的 future。该编译可能没有完成，正如 CompilationTask 接口中所述。   
	// 如果提供了文件管理器，则它必须能够处理 StandardLocation 中定义的所有位置。   
	t.call();
	fileMgr.close();
	//load 到内存中
	ClassLoader cl = ClassLoader.getSystemClassLoader();
	Class c = cl.loadClass("com.yinzifan.xxx.");
	System.out.println(c.getName());
	Constructor constructor = c.getConstructor(ParammeterTypes types);
	return constructor.newInstance(new Obj());
	
3. 将这个类load到内存当中, 产生一个新的对象(代理对象)
4. return 代理对象


