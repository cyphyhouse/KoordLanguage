import time

from agentThread import AgentThread
from commHandler import CommHandler
from geometry_msgs.msg import Pose
from gvh import Gvh


def pos3d(a, b, c):
    pos = Pose()
    pos.position.x, pos.position.y, pos.position.z = a, b, c
    return pos


def midpoint(x, y):
    mid_x = (x.position.x + y.position.x) / 2
    mid_y = (x.position.y + y.position.y) / 2
    mid_z = (x.position.z + y.position.z) / 2
    ret = Pose()
    ret.position.x, ret.position.y, ret.position.z = mid_x, mid_y, mid_z
    return ret

def log(message):
    print(str(message))


class DefaultName(AgentThread):

    def __init__(self, pid: int, num_bots: int, receiver_ip, r_port):
        super(DefaultName, self).__init__(Gvh(pid, num_bots), CommHandler(receiver_ip, r_port))
        self.start()

    def write_to_shared(self, var_name, index, value):
        self.request_mutex(var_name)
        self.agent_gvh.put(var_name, value, index)

    def read_from_shared(self, var_name, index):
        self.agent_gvh.get(var_name, index)

        pass

    def read_from_sensor(self, var_name):
        pass

    def write_to_actuator(self, var_name, value):
        if var_name == "Motion.target":
            self.agent_gvh.moat.goTo(value)

    def run(self):
        while not self.stopped():
            time.sleep(1.000000)
            if True:
                log("hi")

                log("1 + 1 = ")
                log(2)

                continue
