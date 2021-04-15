name = ['홍길동','유재석','전지현','박서준','박민영']

List = [[70,80,45,67,91],
         [87,85,77,88,95],
         [65,54,41,87,67],
         [99,87,94,85,89],
         [33,55,77,88,90]]

sumJ = [0,0,0,0,0]
avg = [0,0,0,0,0]
maxJum = [0,0,0,0,0]

# 합계, 평균
for i in range(len(List)):
    for j in range(len(List[0])):
        sumJ[i] = sumJ[i]+ List[i][j]
    avg[i] = sumJ[i] / len(List[i])


# 1 출력
print("이름\t국어\t영어\t수학\t음악\t체육\t총점\t 평균")
for i in range(len(name)):
    print(name[i], )
    for j in range(len(List[i])):
        print(List[i][j], )
    print(sumJ[i],'\t',avg[i],'\n')
    

# 최고점수
for i in range(len(List)):
    for j in range(len(List[0])):
        for k in range(j+1,len(List[0])):
            if List[i][j] > List[i][k]:
                List[i][j],List[i][k]=List[i][k],List[i][j]    
    maxJum[i] = List[i][j]


# 2 출력
print('---------------------------------')
print("이름\t과목별 최고 점수\t평균")
for i in range(len(name)):
    print(name[i],"\t",maxJum[i],"\t\t",avg[i],"\n")