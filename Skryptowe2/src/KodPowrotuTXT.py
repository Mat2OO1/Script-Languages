import subprocess


def run_code(src, args, input):
    text = 'java ' + src + '.java ' + args
    p = subprocess.Popen(text,
                         stdin=subprocess.PIPE, stdout=subprocess.PIPE)
    out, err = p.communicate((bytes)(input, 'utf-8'))
    print("Najczesciej wystapilo slowo o indeksie " + out.decode('utf-8'))


run_code("KodPowrotuTxt", "hej siema", 'plik.txt')
