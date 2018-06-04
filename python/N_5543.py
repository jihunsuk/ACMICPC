A = int(input())
B = int(input())
C = int(input())
D = int(input())
E = int(input())

result = 0
if A > B:
    if B > C:
        result += C
    else:
        result += B
else:
    if A > C:
        result += C
    else:
        result += A

if D > E:
    print(result+E-50)
else:
    print(result+D-50)
