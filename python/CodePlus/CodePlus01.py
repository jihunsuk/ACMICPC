import re

user_input11 = input()
user_input22 = input()
user_input33 = input()

pattern = "[ ㄱ-ㅣ가-힣.]+"

p1 = re.compile('[ /.]')
p2 = re.compile('[ -.]')
p3 = re.compile(pattern)

user_input1 = p1.sub(" ", user_input11)
user_input1 = p2.sub(" ", user_input1)
user_input1 = p3.sub(" ", user_input1)

user_input2 = p1.sub(" ", user_input22)
user_input2 = p2.sub(" ", user_input2)
user_input2 = p3.sub(" ", user_input2)

user_input3 = p1.sub(" ", user_input33)
user_input3 = p2.sub(" ", user_input3)
user_input3 = p3.sub(" ", user_input3)

user_input1 = user_input1.split()
user_input2 = user_input2.split()
user_input3 = user_input3.split()

inputs = [user_input1, user_input2, user_input3]
value = []
for input in inputs:
    current_input = input
    sum = 0
    if len(current_input[0]) == 2:
        year = '20'+current_input[0]
        sum += int(year)*10000
    else:
        year = current_input[0]
        sum += int(year)*10000
    sum += int(current_input[1])*100
    sum += int(current_input[2])
    value.append(sum)

ans = []
if value[0] > value[1]:
    if value[1] > value[2]:
        ans.append(user_input33)
        ans.append(user_input22)
        ans.append(user_input11)
    else:
        if value[0] > value[2]:
            ans.append(user_input22)
            ans.append(user_input33)
            ans.append(user_input11)

elif value[0] > value[2]:
    if value[2] > value[1]:
        ans.append(user_input22)
        ans.append(user_input33)
        ans.append(user_input11)
    else:
        if value[0] > value[1]:
            ans.append(user_input33)
            ans.append(user_input22)
            ans.append(user_input11)

elif value[1] > value[2]:
    if value[2] > value[0]:
        ans.append(user_input11)
        ans.append(user_input33)
        ans.append(user_input22)
    else:
        if value[1] > value[0]:
            ans.append(user_input33)
            ans.append(user_input11)
            ans.append(user_input22)

for i in ans:
    print(i)