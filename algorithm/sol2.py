from collections import deque


def solution(n: int) -> int:
    if n <= 3 or n >= 100:
        raise ValueError("n은 3보다 크고 100보다 작은 값이어야 합니다.")

    ant_sequence = make_ant_sequence(n, deque([1]))
    mid = len(ant_sequence) // 2
    return ant_sequence[mid - 1] * 10 + ant_sequence[mid]


def make_ant_sequence(n: int, ln: deque) -> deque:
    if n == 1:
        return ln

    cur, cnt = ln.popleft(), 1
    new_ln = deque()
    while ln:
        nxt = ln.popleft()
        if cur == nxt:
            cnt += 1
        else:
            new_ln.append(cnt)
            new_ln.append(cur)
            cur, cnt = nxt, 1
    new_ln.append(cnt)
    new_ln.append(cur)

    return make_ant_sequence(n - 1, new_ln)


if __name__ == "__main__":
    print(solution(int(input())))
