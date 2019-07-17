Program Analysis
================


Control Flow Graph
------------------

Control flow is handled by the class ``BasicBlock``.  It
has two outgoing arrows if it ends in a conditional statement,
and one outgoing arrow if it is a "merge" block.

Timing Analysis
---------------

Timing analysis is done by the algorithm
``worstPath(block) = cost(block) + max(worstPath(block.left), worstPath(block.right))``
with base case being ``worstPath(block) = cost(block)`` if it is a leaf node.



