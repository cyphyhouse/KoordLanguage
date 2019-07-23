import random
from abc import ABC, abstractmethod


class Pos():
    pass


class AgentThread(ABC):

    def __init__(self, config, motion_config=None):
        self._pid = config.pid
        self._num_agents = config.num_agents
        self._pos = (random.randrange(1, 10), random.randrange(1, 10))
        self.shared_vars = config.shared_vars



    @abstractmethod
    def loop_body(self):
        pass

    @abstractmethod
    def initialize_vars(self):
        pass

    def pos3d(self, x, y, z):
        pass

    def write_to_shared(self, var_name, index, value):

        self.shared_vars[var_name][index] = value

    def read_from_shared(self, var_name, index):
        return self.shared_vars[var_name][index]

    def read_from_sensor(self, var_name):
        if var_name == "Motion.position":
            return self._pos

    def write_to_actuator(self, var_name, value):
        if var_name == "Motion.target":
            self._pos = value

    def create_ar_var(self, name, type, initial_value=None):
        if name not in self.shared_vars:
            self.shared_vars[name] = [initial_value] * self._num_agents

    def create_aw_var(self, name, type, initial_value=None):
        if name not in self.shared_vars:
            self.shared_vars[name] = [initial_value] * self._num_agents

    def log(self, message):
        pass

    def pid(self):
        return self._pid

    def num_agents(self):
        return self._num_agents

    def start(self):
        pass

    def run(self):

        for i in range(10):
            self.loop_body()

    def midpoint(self, x, y):
        a, b = x
        c, d = y
        return (a + c) / 2, (b + d) / 2
