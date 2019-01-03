import math
length, h, w = map(float, input().split())
a = length / math.sqrt(math.pow(h, 2)+math.pow(w, 2))
print(str(int(h*a))+" "+str(int(w*a)))
