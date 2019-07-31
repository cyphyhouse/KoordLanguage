from src.harness.agentThread import AgentThread


class DefaultName(AgentThread):

    def __init__(self, config, motion_config):
        super(DefaultName, self).__init__(config, motion_config)
        self.start()

    def initialize_vars(self):
        self.locals = {}
        self.locals['voted'] = False
        self.locals['leader'] = None
        self.create_aw_var('candidate', int, -1)
        self.initialize_lock('voted')

    def loop_body(self):
        if not self.locals['voted']:
            if not self.lock('voted'):
                return
            if self.read_from_shared('candidate', None) < self.pid():
                self.write_to_shared('candidate', None, self.pid())
            else:
                self.locals['leader'] = self.read_from_shared('candidate', None)

            self.locals['voted'] = True
            self.unlock('voted')
            return
        if self.locals['voted']:
            self.locals['leader'] = self.read_from_shared('candidate', None)
            return
