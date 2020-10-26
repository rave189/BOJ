import math
result = input().split(" ")
result = [int(i)**2 for i in result]
div = result[0] / (result[1] + result[2])
print(int(math.sqrt(result[1] * div)), int(math.sqrt(result[2] * div)))
