from abc import ABC, abstractmethod
import re
from tkinter import Image
import webbrowser
import mimetypes


class FileViewer():
    path: str

    @abstractmethod
    def __init__(self, path):
        self.path = path

    @abstractmethod
    def view(self):
        pass


class TextBuffer:
    def __init__(self, text):
        self.read_from_file()

    def read_from_file(self):
        f = open(self.path, "r")
        self.text = f.read()


class TextViewer(TextBuffer, FileViewer):

    def __init__(self, path):
        self.path = path
        super().__init__(self.path)

    def view(self):
        webbrowser.open(self.path)

    def get_data(self):
        t = TextStats()
        return t.compute(self.text)


class ImageViewer(FileViewer):

    def __init__(self, path):
        self.path = path

    def view(self):
        webbrowser.open(self.path)


class TextStats:
    def compute(self, text):
        self.number_of_words = len(re.findall(r'\w+', text))
        self.number_of_lines = text.count("\n")
        self.number_of_nonalpha = len(re.findall(r'\W+', text))

        return self

    def __str__(self):
        return "Num of words: " + str(self.number_of_words) + "\nNum of lines: " + str(self.number_of_lines) + "\nNum of nonalpha: " + str(self.number_of_nonalpha)


class ViewerCreator:

    def create_viewer(self, path):
        tmp = self._detect_viewer_type(path)
        return tmp(path)

    def _detect_viewer_type(self, path):
        tmp = mimetypes.guess_type(path)[0]
        if tmp == "text/plain":
            t = TextViewer(path)
            return type(t)
        elif tmp == "image/jpeg":
            t = ImageViewer(path)
            return type(t)
        else:
            return type(None)


v = ViewerCreator()
i = v.create_viewer("plik.txt")
i.get_data()
# i.view()
#t = v.create_viewer("kot.jpg")
# t.view()
