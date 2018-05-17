def gdc(A, B):
    while(B > 0):
        temp = B
        B = A%B
        A = temp
    return A

A, B = map(int, input().split())
print(int(A*B/gdc(A, B)))