def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
    people.sort(lambda x: (-x[1], x[0]))
    result = []
    for person in people:
        result.insert(person[1], person)
    return result