def dailyTemperatures(self, temperatures:List[int])->List[int]:
    stack = []
    answer = [0]*len(temperature)
    for i, temperature in enumerate(temperatures):
        while stack and temperatures[stack[-1]] < temperature:
            day = stack.pop()
            answer[day] = i - day
		stack.append(i)
        
    return answer