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
