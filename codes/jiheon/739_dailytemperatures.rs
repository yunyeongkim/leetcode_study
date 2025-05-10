impl Solution {
    pub fn daily_temperatures(temperatures: Vec<i32>) -> Vec<i32> {
        let mut answer = vec![0i32; temperatures.len()];
        let mut stack: Vec<usize> = Vec::new();

        for (today_idx, &today_temperature) in temperatures.iter().enumerate() {
            while let Some(&prev_day_idx) = stack.last() {
                if temperatures[prev_day_idx] >= today_temperature {
                    break;
                }
                answer[prev_day_idx] = (today_idx - prev_day_idx) as _;
                stack.pop();
            }
            stack.push(today_idx);
        }

        answer
    }
}