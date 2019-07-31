from src.harness.agentThread import AgentThread


class DefaultName(AgentThread):

    def __init__(self, config):
        super(DefaultName, self).__init__(config, None)
        self.start()

    def initialize_vars(self):
        self.locals = {}
        self.locals['tries'] = 1
        self.locals['dest'] = self.pos3d(0.0, 0.0, 1.0)
        self.locals['land'] = self.pos3d(0.0, 0.0, 0.0)

    def loop_body(self):
        if self.locals['tries'] == 1:
            self.write_to_actuator('Motion.target', self.locals['dest'])
            self.locals['tries'] = 2
            return
        if self.locals['tries'] == 2:
            self.write_to_actuator('Motion.target', self.locals['land'])
            self.locals['tries'] = 3
            self.stop()
            return
