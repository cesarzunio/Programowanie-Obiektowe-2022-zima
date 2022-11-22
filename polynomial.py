import sys


class Polynomial:
    def __init__(self, coefficients: list):
        self.coefficients = coefficients

        if self.coefficients[-1] == 0 and len(self.coefficients) != 1:
            sys.exit("Polynomial's first coefficient cannot be 0!")

    def deg(self) -> int:
        return len(self.coefficients)

    def __str__(self) -> str:
        strValue = ''

        for i in range(len(self.coefficients) - 1, 0, -1):
            if self.coefficients[i] == 0:
                continue
            strValue += 'x' if self.coefficients[i] == 1 else f'{self.coefficients[i]}x'
            if i == 1:
                strValue += ' + '
                continue
            strValue += f'^{i} + '
        strValue += f'{self.coefficients[0]}'

        return strValue

    def __neg__(self) -> 'Polynomial':
        return Polynomial([-i for i in self.coefficients])

    def get_coefficient(self, index) -> int:
        if index > len(self.coefficients) - 1:
            return 0
        return self.coefficients[index]

    def __add__(self, other: 'Polynomial') -> 'Polynomial':
        longerLen = max(len(self.coefficients), len(other.coefficients))
        pol = Polynomial([self.get_coefficient(i) + other.get_coefficient(i) for i in range(longerLen)])
        return pol

    def __sub__(self, other: 'Polynomial') -> 'Polynomial':
        return self + (-other)

    def __eq__(self, other: 'Polynomial') -> bool:
        if self.deg() != other.deg():
            return False

        check = True

        for i in range(len(self.coefficients)):
            if self.coefficients[i] != other.coefficients[i]:
                check = False
                break

        if check is True:
            return True

        check = True

        for i in range(len(self.coefficients)):
            if self.coefficients[i] != -other.coefficients[i]:
                check = False
                break

        return check

    def __call__(self, x) -> float:
        value = 0

        for i in range(self.deg() - 1, -1, -1):
            value += self.coefficients[i] * (x ** i)

        return value

    def __mul__(self, other: 'Polynomial') -> 'Polynomial':
        newLen = self.deg() + other.deg()
        newCoefficients = [0 for _ in range(newLen)]

        # for i in range(len(self.coefficients) - 1, -1, -1):
        #     for j in range(len(other.coefficients) - 1, -1, -1):