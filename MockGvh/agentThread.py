from abc import ABC, abstractmethod
from threading import Thread
from typing import Any

from gvh import Gvh


class AgentThread(ABC, Thread):

    def __init__(self, agent_gvh: Gvh, comm_handler):
        """
        __gvh: Gvh
        __pid: int
        __stop_event: Event
        __sleep_event: Event
        """

        """
        abstract object for each agent thread.
        :param gvh: the global variable holder. Holds agent specific info and agent worldview
        """
        super(AgentThread, self).__init__()
        self.__agent_gvh = agent_gvh
        self.__stop_event = False
        self.__pid = 0
        print("starting agent thread")

    @property
    def is_leader(self) -> bool:
        """

        :return: whether the agent is the leader
        """
        return self.__is_leader

    @is_leader.setter
    def is_leader(self, val: bool) -> None:
        """

        :param val:
        :return:
        """
        self.__is_leader = val

    @property
    def num_agents(self) -> int:
        """
        getter method for the number of agents in the system
        :return:
        """
        return self.agent_gvh.participants

    @num_agents.setter
    def num_agents(self, numagents: int):  # -> NoReturn:
        """
        setter method for number of agents in the system . may not ever be used
        """
        self.agent_gvh.participants = numagents

    @property
    def agent_gvh(self) -> Gvh:
        """
        getter method for the gvh
        :return:
        """
        return self.__agent_gvh

    @agent_gvh.setter
    def agent_gvh(self, agent_gvh: Gvh):  # -> NoReturn:
        """
        This may be never used
        :param agent_gvh:
        :return:
        """
        self.__agent_gvh = agent_gvh

    def pid(self) -> int:
        """
        get the pid of the current agent.
        uses the agent gvh to retrieve it
        :return: integer pid of the current agent
        """
        return self.agent_gvh.pid

    def stop(self):  # -> NoReturn:
        """
         a flag to set to to safely exit the thread
        :return:
        """
        self.__stop_event = True

    def stopped(self):  # -> NoReturn:
        """
        set the stop flag
        :return:
        """
        return self.__stop_event

    def sleep(self):  # -> NoReturn:
        """
        allows sleeping
        :return:
        """
        self.__sleep_event.set()

    def is_sleeping(self) -> bool:
        """
        sets the sleeping flag
        :return:
        """
        return self.__sleep_event.is_set()

    def mk_var(self, var_scope, var_type, var_name, var_value=None) -> None:
        """
        method to create variable type in dsm
        :param var_scope: scope of variable
        :param var_type: variable type
        :param var_name: name
        :param var_value: value
        :return: nothing
        """
        self.agent_gvh.mk_var(var_scope, var_type, var_name, var_value)

    def put(self, pid: int, var_name: str, val: Any) -> None:
        """

        :param pid:
        :param var_name:
        :param val:
        :return:
        """
        print("putting value")

    def has_mutex(self, var_name: str) -> bool:
        """

        :param var_name:
        :return:
        """
        return self.agent_gvh.has_mutex(var_name)

    def request_mutex(self, var_name: str) -> None:
        """

        :param var_name:
        :return:
        """
        print("mutex requested")

    def release_mutex(self, var_name: str) -> None:
        """

        :param var_name:
        :return:
        """
        print("releasing mutex", self.pid)

    def flush_msgs(self):
        """
        send messages held in gvh list
        :return:
        """
        msg_list = self.agent_gvh.msg_list
        self.agent_gvh.msg_list = []
        self.comm_handler.flush_msgs(msg_list)

    @abstractmethod
    def run(self) -> None:
        """
        needs to be implemented for any agenThread
        :return:
        """
        pass

    def signal_handler(self, sig, frame):
        self.stop()
