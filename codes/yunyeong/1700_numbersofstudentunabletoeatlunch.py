class RecentCounter:
    def __init__(self):
        self.ping_list = [0]

    def ping(self, t: int) -> int:
        self.ping_list.append(t)
        count =0
        for i in range(len(self.ping_list) -1, 0,-1):
            if self.ping_list[i] >= max(0,t-3000):
                count += 1
            else:
		        return count
# Wrong.