# Overview
This repository explores how to use `regex` in Java.  

Generally, we have two methods:
1. Use `regex` in the method `String` prototype.
2. Use `Pattern` class.

# How to use
I am using the IntelliJ for this repository.  
This repository requires `junit`, and the `junit.xml` file can be found in `.idea/libraries/junit.xml.`.

# Regex
## `String` prototype
Several methods are compatible with `regex` from [oracle doc](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html)
```java
String regex = "[0-9]+";
String str = "4353.5490";
boolean match = str.matches(regex); // Pattern.matches(regex, str)
```