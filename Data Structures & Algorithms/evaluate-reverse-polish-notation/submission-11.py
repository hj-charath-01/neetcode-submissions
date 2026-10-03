class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []

        for token in tokens:
            if token == "+":
                stack.append(stack.pop() + stack.pop())
            elif token == "*":
                stack.append(stack.pop() * stack.pop())
            elif token == "-":
                prev = stack.pop()
                stack.append(stack.pop() - prev)
            elif token == "/":
                prev = stack.pop()
                stack.append(int(stack.pop() / prev))
            else:
                stack.append(int(token))

        return stack[0]        