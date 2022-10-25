def nwd(a: int, b: int) -> int:
    if b == 0:
        return a
    return nwd(b, a % b)

class Wymierna:
    def __init__(self, licznik: int = 0, mianownik: int = 1):
        if type(licznik) != int:
            licznik = int(licznik)
        if type(mianownik) != int:
            mianownik = int(mianownik)

        nwdValue = nwd(mianownik, licznik)

        if nwdValue != 1:
            mianownik = int(mianownik / nwdValue)
            licznik = int(licznik / nwdValue)

        if mianownik < 0:
            licznik = -licznik
            mianownik = -mianownik

        self.licznik = licznik
        self.mianownik = mianownik

    def get_licznik(self):
        return self.licznik

    def get_mianownik(self):
        return self.mianownik

    def __repr__(self):
        return f'{self.licznik} / {self.mianownik}'

    def __float__(self):
        return self.licznik / self.mianownik

    def __add__(self, other):
        iloczynMianownikuf = self.mianownik * other.mianownik
        if iloczynMianownikuf < 0:
            iloczynMianownikuf = -iloczynMianownikuf

        self.licznik *= int(iloczynMianownikuf / self.mianownik)
        other.licznik *= int(iloczynMianownikuf / other.mianownik)

        return Wymierna(self.licznik + other.licznik, iloczynMianownikuf)

    def __sub__(self, other):
        return self + Wymierna(-other.licznik, other.mianownik)

    def __eq__(self, other):
        return self.licznik == other.licznik and self.mianownik == other.mianownik

    def __ne__(self, other):
        return self.licznik != other.licznik and self.mianownik != other.mianownik

    def __gt__(self, other):
        if self.licznik < 0 < other.licznik:
            return True
        if self.licznik > 0 > other.licznik:
            return False

        ratio = (self.licznik / other.licznik) / (self.mianownik / other.mianownik)

        if self.licznik > 0 and self.mianownik > 0:
            return ratio < 1
        return ratio > 1

    def __ge__(self, other):
        if self.licznik == other.licznik and self.mianownik == other.mianownik:
            return True

        return self > other

    def __lt__(self, other):
        return not self >= other

    def __le__(self, other):
        return not self > other

    def __mul__(self, other):
        return Wymierna(self.licznik * other.licznik, self.mianownik * other.mianownik)

    def __truediv__(self, other):
        return Wymierna(self.licznik * other.mianownik, self.mianownik * other.licznik)

    def eq2(self, other):
        return not (self > other or self < other)
