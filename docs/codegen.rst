Code Generation
===============

Example Koord::

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
