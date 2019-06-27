import time

from agentThread import AgentThread
from geometry_msgs.msg import Pose
from gvh import Gvh


def pos3d(a, b, c):
    pos = Pose()
    pos.position.x, pos.position.y, pos.position.z = a, b, c
    return pos


def log(message):
    print(str(message))


class DefaultName(AgentThread):

    def __init__(self, pid: int, num_bots: int):
        super(DefaultName, self).__init__(Gvh(pid, num_bots))
        self.start()

    def write_to_shared(self, var_name, index, value):
        pass

    def read_from_shared(self, var_name, index):
        pass

    def read_from_sensor(self, var_name):
        pass

    def write_to_actuator(self, var_name, value):
        if var_name == "Motion.target":
            self.agent_gvh.moat.goTo(value)

    def run(self):
        while not self.stopped():
            time.sleep(1.000000)
            self.write_to_shared("x", self.pid(), self.read_from_sensor("Motion.position"))
            if (True):
                if (self.pid() != 0 or self.pid() != self.num_agents()):
                    self.write_to_actuator("Motion.target", midpoint(self.read_from_shared("x", self.pid() + 1),
                                                                     self.read_from_shared("x", self.pid() - 1)))

                continue
