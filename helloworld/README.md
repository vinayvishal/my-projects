# An enterprise application consisting of one or more web module and EJBs.The application intends to validate the context-path of the bundled web module when deployed on Glassfish in various scenarios.

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
