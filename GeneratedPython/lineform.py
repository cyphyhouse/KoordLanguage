from src.harness.agentThread import AgentThread


class DefaultName(AgentThread):

    def __init__(self, config, motion_config):
        super(DefaultName, self).__init__(config, motion_config)
        self.start()

    def initialize_vars(self):
        self.locals = {}
        self.create_ar_var('mypos', list, None)
        self.write_to_shared('mypos', self.pid(), self.read_from_sensor('Motion.position'))

    def loop_body(self):
        if (True):
            self.write_to_shared('mypos', self.pid(), self.read_from_sensor('Motion.position'))
            if (self.pid() != 0 and self.pid() != self.num_agents() - 1):
                self.write_to_actuator('Motion.target', self.midpoint(self.read_from_shared('mypos', self.pid() + 1), self.read_from_shared('mypos', self.pid() - 1)))

            return
