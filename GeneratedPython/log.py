from src.harness.agentThread import AgentThread


class DefaultName(AgentThread):

    def __init__(self, config, motion_config):
        super(DefaultName, self).__init__(config, motion_config)
        self.start()

    def initialize_vars(self):
        self.locals = {}

    def loop_body(self):
        if True:
            self.log("hi")

            self.log("1 + 1 = ")
            self.log(2)

            return
