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
    if len(sys.argv) != 4:
        print("Incorrect arguments!")
    else:
        continent = ""
        year = ""
        month = ""
        for arg in sys.argv[1:]:
            if "--continent" in arg:
                continent = arg.split("=", 1)[1]
            elif "--month" in arg:
                month = arg.split("=", 1)[1]
            elif "--year" in arg:
                year = arg.split("=", 1)[1]
            else:
                raise Exception("Wrong parameters!")
        command = "--select=10,"+continent+",3,"+year+",2,"+month+" --project=4"
        run_code("Process1", command, " < covid.tsv > wyjscie.txt")
        print(run_code("Aggregate", " sum(cases)", "< wyjscie.txt"))
