a, b = map(int, input().split(" "))
arr = map(int, input().split(" "))
arr = [print(i-(a*b), end=' ') for i in arr]
