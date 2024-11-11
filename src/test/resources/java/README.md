# Java
### Check Java Version Directly
    java -version
    java --version
### Find JAVA_HOME Path
    /usr/libexec/java_home
### Check System-Wide Environment Variables
    echo $JAVA_HOME
### Locate Java Installation Path
    which java
### Check for Multiple Java Versions
    /usr/libexec/java_home -V
### Open the .zshrc file in a text editor vi/nano
    export JAVA_HOME=$(/usr/libexec/java_home)
    export JAVA_HOME=$(/usr/libexec/java_home -v 11)
    export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-11.0.10.jdk/Contents/Home
    export JAVA_HOME="/Library/Java/JavaVirtualMachines/jdk-11.0.10.jdk/Contents/Home"
    export JAVA_HOME="$(brew --prefix openjdk@17)"
    export PATH="$JAVA_HOME/bin:$PATH"


### Install JDK 17
    brew install openjdk@17
    brew list --versions
    brew uninstall openjdk@17
    brew info openjdk@17
    brew list --versions openjdk@17
    brew --prefix openjdk@17
    brew link --force --overwrite openjdk@17
    export JAVA_HOME="$(brew --prefix openjdk@17)"
    /opt/homebrew/bin/brew
    export PATH="/opt/homebrew/bin/brew"

    **Apply the changes by reloading .zshrc**
    source ~/.zshrc

**Java 7 (Released 2011)**
**Java 8 (Released 2014)**
Lambda Expressions
Stream API
**Java 11 (Released 2018)**
Local Variable Type Inference (var)
New String Methods
HTTP Client API:
**Java 17 (Released 2021)**
Sealed Classes
Pattern Matching for instanceof
Records
Enhanced Switch Statements
Removal of Further Deprecated APIs

### Access Modifiers
public
Visibility: Accessible from any other class, regardless of the package.
Usage: Can be applied to classes, methods, fields, and constructors.
private
Visibility: Accessible within the same package and by subclasses, even if they are in different packages.
Usage: Can be applied to methods, fields, and constructors (not applicable to top-level classes)
protected
Visibility: Accessible only within the same class.
Usage: Can be applied to methods, fields, and constructors (not applicable to top-level classes)
default
Visibility: Accessible only within the same package (no keyword needed).
Usage: Can be applied to classes, methods, fields, and constructors.

## OOPS
### Abstract
An abstract class is a class that cannot be instantiated on its own and may contain both abstract methods (without a body) and non-abstract methods (with a body).
Abstract methods in an abstract class must be implemented by any concrete subclass.
Abstract classes can have constructors, fields, and methods (both abstract and concrete)
### Interface
An interface is a collection of abstract methods that any class implementing the interface must provide implementations for.
Since Java 8, interfaces can also include default and static methods with implementations.
Interface fields are implicitly public, static, and final (constants)
### Encapsulation
Encapsulation is the practice of wrapping data (variables) and methods (functions) into a single unit, typically a class. 
It restricts direct access to some components, which is essential for protecting an object’s internal state. 
Encapsulation is usually achieved by making variables private and providing public getters and setters to control access.
### Polymorphism
Polymorphism allows objects to be treated as instances of their parent class rather than their actual class. 
This enables a single function or method to work in different ways depending on the actual object that invokes it. 
Polymorphism comes in two forms: compile-time (method overloading) and runtime (method overriding)




