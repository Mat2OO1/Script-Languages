from zad1 import TextViewer
from zad2 import MultipleAccumulate
def lambda1(x, y): return x+y
def lambda2(x, y): return x-y
def lambda3(x, y): return x*y


for obj in MultipleAccumulate([1, 2, 3, 4, 5, 6], lambda1, lambda2, lambda3), TextViewer("plik.txt"):
    print(obj.get_data())
