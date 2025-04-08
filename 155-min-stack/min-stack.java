class MinStack {
    Stack <Integer> stk;
    Stack <Integer> minstk;
    public MinStack() {
        stk = new Stack();
        minstk = new Stack();
    }
    
    public void push(int val) {
        stk.push(val);

        if(minstk.isEmpty() || val <= minstk.peek()){
        minstk.push(val);
        }
    }
    
    public void pop() {
       int x =  stk.pop();

        if(x  == minstk.peek()){
            minstk.pop();
        }
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minstk.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */