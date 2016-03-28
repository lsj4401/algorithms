def calculateMoreAmount(defs, mys):
    print defs
    print mys

if __name__ == "__main__" :
    test_case = int(raw_input())

    for case in range(test_case):
        defs = map(int, list(raw_input().split()))
        mys = map(int, list(raw_input().split()))
        calculateMoreAmount(defs, mys)