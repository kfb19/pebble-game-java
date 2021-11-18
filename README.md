  
# Pebble Game

## Introduction

Pebble Game is a program written for a University of Exeter Software Development coursework. The game is played by 1+ players, and involves three white bags and three black bags. The black bags contain pebbles with weights assigned to them, and each black bag has a corresponding white bag. Each user initially picks out 10 pebbles, then as the game progresses, they discard a pebble into a white back and draw another pebble from the black bag. If a black bag empties at any point, the pebbles from the corresponding white bag will be empitied into the black bag. A player has won the game if the combined weights of the pebbles in their hand is exactky 100. Players carry on picking and discarding pebbles until someone has won. 

## Prerequisites

Developed in Java 15.0.1

The user needs the correct version of Java and the JVM (Java Virtual Machine) installed. 

## Installation

There is no prior instillation required for this program, other than the correct version of Java and the JVM. 

## Getting Started 

Extract all the contents from the SoftDev CA.zip and store in a easy to find folder. Then extract all contents from pebblesTest.zip and again store in an easy to find folder.

To run the jar file, first enter the directory you have stored the jar file and input_files folder in using the command line. Then enter the following command:

```bash
java -jar pebbles.jar
```
Note: the files containing the pebbles should be stored in "input_files"
## Developer Documentation

For information on our design choices please look at the enclosed report. For information on the classes and functions this program contains, please look at the attached JavaDocs or the code comments. 

## Testing

Using the command line, enter the directory of where you stored the contents of pebblesTest.zip. E.g:

```bash
cd C:\Users\mjhil\Desktop\Software CA Test 2\pebblesTest
```

Then using the junit and hamcrest jar files provided in the zip, enter the following into the command line to run the tests:

```bash
java -cp "junit-4.13.1.jar;hamcrest-core-1.3.jar;." org.junit.runner.JUnitCore TestSuite
```
Note: do not change any of the file contents
## Authors 

- Kate Belson (Undergraduate Student studying BSc Computer Science at the University of Exeter)
- Michael Hills (Undergraduate Student studying MSc Computer Science at the University of Exeter)

## Handle

https://github.com/kfb19/pebble-game

## Publish Date 

- Version 0.0.1 was published on 10/11/2021. 

## License
[MIT](https://choosealicense.com/licenses/mit/)

Please look in the LICENSE folder for more information. 
