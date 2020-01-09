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

Installation
============

The parser is written in Java and uses Antlr.
This project uses Maven.
Do a ``git clone`` somewhere, then run ``mvn install`` to build.
Documentation should be generated at ``target/apidocs/``.

.. toctree::
   :maxdepth: 1

   parser.rst
   codegeneration.rst
   analysis.rst

