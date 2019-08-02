from lineform import DefaultName


class Config:

    def __init__(self, pid, num_agents, shared_vars):
        self.pid = pid
        self.num_agents = num_agents
        self.shared_vars = shared_vars


shared_vars = {}
a = DefaultName(Config(0, 5, shared_vars), None)
b = DefaultName(Config(1, 5, shared_vars), None)
c = DefaultName(Config(2, 5, shared_vars), None)
d = DefaultName(Config(3, 5, shared_vars), None)
e = DefaultName(Config(4, 5, shared_vars), None)

bots = [a, b, c, d, e]

for bot in bots:
    bot.initialize_vars()

for i in range(10):
    for bot in bots:
        print(shared_vars)
        bot.loop_body()
