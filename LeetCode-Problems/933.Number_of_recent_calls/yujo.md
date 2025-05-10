# 933. Number of Recent Calls

## 1. Definition

- Implement a function that returns the number of pings made within 3000ms of the most recent request.
- It is guaranteed that each call to ping will have a strictly larger value than the previous call.

## 2. First Code (10 min)

```ts
class RecentCounter {
  queue: number[];

  constructor() {
    this.queue = [];
  }

  ping(t: number): number {
    this.queue.push(t);

    const range = t - 3000;

    return this.queue.filter((it) => it >= range).length;
  }
}
```

## 3. First Code Explain

- time complexity: O(n) (because the filter method has a time complexity of O(n))
- space complexity: O(n) (because requests are continuously added to the queue)
- Using the most recent request as a reference, we set a 3000ms window and return the count of values in the queue that are greater than or equal to the range.

## 4. Optimized Code

```ts
class RecentCounter {
  queue: number[];
  index: number;

  constructor() {
    this.queue = [];
    this.index = 0;
  }

  ping(t: number): number {
    const windowStart = t - 3000;
    this.queue.push(t);

    while (
      this.index < this.queue.length &&
      this.queue[this.index] < windowStart
    ) {
      this.index++;
    }

    return this.queue.length - this.index;
  }
}
```

## 5. Optimized Code Explain

- time complexity: Amortized O(1) (performs only one comparison on average per request)
- space complexity: O(n) (because requests are continuously added to the queue)
- While the original code had O(n) time complexity due to iterating through the array using the `filter()` method, the improved code achieves O(1) time complexity by performing only one comparison on average per request.
