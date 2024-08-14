from pprint import pprint

SPACE = """
UFDANI
SOLGWD
IMESAI
NOGNCE
SUBPRK
EROFUN
MAGBLC
ITBEOO
""".lower().strip()


class Node:
    def __init__(self, value, id, adjacency_list):
        self.value = value
        self.id = id
        self.adjacency_list = adjacency_list


def print_nodes(nodes):
    for node in nodes:
        print(f"{node.value} ({node.id}):\t[", end="")
        for adjacent_node in node.adjacency_list:
            print(nodes[adjacent_node].value, end=", ")
        print("]")

def create_nodes(s):
    nodes = []
    counter = 0

    for i in range(len(s)):
        for j in range(len(s[i])):
            adjacency_list = []
            if counter > 5:                                 # NODES ABOVE
                if counter % 6 != 0:
                    adjacency_list.append(counter - 7)      # TOP LEFT
                adjacency_list.append(counter - 6)          # TOP MIDDLE
                if (counter - 5) % 6 != 0:
                    adjacency_list.append(counter - 5)      # TOP RIGHT
            if counter % 6 != 0:
                adjacency_list.append(counter - 1)          # LEFT
            if (counter - 5) % 6 != 0:
                adjacency_list.append(counter + 1)          # RIGHT
            if counter < 42:                                # NODES BELOW
                if counter % 6 != 0:
                    adjacency_list.append(counter + 5)      # BOTTOM LEFT
                adjacency_list.append(counter + 6)          # BOTTOM MIDDLE
                if (counter - 5) % 6 != 0:
                    adjacency_list.append(counter + 7)      # BOTTOM RIGHT

            nodes.append(Node(s[i][j], counter, adjacency_list))
            counter += 1

    return nodes

def get_valid_words(search, substr):
     return [word for word in search if word.startswith(substr)]
def find_words_by_letter(x, space, words):
    visited = [False for _ in space]
    all_words = words[:]
    valid_words = []
    stack = []
    stack.append(x)
    temp_word = ""
    count = 0
    while len(stack) > 0:
        current = stack.pop()
        if not visited[current]:
            count += 1
            print(count)
            if count > 15:
                quit()
            valid_words = get_valid_words(all_words, temp_word + space[current].value)
            print(temp_word + space[current].value)
            print(valid_words[:10])
            if len(valid_words) == 0:
                continue
            else:
                temp_word += space[current].value
                visited[current] = True
            for node in space[current].adjacency_list:
                if not visited[node]:
                    stack.append(node)


def main():
    s = SPACE.split("\n")

    nodes = create_nodes(s)

    with open("valid_words.txt") as infile:
        words = infile.read().split("\n")
    words_dict = {"a": [], "b": [], "c": [], "d": [], "e": [], "f": [], "g": [], "h": [], "i": [], "j": [], "k": [], "l": [], "m": [], "n": [], "o": [], "p": [], "q": [], "r": [], "s": [], "t": [], "u": [], "v": [], "w": [], "x": [], "y": [], "z": []}
    for word in words:
        letter = word[0]
        words_dict[letter].append(word)
    find_words_by_letter(0, nodes, words_dict[s[0][0]])



if __name__ == '__main__':
    main()