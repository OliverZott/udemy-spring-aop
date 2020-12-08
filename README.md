# SetUp
1. Copied *spring-demo-annotations* (for **lib** - spring jar files)
2. Add **AspectJ** jar files [(Link)](https://mvnrepository.com/artifact/org.aspectj/aspectjweaver)

# Basics
1. Create **target object** - AccountDAO  
2. Create spring Java **configuration class**  
	- Spring configuration (pure Java) `@Configuration`  
	- Spring AOP proxy support `@EnableAspectJAutoProxy`  
	- Component scan (for components, aspects, ...) `@ComponentScan`  
3. Create **main app** (IoC)  
4. Create an **Aspect** with `@Before`-**Advice**    
	- **Pointcut** ...pattern which specifies **Join Points** interesting for respective Aspect  
	- Use **Pointcut Expressions** to specify join points (**Wildcards** possible)
