T = int(input())
for i in range(T):
    str = input()
    str = str.split()
    N = int(str[0])
    A = int(str[1])
    B = int(str[2])
    Count = -1
    n2 = pow(2, N)
    if A % 2 == 1:
        print(N)
    else:
        while A != 0:
            if A >= n2:
                A -= n2
            n2 /= 2
            Count += 1
        print(Count)





