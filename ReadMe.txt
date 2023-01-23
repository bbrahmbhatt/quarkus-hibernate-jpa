Project Directory : C:\sigdev\quarkus-hibernate-jpa

P:\>which java
/c/devsw/Java/openjdk-11.0.2_windows-x64_bin/jdk-11.0.2/bin/java

P:\>java -version
openjdk version "11.0.2" 2019-01-15
OpenJDK Runtime Environment 18.9 (build 11.0.2+9)
OpenJDK 64-Bit Server VM 18.9 (build 11.0.2+9, mixed mode)

P:\>which mvn
/c/devsw/apache-maven-3.8.6/bin/mvn

P:\>mvn -version
Apache Maven 3.8.6 (84538c9988a25aec085021c365c560670ad80f63)
Maven home: C:\devsw\apache-maven-3.8.6
Java version: 11.0.2, vendor: Oracle Corporation, runtime: C:\devsw\Java\openjdk-11.0.2_windows-x64_bin\jdk-11.0.2
Default locale: en_US, platform encoding: Cp1252
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"

Make Development environment is setup as below 
JAVA_HOME and JDK_HOME pointing to openjdk 11 : C:\devsw\Java\openjdk-11.0.2_windows-x64_bin\jdk-11.0.2
GRAALVM_HOME is pointing to C:\devsw\Java\graalvm-ce-java11-22.3.0
pom.xml is using <maven.compiler.source>11</maven.compiler.source> and <maven.compiler.target>11</maven.compiler.target>


Run these command in sequence 
------------------------------
cd C:\sigdev\quarkus-hibernate-jpa
set "JAVA_HOME=C:\devsw\Java\openjdk-11.0.2_windows-x64_bin\jdk-11.0.2"
set "GRAALVM_HOME=C:\devsw\Java\graalvm-ce-java11-22.3.0"
mvn clean
mvn install
mvnw quarkus:dev

