###########################
Koord Programming Framework
###########################

The Koord language is a new language for coordination in bots.

TODO briefly introduce and show example Koord code


**************
Koord Language
**************

.. toctree::
   :maxdepth: 1

   semantics.rst
   grammar.rst

**************
Koord Compiler
**************


Use pre-compiled JAR file
=========================


Requirement
-----------

+ Java Runtime Environment 11 (JRE 11) or above

.. todo::
    Link to JAR file on GitHub repo release



Compile and Install from Source Code
====================================

Requirements
------------

+ Java Development Kit 12 (JDK 12)
+ Maven
+ Python 3.5 or above for testing


Compilation
-----------

The parser is written in Java and uses Antlr.
This project uses Maven.

Run following command to compile and create the JAR flie
::
    $ mvn install

The created JAR file should be under ``target`` folder following the name
pattern ``koord-*-jar-with-dependencies.jar``.
With the JAR file, please follow the instructions with pre-compiled JAR file to
run Koord compiler.


.. toctree::
   :maxdepth: 1

   parser.rst
   codegeneration.rst
   analysis.rst

