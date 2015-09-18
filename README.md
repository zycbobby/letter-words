# Purpose

Generate letters which is composed by photos you want. It can randomly pick photos from the folder images and output the
composed one to folder output

![image](./sample.png)

# Prerequisite

 - maven3
 - jdk6

# Usage

 - Put images into folder "images"
 - Run following command
 
 
 ```
 mvn clean compile exec:java -Dword=WWWW
 ```
 
 You can specify the word you want to generate
 
 
 Then the output image will be in the output folder.
 
# Issues
 
Some pattern is not existing in src/main/resources/patterns. I need to add it later.
 