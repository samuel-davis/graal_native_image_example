# Graal VM Example

## Purpose
I needed a place to test out all the GraalVM features I required on a separate project and this is where it landed. 

## Things within this example. 
- Basic Java Code (Nothing Special to See Here)
- Interfacing with JavaScript, Ruby, R, and Python via Polyglot Context
- Interfacing to C compiled code library from Java. 
- Compilation of Java program into Native Image Executable
- Usage of C Structs - > Java Objects
- Usage of C Enums -> Java Enums
- Usage of C char** and char* to -> Java String and Java String[]


## Things to Do
- Initialize Web Server in Native Image
- Detect if running within Native or from JAR and appropriately load .so files
- Setup package search paths on the compiled binary for easier distribution of the executable. 
- Dynamically add memory from Java to C and vice versa, or at least figure out the correct strategy to do so and when using the GraalVM annotations / functions. 
