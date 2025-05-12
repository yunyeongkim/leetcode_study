use std::collections::VecDeque;

struct RecentCounter {
     queue: VecDeque<i32>,
}


impl RecentCounter {

    fn new() -> Self {
        RecentCounter
        {
            queue : VecDeque::new(),
        }
    }

    fn ping(&mut self, t: i32) -> i32 {
        self.queue.push_back(t);

        while let Some(&val) = self.queue.front() {
            if val < t - 3000 {
                self.queue.pop_front();
            } else {
                break;
            }
        }
        self.queue.len() as i32
    }
}