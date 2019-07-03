Generation
==========

A Koord program is compiled into a python file.

There are two main components: initiation and events.

The initiation is handled by the function ``initialize_vars`` and contains setup for variables and the code for the
``init`` block.

The events are handled by the function ``loop_body`` and is meant to be called in
a loop.  It finds the first event that satisfies its precondition, executes the code
and then returns.



Sensors and Actuators
=====================

Sensors and actuators get compiled to ``self.read_from_sensor(sensor_name)`` and
``self.write_to_actuator(actuator_name, value)``, which inherit from the parent class.


Variables
=========

Local variables get compiled to ``self.locals[local_variable]``.

Shared variables require distributed memory, so they get compiled to calls to
``self.write_to_shared(var_name, index, value)`` and ``self.read_from_shared(var_name, index)``
which also inherit from the parent class allow it to do distributed memory stuff.


Others
======
Many other things, such as arithmetic operators and constants,
are the same in both python and koord, and do not get transformed at all.

