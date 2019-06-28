# from typing import NoReturn
import typing


class Gvh(object):
    """
    __participants: int
    __pid: int
    __dsm: Dsm
    __moat: motionAutomaton.MotionAutomaton
    """

    def __init__(self, pid: int, participants: int = 1, bot_name: str = 'cyphyhousecopter'):
        """
        Global Variable Holder keeps system specific information in the robot
        :param name: the robots pid
        :param participants: all the other participants
        """
        self.__participants = participants
        self.__mutex_list = []
        self.__pid = pid
        self.__msg_list = []
        self.__finished = []  # for barrier sync
        self.__start_round = True

        self.vars = {}

    @property
    def pid(self) -> int:
        """
        getter method for pid
        :return:
        """
        return self.__pid

    @pid.setter
    def pid(self, pid: int) -> None:  # -> NoReturn:
        """
        setter method for pid
        :param name:
        :return:
        """
        self.__pid = pid

    def mk_var(self, var_scope, var_type, var_name, var_value=None) -> None:
        """
        method to create variable type in dsm
        :param var_scope: scope of variable
        :param var_type: variable type
        :param var_name: name
        :param var_value: value
        :return: nothing
        """
        self.vars[var_name] = var_value

    def has_mutex(self, var_name):
        """

        :param var_name:
        :return:
        """
        i = self.get_mutex_index(var_name)
        if self.mutex_list[i].has_mutex(self.pid):
            return True
        return False

    def put(self, varname: str, value: typing.Union[int, bool, float, list, object, tuple], pid: int = -1) -> None:
        """
        update method for distributed shared memory variable value
        :param varname:
        :param value:
        :param pid:
        :return:
        """
        print("putting " + varname + " with val " + str(value))
        self.vars[varname] = value

    def get(self, varname: str, pid: int = -1) -> typing.Union[int, bool, float, list, object, tuple]:
        """
        getter method for dsm variable value (from local shared memory)
        :param varname:
        :param pid:
        :return:
        """
        print("gettingn var" + varname)
        return self.vars[varname]
