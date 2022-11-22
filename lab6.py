import pickle


class Punkt:
    __slots__ = ('_x', '_y')

    def __init__(self, x: float, y: float):
        self._x = x
        self._y = y

    @property
    def x(self) -> float:
        return self._x

    @property
    def y(self) -> float:
        return self._y

    @x.setter
    def x(self, x: float) -> None:
        self._x = x

    @y.setter
    def y(self, y: float) -> None:
        self._y = y

    @x.deleter
    def x(self) -> None:
        del self._x

    @y.deleter
    def y(self) -> None:
        del self._y

    def __repr__(self) -> str:
        return str(self)

    def __str__(self) -> str:
        return f'Point: ( {self._x} ; {self._y} )'


class NazwanyPunkt(Punkt):
    __slots__ = '__nazwa'

    def __init__(self, x: float, y: float, nazwa: str):
        super().__init__(x, y)
        self.__nazwa = nazwa

    @property
    def nazwa(self) -> str:
        return self.__nazwa

    @nazwa.setter
    def nazwa(self, nazwa: str) -> None:
        self.__nazwa = nazwa

    @nazwa.deleter
    def nazwa(self) -> None:
        del self.__nazwa

    # def __repr__(self) -> str:
    #     return str(self)
    #
    def __str__(self) -> str:
        return f'Point: ( {self._x} ; {self._y} ), {self.__nazwa}'


lista = [Punkt(3, 6), Punkt(2, 7), NazwanyPunkt(8, 3, 'Janek'), NazwanyPunkt(0, -2, 'Małgosia')]

print(lista)

f = open('punkty.pkl', 'wb')
pickle.dump(lista, f)
f.close()

f = open('punkty.pkl', 'rb')
lista2 = pickle.load(f)
f.close()

print(lista2)

# for x in lista:
#     print(type(x))
#
# for x in lista2:
#     print(type(x))
