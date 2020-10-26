arr = [1, 1, 2, 2, 2, 8]
result = input().split(" ")
[print(arr[i] - int(result[i]), end=' ') for i in range(0, 6)]
