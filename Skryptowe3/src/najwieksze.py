import subprocess


def run_code(src, args):
    text = 'java ' + src + '.java ' + args
    p = subprocess.Popen(text,
                         stdin=subprocess.PIPE, stdout=subprocess.PIPE)
    out, err = p.communicate()
    return out.decode('UTF-8')


def run_code1(src, args, input):
    text = 'java ' + src + '.java ' + args
    p = subprocess.Popen(text,
                         stdin=subprocess.PIPE, stdout=subprocess.PIPE)
    out, err = p.communicate((bytes)(input, 'utf-8'))
    return out.decode('UTF-8')


def showBiggestSize(n):
    output = run_code("Paths1", "-R -s")
    output = output.split("\n")
    output.pop()
    tab = []
    for elem in output:
        tmp = elem.split(" ")
        tmp.pop()
        tmp[1] = int(tmp[1])
        if tmp[0].count(".") > 1:
            tab.append(tmp)
    tab.sort(key=lambda x: x[1], reverse=True)

    text = ""
    for elem in tab:
        text += elem[0] + " "
        text += str(elem[1]) + " B"
        text += "\n"
    print(run_code1("Head1", "--lines="+str(n), text))


def AverageFileSize(type):
    size = 0
    counter = 0
    output = run_code("Paths1", "-R -s")
    output = output.split("\n")
    output.pop()
    for elem in output:
        tmp = elem.split(".")
        if len(tmp) > 2:
            data = tmp[2].split(" ")
            if data[0] == type:
                counter += 1
                size += int(data[1])
    if counter != 0:
        return size/counter
    else:
        return -1


showBiggestSize(6)
print(AverageFileSize("py"))
