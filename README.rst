#############
KoordLanguage
#############

|license|

**Build Status** master: |master| latest commit: |latest|

.. |license| image:: https://img.shields.io/github/license/cyphyhouse/KoordLanguage
    :alt: License
.. |master| image:: https://img.shields.io/travis/cyphyhouse/KoordLanguage/master
    :alt: Build status for master branch
    :target: https://travis-ci.org/cyphyhouse/KoordLanguage/branches
.. |latest| image:: https://img.shields.io/travis/cyphyhouse/KoordLanguage
    :alt: Build status for latest commit
    :target: https://travis-ci.org/cyphyhouse/KoordLanguage

KoordLanguage is the front-end for the CyPhyHouse_ project.
KoordLanguage consists of our Koord programming language for distributed
robotic applications as well as the tools for compilation, analysis, and
optimizations.

.. _CyPhyHouse: https://cyphyhouse.github.io/


*************************
Website and Documentation
*************************

KoordLanguage is part of the CyPhyHouse project, and Koord programs require
other components to be deployed to hardware devices or tested in simulation.
Please visit following websites for detail usages.

Broad overview of CyPhyHouse project is available at:

  https://cyphyhouse.github.io/

Or you can find the documentation at:

  https://cyphyhouse.rtfd.io/


*******
License
*******

KoordLanguage is licensed under the terms of the NCSA License (see the file
`LICENSE <LICENSE>`_).


.. include-start-after

*****************************
Quick start using JAR package
*****************************

Requirements
============

+ Java Runtime Environment 11 (JRE 11) or above
+ JAR file ``koord-*-jar-with-dependencies.jar`` downloaded from here (or
  compiled from source code)

.. todo::
    Link to JAR file on GitHub repo release


Usage
=====

Given a Koord program ``app.krd``, run the following command to generate Python code
``app.py``::

    $ java -jar /path/to/koord-*-jar-with-dependencies.jar app.krd app.py


************************************
Compile JAR package from source code
************************************

Requirements
============

+ Java Development Kit 12 (JDK 12)
+ Maven
+ Python 3.5 or above for testing


Compilation
===========

The parser is written in Java and uses Antlr.
This project uses Maven.

Run following command to build and test the JAR package file::

    $ mvn package

The created JAR file should be under ``target`` folder following the name
pattern ``koord-*-jar-with-dependencies.jar``.
With the JAR file, please follow the instructions in the previous section to run
Koord compiler.

