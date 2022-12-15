# Project-Euler54-Poker



   Description
    The goal of this project is to read the pocker.txt file and calculate the number of hands won by player 1.
    The full description of the project : projecteuler.net/problem=54
   
   Solution
    The proposed solution is based on object-oriented programming.
    I needed to create the Hand and Card classes.
    A Hand is composed of 5 cards. A card has a color and a value.
    To represent the color and the value of a card I needed to create enumerations.
    I also need to be able to compare cards and compare Hands. To do this I had to implement the Comparable interface.
    To represent the rank of a Hand I created an enumeration named Rank.
    After implementing all the classes, enumerations, methods needed to compare two Hand objects, 
    I read the data from the link (https://projecteuler.net/project/resources/p054_poker.txt), 
    calculated and displayed the number of hands won by Player 1.


