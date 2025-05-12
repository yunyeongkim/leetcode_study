# 406. Queue Reconstruction by Height

[problem][https://leetcode.com/problems/queue-reconstruction-by-height/description/]

### Intuition

We need to sort the `people` to correspond the k. k is the number of people in front of them who have a height greater than or equal to height.



### Method: Greedy; Time: O($N\log N + N^2$)

```python
def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
    people.sort(lambda x: (-x[1], x[0]))
    result = []
    for person in people:
        result.insert(person[1], person)
    return result
```

1.   Sort the people(height in descending order &rarr; k in ascending order)
2.   Insert each person into a new list at index k



Why this works? Because taller people don't get affected by shorter people in front of them. And once taller people are placed, inserting a short person at index k guarantees exactly k taller people in front.