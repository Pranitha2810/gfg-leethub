from sortedcontainers import SortedSet

class NumberContainers:
    def __init__(self):  # Fix: Correct method name
        self.index = {}  # Maps index -> number
        self.number = {}  # Maps number -> SortedSet of indices

    def change(self, index: int, number: int) -> None:
        if index in self.index:
            prev = self.index[index]
            if prev in self.number:
                self.number[prev].discard(index)
                if not self.number[prev]:  # If the set becomes empty, delete the entry
                    del self.number[prev]

        self.index[index] = number
        if number not in self.number:
            self.number[number] = SortedSet()
        self.number[number].add(index)

    def find(self, number: int) -> int:
        if number in self.number and self.number[number]:
            return self.number[number][0]  # Return the smallest index
        return -1

        

    def find(self, number: int) -> int:
        if number in self.number and self.number[number]:
            return self.number[number][0]
        return -1

        


# Your NumberContainers object will be instantiated and called as such:
# obj = NumberContainers()
# obj.change(index,number)
# param_2 = obj.find(number)