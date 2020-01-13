KoordLanguage
=============

.. image:: https://img.shields.io/github/license/cyphyhouse/KoordLanguage
    :alt: License
.. image:: https://img.shields.io/travis/cyphyhouse/KoordLanguage
    :alt: Build Status
    :target: https://travis-ci.org/cyphyhouse/KoordLanguage

KoordLanguage is the front-end for the CyPhyHouse_ project.
KoordLanguage consists of our Koord programming language for distributed
robotic applications as well as the tools for compilation, analysis, and
optimizations.

.. _CyPhyHouse: https://cyphyhouse.github.io/


Website and Documentation
-------------------------

KoordLanguage is part of the CyPhyHouse project, and Koord programs require
other components to be deployed to hardware devices or tested in simulation.
Please visit following websites for detail usages.

Broad overview of CyPhyHouse project is available at:

  https://cyphyhouse.github.io/

Or you can find the documentation at:

  https://cyphyhouse.rtfd.io/


License
-------

KoordLanguage is licensed under the terms of the NCSA License (see the file
`LICENSE <LICENSE>`_).


.. include-start-after

Quick start using JAR package
=============================


This 

Requirement
-----------

+ Java Runtime Environment 11 (JRE 11) or above

.. todo::
    Link to JAR file on GitHub repo release


Compile JAR package from Source Code
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

Run following command to compile and create the JAR flie::

    $ mvn package

The created JAR file should be under ``target`` folder following the name
pattern ``koord-*-jar-with-dependencies.jar``.
With the JAR file, please follow the instructions with pre-compiled JAR file to
run Koord compiler.

