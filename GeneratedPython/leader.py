from agentThread import AgentThread


class DefaultName(AgentThread):

    def __init__(self, config):
        super(DefaultName, self).__init__(config)
        self.start()

    def initialize_vars(self):
        self.locals = {}
        self.voted = False
        self.leader = None
        self.create_aw_var('candidate', int)

    def loop_body(self):
        if not self.locals['voted']:
            self.lock()
            if self.read_from_shared('candidate', None) < self.pid():
                self.write_to_shared('candidate', None, self.pid())
            else:
                self.locals['leader'] = self.read_from_shared('candidate', None)

            self.locals['voted'] = True
            self.unlock()
            return
        if self.locals['voted']:
            self.locals['leader'] = self.read_from_shared('candidate', None)
            return
