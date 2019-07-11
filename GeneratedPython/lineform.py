from agentThread import AgentThread


class DefaultName(AgentThread):

    def __init__(self, config):
        super(DefaultName, self).__init__(config)
        self.start()

    def initialize_vars(self):
        self.locals = {}
        self.create_ar_var('x', list)
        self.write_to_shared('x', self.pid(), self.read_from_sensor('Motion.position'))

    def loop_body(self):
        if (True):
            if (self.pid() != 0 and self.pid() != self.num_agents() - 1):
                self.write_to_shared('x', self.pid(), self.midpoint(self.read_from_shared('x', self.pid() + 1),
                                                                    self.read_from_shared('x', self.pid() - 1)))
                self.write_to_actuator('Motion.target', self.read_from_shared('x', self.pid()))

            return
