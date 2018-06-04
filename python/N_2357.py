# 시간초과뜸
M, N = map(int, input().split())
number = [int(input()) for i in range(M)]

for i in range(N):
    a, b = map(int, input().split())
    newNumber = sorted(number[a-1:b])
    print(newNumber[0], newNumber[b-a])