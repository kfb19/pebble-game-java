  
# Pebble Game

## Introduction


## Prerequisites

Developed in Java *version here*

The user needs to have...

The user also needs the correct version of Java installed. 

## Installation

There is no prior instillation required for this program, other than the correct version of Java and the JVM. 

## Getting Started 

Use command line...

```bash

```

## Developer Documentation
Classes: 
1. PebbleGame.java 
2. User.java - this class contains details about the user playing the game. 
Functions:
    - User() - this function is the constructor for creating an oject of the User class. It cals the setPebbles method to initialize the pebbles held by the user at the start of the game (zero). 
    - setPebbles() - this function is the setter method for the private attribute 'pebbles'. It initially sets an empty ArrayList. 
    - getPebbles() - this function is the getter method for the private attribute 'pebbles'. It returns the ArrayList containing the pebbles the user holds - pebbles. 
    - getTotal() - this function returns the total value of the weights of all pebbles held by the user, i.e. contained in the pebbles ArrayList. It loops through the arraylist, adding each item to a total, which is then returned when every item in the ArrayList has been added. 
3. BlackBag.java - this class contains details about the black bags used to play the game. 
Functions: 
    - BlackBag(File file) - this function is the constructor for creating an object of the BlackBag class. It take an input of the file containing the details of what is in the black bag, and calls the setContents method to set the contents of the bag. 
    - setContents(File file) - this function is the setter method for the private attribute 'contents'. It opens the file passed in as a parameter, and each number (pebble weight/value) in the file is added to the contents ArrayList, until it has gone through every number in the file. 
   - setWhiteBag(WhiteBag whiteBag) - this function is the setter method for the whiteBag parameter. It takes an input of a white bag and sets this to correspond with the black bag object being created. 
   - getContents() - this function is the getter method for the private attribute 'contents'. It returns the contents ArrayList (which contains the weights of the pebbles in the black bag). 
   - getNoRocks() - this function is the getter method for the number of rock currently in the bag. It returns the integer value of the size of the bag (in rocks). 
   - getWhiteBag() - this function is the getter method for the white bag corresponding to the selected black bag. It returns the white bag object. 
   - getBagName() - this function is the getter method for the name of the black bag. It returns the char name of the bag. 
   - takeRock(int pos) - this funcion takes the position of the rock to be selected from the bag, and selects it and returns the pebble selected. If the black bag is empty, it empties the contents of the corresponding white bag into the black bag. 
4. WhiteBag.java - this class contains details about the white bags used to play the game. 
Functions: 
    - WhiteBag() - this function is the constructor for creating a WhiteBag object. It calls the setContents method to initialize the contents of the bag. 
   - setContents() - this function is the setter method for the private attribute 'contents'. It initally sets the contents of the bag to an empty ArrayList, as there are zero items in the bag at the start of the game. 
   - getContents() - this function is the getter method for the private attribute 'contents'. It returns the contents ArrayList, containing the weights of the pebbles in the bag. 

For more information please look at the attached JavaDocs. 

## Testing



## Authors 

- Kate Belson (Undergraduate Student studying BSc Computer Science at the University of Exeter)
- Michael Hills (Undergraduate Student studying BSc Computer Science at the University of Exeter)

## Handle

https://github.com/kfb19/pebble-game

## Publish Date 

- Version 0.0.1 was published on 

## License
[MIT](https://choosealicense.com/licenses/mit/)

Please look in the LICENSE folder for more information. 
