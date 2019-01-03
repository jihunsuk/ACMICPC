
def bfs(list, start_Node, End_Node):
    if start_Node == End_Node:
        return True
    else:
        index = list.__len__()
        Edge = [[0] * 100 for i in range(100)]
        for i in range(0, list.__len__(), 2):
            Edge[list[i]][list[i + 1]] = 1

        visited = [start_Node]
        Queue = [start_Node]
        while Queue.__len__() is not 0:
            node = Queue.pop(0)
            for i in range(1, list.__len__(), 2):
                if list[i] in visited or Edge[node][list[i]] == 0:
                    continue
                visited.append(list[i])
                Queue.append(list[i])
                if list[i] == End_Node:
                    return True

    return False

def is_tree(tree_candidate):
    check_tree = []

    for i in range(0, tree_candidate.__len__()):
        root_Node = 0
        isTree = True
        if tree_candidate[i].__len__() == 0:
            check_tree.append([root_Node, True])
        elif tree_candidate[i].__len__() % 2 == 1:
            check_tree.append([root_Node, False])
        else:
            NodeCount = {}
            anslist = []
            for j in range(1, tree_candidate[i].__len__(), 2):
                if tree_candidate[i][j] in NodeCount.keys():
                    NodeCount[tree_candidate[i][j]] += 1
                else:
                    NodeCount[tree_candidate[i][j]] = 1

            for j in range(0, tree_candidate[i].__len__(), 2):
                if NodeCount[tree_candidate[i][j+1]] >= 2:
                    isTree = False

                if tree_candidate[i][j] not in NodeCount.keys():
                    if root_Node == 0:
                        root_Node = tree_candidate[i][j]
                    elif root_Node != tree_candidate[i][j]:
                        isTree = False

            if isTree is True:
                for j in NodeCount.keys():
                    isTree = bfs(tree_candidate[i], root_Node, j)

            if isTree is False:
                anslist.append(0)
            else:
                anslist.append(root_Node)
            anslist.append(isTree)

            check_tree.append(anslist)
    return check_tree


# 아래 부분은 함수의 호출과 출력을 위한 부분입니다. 수정하지 마세요

def read_inputs():
    tree_candidate = []
    while True:
        a = input()
        if a == '-1':
            break
        else:
            candidate = list(int(x) for x in a.split())
            tree_candidate.append(candidate)
    return tree_candidate


def main():
    tree_candidate = read_inputs()
    ans = is_tree(tree_candidate)
    print(ans)


if __name__ == "__main__":
    main()