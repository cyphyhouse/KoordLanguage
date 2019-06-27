import time

from agentThread import AgentThread
from commHandler import CommHandler
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
        super(DefaultName, self).__init__(Gvh(pid, num_bots), CommHandler("", 0, 0, pid))
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
        tries = 1
        dest = pos3d(0.0, 0.0, 1.0)
        land = pos3d(0.0, 0.0, 0.0)
        while not self.stopped():
            time.sleep(1.000000)
            if tries == 1:
                self.write_to_actuator("Motion.target", dest)
                tries = 2
                continue
            if tries == 2:
                self.write_to_actuator("Motion.target", land)
                tries = 3
                self.stop()
                continue
