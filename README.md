<h1 align="center">Random Access Machine</h1>
<h4 align="center">Implementation of a Random Access Machine in Java programming language.</h4>

<p align="center">
  <img alt="ULL" src="https://img.shields.io/badge/University-La%20Laguna-%2354048c?style=flat-square" />  
  <img alt="License" src="https://img.shields.io/github/license/angeligareta/random-access-machine?style=flat-square" />
</p>

## Summary
This project aims to implement a Random Access Machine. The Random Access Machine is an abstract
computational-machine identical to the counter machine but adding the indirect addressing. The machine has a
Program Memory, Data Memory, Input Tape and OutputTape objects to execute a program. Besides it uses the
ArithmeticLogicUnit to do all the calculation. The code documentation can be found [here](https://angeligareta.github.io/RandomAccessMachine/).

## UML Diagram
Here there is an UML Class diagram representing how the project is structured:
![UML Class Diagram](docs/img/uml-diagram.jpg)

## Structure
The classes are divided in:
- **ArithmeticLogicUnit**: abstract class that represents the Arithmetic Logic Unit of the Random Access Machine. It has all the necessary
methods to assign, add, subtract, multiply and divide registers with another registers or with constants.
- **DataMemory**: contains an array of the Data Register that the Random Access Machine will use.
- **DataRegister**: subclass of Register with the Integer data type. Besides it implements a method to change the data of the register.
- **InfiniteMemory**: abstract class that simulates an infinite TreeMap. The subclasses of InfiniteMemory must implement a getter and a setter of that TreeMap.
- **InputTape**: does all the necessary operations with the inputTape. This includes creating the buffer, reading from it and closing it.
- **InstructionType**: enum for all the instructions that our ram machine can have.
- **Operating**: enum for all the operating that our ram machine can have.
- **OutputTape**: does all the necessary operations with the outputTape. This includes creating the buffer, writing in it and closing it.
- **ProgramMemory**: contains the Hash of lines-instruction that represents the program the machine is running.
- **ProgramRegister**: contains the instruction in a register.
- **RandomAccessMachine**: abstract computational-machine identical to the counter machine but adding the indirect addressing. The machine has a Program Memory, Data Memory, Input Tape and OutputTape objects to execute a program. Besides it uses the ArithmeticLogicUnit to do all the calculation.
- **Register**: abstract class that represents a generic type of register and contains a data and a method to read it.
- **StartRandomAccessMachine**: starts a Random AccessMachine depending on the arguments passed to main method.

## Author
<p align="center">
  <a href="https://angeligareta.com" alt="Angel Igareta" target="_blank">
    <img
      style="max-width: 420px"
      src="https://lh3.googleusercontent.com/d/1a8GtvbvSP-kPeUBbFue3xuYZIMffFvFW=w600"
    />
  </a>
</p>
