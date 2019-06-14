# Overview

Koord is language that is focused on events and reacting to them. It uses significant whitespace similar to python.

A koord file consists of five main sections:

 - Definitions
 - Modules
 - Variable Declarations
 - Initiation
 - Events

These sections must be declared in this order.

# Definitions

The definitions blocks consists of function declarations. 

# Modules

The modules sections declares sensors and actuators that are to be used. 
Variables can either be an actuator or a sensor, must be declared in the respective block.
Module names must begin with a capital letter.
For instance, using the module Motion:

```
using Motion:
  actuators:
    pos target
  sensors:
    boolean done 
```


## Known Modules 

*Motion* :

```
using Motion:
  actuators:
    pos target
  sensors:
    boolean done 
```

*Log* : 
```
using Log:
  actuators:
    stream stdout
  sensors:
    stream  stdin 
```

To use streams, the `<<` syntax is needed.  

```
stdout << "Hello World"
```

# Variable Declaration 

Variables must either be declared as local, allread or allwrite.

Variables need to have a type and must start with a lower case letter.
Variables may also be given an initial value.
## Local
Local means that a variable cannot be seen by other bots, it can only be seen by the bot with the variable.

## Allread
allread means that other bots may read from the variable, but other bots may not write to the variable.  
The variable owner may still write to the bot. To declare an allread variable, it must be declared as an array.
A read requires array access, with the index representing the id of the bot. An allread variable can only be written to
by using the syntax `varname[pid] = ...`, and will not accept syntax that should be the same thing, such as 
`varname[pid * 1] = ...`

## All Write
allwrite means any bot may write to the variable.


## Example


```
allwrite:
  int a
  boolean b
    
allread:
  int c[]
  int d[]
        
local:
  int e
  float f
```


# Events

Events consist of a label, a pre condition, and an effect. A precondition must be a boolean value.
The precondution must be on the same line as the `pre:` label.

```
dosomething:
  pre:true
  eff:
    hello()
```

# Types

 - pos
 - boolean
 - int
 - float
 - stream
 - arrays

Arrays are declared like in c, not in java, with the brackets going at the end of the variable.

# Example Code

- [Log](../src/test/resources/log.koord)
- [Lineform](../src/test/resources/lineform.koord)
- [Hvac](../src/test/resources/hvac.koord)
- [Shapeform](../src/test/resources/shapeform.koord)

