# Wyświetlenie n najlepszych lub najgorszych miesięcy dla podanego kraju. Kryterium
# jest średnia liczba zgonów (kolumna deaths). Należy wyświetlić rok, miesiąc i
# wartość miary


import subprocess
import sys


def run_code(src, args, input):
    text = 'java ' + src + '.java ' + args + " " + input
    p = subprocess.Popen(text,
                         stdin=subprocess.PIPE, stdout=subprocess.PIPE, shell=True)
    out, err = p.communicate((bytes)(input, 'utf-8'))
    return out.decode('utf-8')


def run_code1(src, args):
    text = 'java ' + src + '.java ' + args + " "
    p = subprocess.Popen(text,
                         stdin=subprocess.PIPE, stdout=subprocess.PIPE, shell=True)
    out, err = p.communicate()
    return out.decode('utf-8')


if __name__ == "__main__":
    if len(sys.argv) != 4 and len(sys.argv) != 3:
        print("Incorrect arguments!")
    else:
        country = ""
        n = ""
        best = False
        for arg in sys.argv[1:]:
            if "--country" in arg:
                country = arg.split("=", 1)[1]
            elif "--lines" in arg:
                n = arg.split("=", 1)[1]
            elif "-best" in arg:
                best = True
            else:
                raise Exception("Wrong parameters!")
        command = "--select=6,"+country+" --project=2,3,5"
        run_code("Process1", command, " < covid.tsv > wyjscie1.txt")
        lines = []
        with open("wyjscie1.txt", "r") as f:
            lines = f.readlines()
        tab = []
        header = str(lines[0]).strip('/')
        for elem in lines[1:]:
            context = elem.replace("\t", ",")[0:-2].split(",")
            tmp = [int(context[0].strip()), int(
                context[1].strip()), int(context[2].strip())]
            found = False
            for i in range(len(tab)):
                if tab[i][0] == tmp[0] and tab[i][1] == tmp[1]:
                    tab[i][2] += tmp[2]
                    found = True
                    break
            if not found:
                tab.append(tmp)
        if best:
            tab.sort(key=lambda x: x[2], reverse=True)
        else:
            tab.sort(key=lambda x: x[2])
        with open("wyjscie2.txt", "w") as f:
            for elem in tab:
                f.write(str(elem).strip("[ ]"))
                f.write("\n")

        command = "--lines="+str(n)
        print(header + run_code("Head1", command, "< wyjscie2.txt"))
