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