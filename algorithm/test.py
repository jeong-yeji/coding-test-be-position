import unittest
from collections import deque

import sol1, sol2
from parameterized import parameterized


class AntSequenceTest(unittest.TestCase):
    @parameterized.expand([
        (4, 21),
        (5, 12),
        (6, 22),
        (7, 12),
        (8, 21),
    ])
    def test_for_sol1(self, n, result):
        self.assertEqual(sol1.solution(n), result)

    @parameterized.expand([
        (1, [1], [1]),
        (2, [1], [1, 1]),
        (3, [1], [2, 1]),
        (4, [1], [1, 2, 1, 1]),
        (5, [1], [1, 1, 1, 2, 2, 1]),
        (6, [1], [3, 1, 2, 2, 1, 1]),
        (7, [1], [1, 3, 1, 1, 2, 2, 2, 1]),
        (8, [1], [1, 1, 1, 3, 2, 1, 3, 2, 1, 1]),
    ])
    def test_make_ant_sequence_for_sol1(self, n, ln, result):
        self.assertEqual(sol1.make_ant_sequence(n, ln), result)

    def test_value_error_for_sol1(self):
        with self.assertRaises(ValueError):
            sol1.solution(3)

        with self.assertRaises(ValueError):
            sol1.solution(100)

    @parameterized.expand([
        (4, 21),
        (5, 12),
        (6, 22),
        (7, 12),
        (8, 21),
    ])
    def test_for_sol2(self, n, result):
        self.assertEqual(sol2.solution(n), result)

    @parameterized.expand([
        (1, deque([1]), deque([1])),
        (2, deque([1]), deque([1, 1])),
        (3, deque([1]), deque([2, 1])),
        (4, deque([1]), deque([1, 2, 1, 1])),
        (5, deque([1]), deque([1, 1, 1, 2, 2, 1])),
        (6, deque([1]), deque([3, 1, 2, 2, 1, 1])),
        (7, deque([1]), deque([1, 3, 1, 1, 2, 2, 2, 1])),
        (8, deque([1]), deque([1, 1, 1, 3, 2, 1, 3, 2, 1, 1])),
    ])
    def test_make_ant_sequence_for_sol2(self, n, ln, result):
        self.assertEqual(sol2.make_ant_sequence(n, ln), result)

    def test_value_error_for_sol2(self):
        with self.assertRaises(ValueError):
            sol2.solution(3)

        with self.assertRaises(ValueError):
            sol2.solution(100)


if __name__ == '__main__':
    unittest.main()
