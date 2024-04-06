import unittest

from parameterized import parameterized


def solution(n: int):
    pass


def make_ant_sequence(n: int, times: int, ln: list) -> list:
    if n == times:
        return ln

    cur, cnt = ln[0], 1
    new_ln = []
    for i in range(1, len(ln)):
        if cur == ln[i]:
            cnt += 1
        else:
            new_ln.append(cnt)
            new_ln.append(cur)
            cur, cnt = ln[i], 1
    new_ln.append(cnt)
    new_ln.append(cur)

    return make_ant_sequence(n, times + 1, new_ln)


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
        (1, 1, [1], [1]),
        (2, 1, [1], [1, 1]),
        (3, 1, [1], [2, 1]),
        (4, 1, [1], [1, 2, 1, 1]),
        (5, 1, [1], [1, 1, 1, 2, 2, 1]),
        (6, 1, [1], [3, 1, 2, 2, 1, 1]),
        (7, 1, [1], [1, 3, 1, 1, 2, 2, 2, 1]),
        (8, 1, [1], [1, 1, 1, 3, 2, 1, 3, 2, 1, 1]),
    ])
    def test_make_ant_sequence(self, n, times, ln, result):
        self.assertEqual(make_ant_sequence(n, times, ln), result)


if __name__ == '__main__':
    unittest.main()
