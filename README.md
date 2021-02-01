# FightBoat
AP Computer Science A GRASPS assignment  
*by mfmcl and NikolaDatkova*

## GRASPS Task Battleship game
(together with the Unit of Classes & design of programs)

### Goal

Create a strategic game in Java programming language that simulates Battleship on the sea. (Using LIBGDX or a similar framework is fine.)
  

### Role

You are a developer, cooperating in the project of game creation. You work in pairs, maximum is three persons with a clear division of roles. Everyone is writing some part of the code. Everyone understands the partner’s part.
  

### Audience

Students, people interested in gaming, or training their strategy techniques.
  
  
### Situation

Here are a couple of challenges to solve:

First, you need to choose one option:

Version A) You create a java program that offers the game human vs the computer on one Computer. You need to create a system deciding who is moving and how to store data

Version B) You create a java program that links two players on the same network and they play against each other.

The biggest challenge is to find an algorithm for PC to find Human ships.
  
  
### Product

- The game has either one grid or two grids with hidden ships. When one player is playing another is waiting. The program should call who should move.

- Initial position of ships could be horizontal, vertical, diagonal; Not crossing. Human can define his own positions, PC will use re-shuffling method

- You can use Arrays to store data about ships. E.g. 8x8 grid

0 0 3 3 3 0 0 0  
5 4 0 0 0 3 0 0  
5 4 0 0 0 3 0 0  
5 4 0 0 0 3 0 0  
5 4 0 0 0 0 0 0  
5 0 0 0 0 0 0 0  
0 0 0 0 0 0 0 0  
0 0 0 0 0 0 2 2  

- In Version, Human vs PC PC will randomly set 5 ships with different sizes for himself and Player. The player tries to hit the computer’s ships. The computer answers “hit” or “miss”. Computer displays matrix after each move with hits and misses and time.

- In the case of PC, instead of random hitting, develop a smart algorithm to hit human ships.

- In a version for two human players, each player is trying to hit the opponent's flee. Need to use a connection over a network.

- The winner is the one who destroyed the opponent’s ships as first.

### Standards/Criteria
  
  
Your product must meet the following standard (quality):

- [ ] Created documentation with description of game/picture, documented main parts, the definition of team roles. (all together max. 2 pages A4 format) Satisfactory cooperation and division of team roles.

- [ ] A reasonable description of all methods within the source code

- [ ] Using OOP (inheritance, interface, super, this, mutator, accessor) all of these are used reasonably

- [ ] Proper usage of access modifiers and static keywords

- [ ] Working solution

- [ ] Working re-shuffling method

- [ ] Reasonable division of classes into files/folders

- [ ] Create one runnable jar file stored on Github. Shared link with the teach
