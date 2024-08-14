with open("valid_4words.txt") as infile:
    words = infile.read().split("\n")

arr = []
i = 0
while i < len(words):
    j = 0
    while j < len(words):
        k = 0
        while k < len(words):
            l = 0
            while l < len(words):
                arr = [words[i], words[j], words[k], words[l]]
                arr2 = ["".join([words[i][x], words[j][x], words[k][x], words[l][x]]) for x in range(4)]
                if arr2[0] not in words:
                    i += 1
                l += 1
            k += 1
        j += 1
    i += 1