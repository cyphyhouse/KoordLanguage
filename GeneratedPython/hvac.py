from agentThread import AgentThread


class DefaultName(AgentThread):

    def __init__(self, config):
        super(DefaultName, self).__init__(config)
        self.start()

    def initialize_vars(self):
        self.locals = {}
        self.write_to_actuator('HVAC.switch', 1)

    def loop_body(self):
        if (True):
            if (self.read_from_sensor('HVAC.temp') > 70.0):
                if (self.read_from_sensor('HVAC.temp') < 75.0):
                    self.write_to_actuator('HVAC.switch', -1)
                else:
                    self.write_to_actuator('HVAC.switch', -2)

            else:
                self.write_to_actuator('HVAC.switch', 1)

            return
