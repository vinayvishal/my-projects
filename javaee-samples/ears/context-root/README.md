# Description
An enterprise application consisting of one or more web modules and EJBs.The application intends to validate the context-path of the bundled web module when deployed on Glassfish in various scenarios.

# Expected Behavior
## Java EE 7 Platform Specification
> Assign a context root for each web module included in the Java EE
application. The context root is a relative name in the web namespace for
the application. Each web module must be given a distinct and nonoverlapping name for its context root. The web modules will be assigned a
complete name in the namespace of the web server at deployment time. If
there is only one web module in the Java EE application, the context root
may be the empty string. If no deployment descriptor is included in the
application package, the context root of the web module will be the module
name. See the Servlet specification for detailed requirements of context
> root naming.


## Scenario 1 
The enterprise application contains a single web module and no context-path has been specified.
This is how deployment descriptor of this application looks like:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE application PUBLIC
        "-//Sun Microsystems, Inc.//DTD J2EE Application 1.3//EN"
        "http://java.sun.com/dtd/application_1_3.dtd">
<application>
  <display-name>helloworld-ear</display-name>
  <module>
    <ejb>ejb-impl-1.0-SNAPSHOT.jar</ejb>
  </module>
  <module>
    <web>
      <web-uri>hello-1.0-SNAPSHOT.war</web-uri>
      <context-root>/hello</context-root>
    </web>
  </module>
</application>
```
**com.example.helloworld.web.HelloServlet**

```Java
@WebServlet(urlPatterns = "/")
public class HelloServlet extends HttpServlet {
    @EJB
    private Hello hello;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(hello.hello());
    }
}
```
**module name**

```xml
<modelVersion>4.0.0</modelVersion>
    <packaging>war</packaging>
    <artifactId>hello</artifactId>
```    
Context path for single web module in this case is :

http://localhost:8080/hello

## Scenario 2
The ear contains another web module and no context-path has been specified.
The deployment description of this application in this case:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE application PUBLIC
        "-//Sun Microsystems, Inc.//DTD J2EE Application 1.3//EN"
        "http://java.sun.com/dtd/application_1_3.dtd">
<application>
  <display-name>helloworld-ear</display-name>
  <module>
    <ejb>ejb-impl-1.0-SNAPSHOT.jar</ejb>
  </module>
  <module>
    <web>
      <web-uri>hello-1.0-SNAPSHOT.war</web-uri>
      <context-root>/hello</context-root>
    </web>
  </module>
  <module>
    <web>
      <web-uri>hello2-1.0-SNAPSHOT.war</web-uri>
      <context-root>/hello2</context-root>
    </web>
  </module>
</application>
```
Context path for web modules in this case respectively are as shown below:

http://localhost:8080/hello

**module name**

```xml
<modelVersion>4.0.0</modelVersion>
    <packaging>war</packaging>
    <artifactId>hello</artifactId>
```    

**com.example.helloworld.web.HelloServlet**

```Java
@WebServlet(urlPatterns = "/")
public class HelloServlet extends HttpServlet {
    @EJB
    private Hello hello;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(hello.hello());
    }
}
```

http://localhost:8080/hello2

**module name**

```xml
<modelVersion>4.0.0</modelVersion>
    <packaging>war</packaging>
    <artifactId>hello2</artifactId>
```    

**com.example.helloworld.web.HelloServlet2**

```java
@WebServlet(urlPatterns = "/")
public class HelloServlet2 extends HttpServlet {
    @EJB
    private Hello hello;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(hello.helloAgain());
    }
}
```

