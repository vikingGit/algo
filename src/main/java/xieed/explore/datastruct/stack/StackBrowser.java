package xieed.explore.datastruct.stack;

import java.util.ArrayList;

public class StackBrowser {

    private ArrayStack<String> backStack;
    private ArrayStack<String> forwardStack;

    public StackBrowser(int capacity, ArrayList<String> urls) {
        this.forwardStack = new ArrayStack<String>(capacity);
        urls.stream().forEach(url -> this.forwardStack.push(url));
        this.backStack = new ArrayStack<String>(capacity);
    }

    public void forward() {
        if(this.backStack.size() == 0){
            return;
        }
        this.forwardStack.push(this.backStack.pop());
    }

    public ArrayStack<String> getBackStack() {
        return backStack;
    }

    public ArrayStack<String> getForwardStack() {
        return forwardStack;
    }

    public void back() {
        if(this.forwardStack.size() == 0){
            return;
        }
        this.backStack.push(this.forwardStack.pop());
    }

    public void directTo(String url) {
        this.forwardStack.push(url);
    }
}