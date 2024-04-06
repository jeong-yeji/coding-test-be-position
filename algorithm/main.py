import unittest

from parameterized import parameterized


def solution(n):
    pass


def make_ant_sequence(n, times, ln):
    pass


class AntSequenceTest(unittest.TestCase):
    @parameterized.expand([
        (4, 21),
        (5, 12),
        (6, 22),
        (7, 12),
        (8, 21),
    ])
    def test_solution(self, n, result):
        self.assertEqual(solution(n), result)

    @parameterized.expand([
        (1, 1, [1], 1),
        (2, 1, [1], 11),
        (3, 1, [1], 21),
        (4, 1, [1], 1211),
        (5, 1, [1], 111221),
        (6, 1, [1], 312211),
        (7, 1, [1], 13112221),
        (8, 1, [1], 1113213211),
    ])
    def test_make_ant_sequence(self, n, times, ln, result):
        self.assertEqual(make_ant_sequence(n, times, ln), result)


if __name__ == '__main__':
    unittest.main()
