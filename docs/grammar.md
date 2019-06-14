

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

# Variable Declaration 

Variables must either be declared as local, allread or allwrite.

Local means that a variable cannot be seen by other bots, it can only be seen by the bot with the variable.

allread means that other bots may read from the variable, but other bots may not write to the variable.  The variable owner may still write to the bot.

allwrite means any bot may write to the variable.

Variables need to have a type and must start with a lower case letter.
Variables may also be given an initial value.


```
allwrite:
  int a
  boolean b
    
allread:
  int c
  int d
        
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

# Variable usage

Local variables may be written to and read from like in other languages.  Shared variables (allwrite/allread) must always have an associated robot id with them.

For instance if `x` is a shared variable, then x is assigned as, 

```
x[pid] = 12
```

if `x` is local, then

```
x = 12
```
is sufficient.
