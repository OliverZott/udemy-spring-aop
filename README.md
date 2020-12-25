# Content 
- **Advice** type `@Before`
- **Pointcut Exprressions**  
	- Match *method* and/or *return type*  
	- Match *method parameters*  

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
	- *Match methods*... access modifier / return values / package.class.method / parameter
	- **Pointcut Declarations** ... for re-using Pointcut Expressions on several advices
5. Various Advices, depending on joinpoint   
 	- **@Before**  
 	- **@AfterReturning**  
 	- **@AfterThrowing**  
 	- **@After** ... Recent changes in order: [(Link)](https://github.com/spring-projects/spring-framework/issues/25186)  
 	- **@Around** ... `ProceedingJoinPoint`   / ... exception handled, so main app never know exception happened!
 	
6. Adding **Logger** for consistency  
	- logger out-stream instead sysout stream
  
 	
 		
 
 	