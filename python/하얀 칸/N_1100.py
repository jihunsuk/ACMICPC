Count = 0
for i in range(0, 8):
    str = input()
    for j in range(0, 8):
        if i % 2 == 0 and j % 2 == 0 and str[j] == 'F':
            Count += 1
        if i % 2 == 1 and j % 2 == 1 and str[j] == 'F':
            Count += 1

print(Count)
