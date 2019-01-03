M = int(input())
N = int(input())
sum = 0
min = 111111
for i in range(M, N+1):

    found = False
    for j in range(2, i+1):
        if (i % j == 0):
            if i == j:
                found = True
                if min > i:
                    min = i
            else:
                break
    if found is True:
        sum += i
if sum == 0:
    print(-1)
else:
    print(sum)
    print(min)
