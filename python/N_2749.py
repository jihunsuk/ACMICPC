# 1. 피사노 주기 : 피보나치 수를 K로 나눈 나머지는 항상 주기를 가진다. (피보나치 수를 3으로 나누었을 때, 주기의 길이는 8 )
# 2. 주기의 길이가 P이면, N번째 피보나치 수를 M으로 나눈 나머지는 N%P번째 피보나치 수를 M을 나눈 나머지와 같다.
# 3. M = 10^k 일 때, k > 2 라면, 주기는 항상 15 x 10^k-1이다.

n = int(input()) % 1500000
x1 = 0
x2 = 1
for i in range(n):
    temp = x2
    x2 = (x1+x2) % 1000000
    x1 = temp
print(int(x1))