def largestAltitude(self, gain: List[int]) -> int:
    answer = [0]
    for i in range(len(gain)):
        answer.append(answer[i] + gain[i])
    return max(answer)