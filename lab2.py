def mult(a):
    sum = 1
    for x in a:
        sum *= x
    return sum


def mult_ints(a):
    sum = 1
    for x in a:
        if type(x) != int:
            continue
        sum *= x
    return sum


def multiply(*args):
    sum = 1
    for x in args:
        sum *= x
    return sum


def multiply_ints(*args):
    sum = 1
    for x in args:
        if type(x) != int:
            continue
        sum *= x
    return sum


def make_car(firma, model, **kwargs):
    slownik = kwargs
    slownik['firma'] = firma
    slownik['model'] = model
    return slownik


def zad31():
    lista = []
    lista.append([x for x in range(1, 11)])
    lista.append([x ** 2 for x in range(1, 11)])
    lista.append([x ** 3 for x in range(1, 11)])
    for i in lista:
        for j in i:
            print(j)


def zad32():
    lista = []
    dlugoscListy = 1
    aktualnaLiczba = 1
    for i in range(0, 10):
        lista.append([])
        for j in range(dlugoscListy):
            lista[i].append(aktualnaLiczba)
            aktualnaLiczba += 1
        dlugoscListy += 1

    totalSum = 0
    iterator = 0
    for i in lista:
        arraySum = 0
        for j in i:
            arraySum += j
        totalSum += arraySum
        print(f'Array[{iterator}] sum == {arraySum}')
        iterator += 1
    print(f'Total sum == {totalSum}')



def zad321(a : list, b : list):
    outputMatrix = []
    for i in range(len(a)):
        outputMatrix.append([])
        for j in range(len(a[i])):
            outputMatrix[i].append(a[i][j] + b[i][j])
    return outputMatrix


def printMatrix(a : list):
    for i in a:
        line = ''
        for j in i:
            line += f'{j} '
        print(line)
    print('----------------')

a = [[2, 3], [4, 5]]
b = [[6, 7], [8, 9]]

printMatrix(a)
printMatrix(b)
printMatrix(zad321(a, b))





