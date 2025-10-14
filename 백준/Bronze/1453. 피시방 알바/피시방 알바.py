cnt = 0
n = int(input())
k = list(map(int,input().split()))
seat = []

for i in range(n):
    if k[i] in seat:
        cnt +=1
    else:
        seat.append(k[i])

print(cnt)