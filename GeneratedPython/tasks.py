from agentThread import AgentThread


class Task:

    def __init__(self):
        self.loc = None
        self.assignId = None
        self.taskId = None



class DefaultName(AgentThread):

    def __init__(self, config):
        super(DefaultName, self).__init__(config)
        self.start()

    def initialize_vars(self):
        self.locals = {}
        self.locals['i'] = 0
        self.locals['currentRoute'] = None
        self.locals['newTask'] = None
        self.locals['asgn'] = 0
        self.locals['rchd'] = 1
        self.locals['cmplt'] = 2
        self.locals['stage'] = 0
        self.create_aw_var('taskList', list, None)
        self.create_ar_var('routes', list, None)

    def loop_body(self):
        if self.locals['stage'] == self.locals['asgn']:
            self.locals['newTask'] = self.getAvailableNextTask(self.read_from_shared('taskList', None))
            self.locals['currentRoute'] = self.getPathFromTask(self.locals['newTask'])
            if not self.willCollide(self.locals['newTask']):
                self.write_to_shared('routes', self.pid(), self.locals['currentRoute'])
                self.write_to_actuator('Motion.route', self.locals['currentRoute'])
                self.locals['stage'] = self.locals['rchd']

            return
        if self.locals['stage'] == self.locals['rchd'] and self.read_from_sensor('Motion.done'):
            self.locals['stage'] = self.locals['asgn']
            return
