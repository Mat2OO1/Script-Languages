import shutil
import os
import sys
if __name__ == "__main__":
    if len(sys.argv) < 2 or len(sys.argv) > 3:
        print("Incorrect arguments!")
    else:
        src = "."
        dest = ""
        if "--src" in sys.argv[1]:
            src = sys.argv[1].split("=", 1)[1]
            dest = sys.argv[2].split("=", 1)[1]
        else:
            dest = sys.argv[1].split("=", 1)[1]
        files = os.listdir(src)
        shutil.copytree(src, dest)
