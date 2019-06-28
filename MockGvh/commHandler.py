from threading import Thread

RETRY_VAL = 10


class CommHandler(Thread):
    """
    Communication handling thread. Has a receiver , which will receive all messages.
    We also have a sender class, with a send method.
    TODO: figure out design
    """

    def __init__(self, ip: str, r_port: int, agent_gvh=None, timeout: float = 100.0, retries: int = RETRY_VAL):
        """
        init method for receiver object thread
        :param ip:
        :param r_port:
        :param timeout:
        :param retries:
        """
        super(CommHandler, self).__init__()
        self.__ip = ip
        self.__r_port = r_port
        self.__agent_gvh = agent_gvh
        self.start()

    @property
    def pid(self) -> int:
        """
        getter method for pid
        :return:
        """
        return self.__pid

    def flush_msgs(self, msg_list: list) -> None:
        """

        :param msg_list:
        :return:
        """
        for msg in msg_list:
            self.sender.send(msg)
