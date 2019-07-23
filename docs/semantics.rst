---------
Semantics
---------

Distributed Shared Memory
=========================
When variables are dcelared ``allread`` and ``allwrite``, they are in shared memory.
All robots can read and write to ``allwrite`` variables and all robots can read from ``allread``
variables.  ``allread`` variables need to be arrays.
A robot can only write to one element of an allread variable.

Round based Execution
=====================

A program will find the first event that satisfies
the precondition, execute it, then start from the top again.



