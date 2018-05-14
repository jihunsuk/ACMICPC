def calculate_P_A(prob_single_event, prob_table):
    P_A = 0

    P_B = prob_single_event[0]
    P_E = prob_single_event[1]
    P_G = prob_single_event[2]
    P_Bc = 1-P_B
    P_Ec = 1-P_E
    P_Gc = 1-P_G

    for condition in prob_table:
        P_BEG = 1
        if condition[0] == 1:
            P_BEG *= P_B
        elif condition[0] == 0:
            P_BEG *= P_Bc
        if condition[1] == 1:
            P_BEG *= P_E
        elif condition[1] == 0:
            P_BEG *= P_Ec
        if condition[2] == 1:
            P_BEG *= P_G
        elif condition[2] == 0:
            P_BEG *= P_Gc
        P_A += P_BEG*condition[3]

    P_A = round(P_A, 4)
    return P_A

# 아래 부분은 함수의 호출과 출력을 위한 부분입니다. 수정하지 마세요

def read_inputs():
    prob_single_event = [float(i) for i in input().split()]
    prob_table = []
    for i in range(2 ** len(prob_single_event)):
        prob_table.append(input().split())
    prob_table = [list(map(float, each)) for each in prob_table]
    return prob_single_event, prob_table


def main():
    prob_single_event, prob_table = read_inputs()
    ans = calculate_P_A(prob_single_event, prob_table)
    print(ans)


if __name__ == '__main__':
    main()
