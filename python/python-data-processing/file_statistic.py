import fileinput
import re


class LineStatistic(object):

    def __init__(self):
        self.lines = []
        for line in fileinput.input():
            self.lines.append(line)

    def do_statistic(self, pattern):
        count = 0
        for line in self.lines:
            if re.match(pattern, line):
                count += 1
        print 'Category: {}, Count: {}'.format(pattern, count)


ls = LineStatistic()
ls.do_statistic("^Abstract")
ls.do_statistic("^Exception")
ls.do_statistic('Listener$')
