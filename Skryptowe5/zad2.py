from ast import Mult
from functools import reduce


def sum(a, b):
    return a + b


def subtract(a, b):
    return a-b


def multiply(a, b):
    return a*b


class MultipleAccumulate:
    def __init__(self, data_list, *args):
        self.data_list = data_list
        self.accumulate_functions = args

    def get_data(self):
        dict1 = {}
        for function in self.accumulate_functions:
            dict1[function] = reduce(
                function, self.data_list)
        return dict1


#m = MultipleAccumulate([1, 2, 3, 4, 5, 6], sum, subtract, multiply)
#dict1 = m.get_data()
# print(dict1.items())
