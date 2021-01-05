# PRS
This is the semester's final project for "POO" course(Java Object Oriented Programming, Java OOP) of Université de Paris in 2020/21. 
The main purpose is to implement a game which likes King.com's "Pet Rescue Saga". 


## Getting started:
### Prerequisites
   - Java JRE 8

### Download
1) Download this respectory on your own machine or clone it with the following github SSH key: </br>
`git@github.com:junli-ye/PRS.git` <br>
or with HTTP address: <br>
`https://github.com/junli-ye/PRS.git`

2) Open the terminal and switch to the directory where the game folder is located (normally it's `PRS-master/src`)

### How to build

In the terminal, enter `javac controller/*.java entity/*.java view/*.java`

### Run
In the terminal, enter `java controller/Play`

## Main rules
This game has two main rules. Players can easily start the game by following these two simple rules.
- Elimination rule: If a square of the same colour appears in a row or column, it can be eliminated.
- End rule: The game is won when all the animal cubes have reached the ground (bottom of the game screen). The game is lost when there are no more blocks to be eliminated, but there are still animals that have not reached the ground.

## Authors
   - YE Junli, 21962349, junli.ye@etu.u-paris.fr
   - LI Songqiao, 22013160, songqiao.li@etu.u-paris.fr
   
## Architecture
````
. 
├── PRS.iml
├── README.md
├── img
│   ├── a.jpg
│   ├── b.jpg
│   ├── bgp.jpg
│   ├── blue.png
│   ├── c.jpg
│   ├── d.jpg
│   ├── e.jpg
│   ├── green.jpeg
│   ├── orange.png
│   ├── red.jpeg
│   └── yellow.png
└── src
    ├── controller
    │   ├── Game.java
    │   └── Play.java
    ├── entity
    │   ├── Animal.java
    │   ├── AnimalBlock.java
    │   ├── Block.java
    │   ├── BlockFactory.java
    │   ├── Board.java
    │   ├── Color.java
    │   ├── Location.java
    │   └── NormalBlock.java
    └── view
        ├── GamePanel.java
        └── View.java
````

## Comments and suggestions
Although this project is a term assignment, we have still chosen to open source it on github in the hope of getting 
comments and suggestions from fellow students, professors or other professionals.
### If you are a professor or professional
Please give us your advices directly to our email addresses
### If you want to make some changes
Please fell free to create your own branch named like `yourName_branchName` 

