# Program ma za zadanie wyswietlic największą albo najmniejsza wartość podanego na wejściu parametru dla danego kraju
# Args: --parameter= --country= --max
import subprocess
import sys


def run_code(src, args, input):
    text = 'java ' + src + '.java ' + args + " " + input
    p = subprocess.Popen(text,
                         stdin=subprocess.PIPE, stdout=subprocess.PIPE, shell=True)
    out, err = p.communicate((bytes)(input, 'utf-8'))
    return out.decode('utf-8')


def run_code1(src, args):
    text = 'java ' + src + '.java ' + args + " " + input
    p = subprocess.Popen(text,
                         stdin=subprocess.PIPE, stdout=subprocess.PIPE, shell=True)
    out, err = p.communicate()
    return out.decode('utf-8')


if __name__ == "__main__":
    if len(sys.argv) != 4 and len(sys.argv) != 3:
        print("Incorrect arguments!")
    else:
        country = ""
        parameter = ""
        max = False
        for arg in sys.argv[1:]:
            if "--country" in arg:
                country = arg.split("=", 1)[1]
            elif "--parameter" in arg:
                parameter = arg.split("=", 1)[1]
            elif "--max" in arg:
                max = True
            else:
                raise Exception("Wrong parameters!")
        command = " --select=6,"+country+" --project=1,2,3,4,5,9"
        run_code("Process1", command, " < covid.tsv > wyjscie3.txt")
        if max:
            print(run_code("Aggregate", " max("+parameter+")", "< wyjscie3.txt"))
        else:
            print(run_code("Aggregate", " min("+parameter+")", "< wyjscie3.txt"))
