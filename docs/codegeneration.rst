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

Example
=======
Koord::

    allwrite:
      int sum = 0
      int numadded = 0
    local:
      boolean added = false
      int finalsum

    adding:
      pre: !added
      eff :
          atomic:
             sum = sum + pid * 2
             numadded = numadded + 1
             added = true
    finalsum:
      pre: numadded == numAgents
      eff :
          finalsum = sum

Generated Python::


    from agentThread import AgentThread


    class DefaultName(AgentThread):

        def __init__(self, config):
            super(DefaultName, self).__init__(config)
            self.start()

        def initialize_vars(self):
            self.locals = {}
            self.locals['added'] = False
            self.locals['finalsum'] = None
            self.create_aw_var('sum', int, 0)
            self.create_aw_var('numadded', int, 0)

        def loop_body(self):
            if not self.locals['added']:
                if not self.lock():
                    return
                self.write_to_shared('sum', None, self.read_from_shared('sum', None) + self.pid() * 2)
                self.write_to_shared('numadded', None, self.read_from_shared('numadded', None) + 1)
                self.locals['added'] = True
                self.unlock()
                return
            if self.read_from_shared('numadded', None) == self.num_agents():
                self.locals['finalsum'] = self.read_from_shared('sum', None)
                return
