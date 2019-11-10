# quarkus-issue
Reproduces [Issue #5354 from quarkusio](https://github.com/quarkusio/quarkus/issues/5354).

# steps to reproduce

Clone this repo

     $ git clone git@github.com:brunoabdon/quarkus-issue.git
     
Build dependency-a


    $ cd quarkus-issue
    $ dependency-a/
    $ mvn package install

Build dependency-b

    $ cd ../dependency-b/
    $ mvn package install
    
Build the quarkus-app

    $ cd ../quarkus-app/
    $ mvn quarkus:dev

And, then, see the stacktrace
<pre>
22:10:21,454 ERROR [io.qua.dev.DevModeMain] Failed to start Quarkus: java.lang.ExceptionInInitializerError
	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
	at java.lang.Class.newInstance(Class.java:442)
	at io.quarkus.runner.RuntimeRunner.run(RuntimeRunner.java:142)
	at io.quarkus.dev.DevModeMain.doStart(DevModeMain.java:177)
	at io.quarkus.dev.DevModeMain.start(DevModeMain.java:95)
	at io.quarkus.dev.DevModeMain.main(DevModeMain.java:66)
Caused by: java.lang.RuntimeException: Failed to start quarkus
	at io.quarkus.runner.ApplicationImpl.<clinit>(ApplicationImpl.zig:326)
	... 9 more
Caused by: java.lang.LinkageError: loader constraint violation: loader (instance of sun/misc/Launcher$AppClassLoader) previously initiated loading for a different type with name "com/github/brunoabdon/quarkus/ReturnType"
	at java.lang.ClassLoader.defineClass1(Native Method)
	at java.lang.ClassLoader.defineClass(ClassLoader.java:763)
	at java.security.SecureClassLoader.defineClass(SecureClassLoader.java:142)
	at java.net.URLClassLoader.defineClass(URLClassLoader.java:467)
	at java.net.URLClassLoader.access$100(URLClassLoader.java:73)
	at java.net.URLClassLoader$1.run(URLClassLoader.java:368)
	at java.net.URLClassLoader$1.run(URLClassLoader.java:362)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.net.URLClassLoader.findClass(URLClassLoader.java:361)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:338)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	at java.lang.Class.getDeclaredMethods0(Native Method)
	at java.lang.Class.privateGetDeclaredMethods(Class.java:2701)
	at java.lang.Class.getDeclaredMethods(Class.java:1975)
	at org.jboss.resteasy.spi.metadata.ResourceBuilder.processDeclaredSetters(ResourceBuilder.java:1129)
	at org.jboss.resteasy.spi.metadata.ResourceBuilder.processSetters(ResourceBuilder.java:1078)
	at org.jboss.resteasy.spi.metadata.ResourceBuilder.fromAnnotations(ResourceBuilder.java:918)
	at org.jboss.resteasy.spi.metadata.ResourceBuilder.getRootResourceFromAnnotations(ResourceBuilder.java:878)
	at org.jboss.resteasy.plugins.server.resourcefactory.POJOResourceFactory.<init>(POJOResourceFactory.java:40)
	at org.jboss.resteasy.core.ResourceMethodRegistry.addPerRequestResource(ResourceMethodRegistry.java:88)
	at org.jboss.resteasy.core.ResteasyDeploymentImpl.registration(ResteasyDeploymentImpl.java:474)
	at org.jboss.resteasy.core.ResteasyDeploymentImpl.startInternal(ResteasyDeploymentImpl.java:289)
	at org.jboss.resteasy.core.ResteasyDeploymentImpl.start(ResteasyDeploymentImpl.java:90)
	at io.quarkus.resteasy.runtime.standalone.ResteasyStandaloneRecorder.staticInit(ResteasyStandaloneRecorder.java:85)
	at io.quarkus.deployment.steps.ResteasyStandaloneBuildStep$staticInit27.deploy_0(ResteasyStandaloneBuildStep$staticInit27.zig:826)
	at io.quarkus.deployment.steps.ResteasyStandaloneBuildStep$staticInit27.deploy(ResteasyStandaloneBuildStep$staticInit27.zig:845)
	at io.quarkus.runner.ApplicationImpl.<clinit>(ApplicationImpl.zig:312)
</pre>
