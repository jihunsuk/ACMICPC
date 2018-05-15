DP = [[0] * 10 for i in range(101)]
for i in range(1, 10):
    DP[1][i] = 1
n = int(input())
for i in range(2, n+1):
    for j in range(0, 10):
        if j == 9:
            DP[i][9] = DP[i-1][8]
        elif j == 0:
            DP[i][0] = DP[i-1][1]
        else:
            DP[i][j] = DP[i-1][j+1] + DP[i-1][j-1]
sum = 0
for i in range(0, 10):
    sum += DP[n][i]
print(sum%1000000000)