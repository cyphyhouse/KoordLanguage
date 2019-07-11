class Pos():
    pass


class AgentThread(ABC, Thread):

    def __init__(self, config):
        pass

    @abstractmethod
    def loop_body(self):
        pass

    @abstractmethod
    def initialize_vars(self):
        pass

    def pos3d(self, x, y, z):
        pass

    def write_to_shared(self, var_name, index, value):
        pass

    def read_from_shared(self, var_name, index):
        pass

    def read_from_sensor(self, var_name):
        pass

    def write_to_actuator(self, var_name, value):
        pass

    def create_ar_var(self, name, type, initial_value=None):
        pass

    def create_aw_var(self, name, type, initial_value=None):
        pass

    def log(self, message):
        pass

    def lock(self):
        pass

    def unlock(self):
        pass
