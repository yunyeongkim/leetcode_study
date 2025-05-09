```python
class Solution:

    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort(key=lambda p: (-p[0], p[1]))
        res = []
        for h, k in people:
            res.insert(k, (h, k))
        return res
```

This one was one of the hardest and unintuitive problem to solve, but once you understand the core, it is not difficult to understand.

You just need to realize that,
when you are a person of height h, you are completely not affected by the people who has a smaller height than you.

For example,

if there are bunch of people with height 100 and height 99, let us say 5 of them each.

(100, 0)
(100, 1)
(100, 2)
(100, 3)
(100, 4)

No matter how many people with height 99 exist in between the people with height 100,
the property is met.

(100, 0)

... many people with lower height

(100, 1)

... many people with lower height

(100, 2)

... many people with lower height

(100, 3)

... many people with lower height

(100, 4)

So, once you ordered the people with the largest height, they are not affected at all.

---

And then, you can continue with the people with the second largest height, and they are only affected by the people with the largest and the second largest height.

The people with the third largest height are only affect by the people with the first, second, and the third largest height.

And so on...

> You can use a linked list to construct the array to find the proper place to insert a person, with a look-up time complexity of O(n) and an insertion time complexity of O(n), per person.

> It's only 2000 people max, so the question is solvable in `O(n^2) + O(nlog(n))`.

Actually this is wrong. If you maintain the address of the node while inserting to the linked list, you can insert a node in O(1) time complexity on average.

So the question is solvable in `O(n) + O(nlog(n))`. Thanks for the valuable insight, @knae11.
