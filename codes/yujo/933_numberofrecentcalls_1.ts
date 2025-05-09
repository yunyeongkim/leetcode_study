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