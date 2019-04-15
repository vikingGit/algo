package xieed.algorithm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import xieed.explore.datastruct.stack.StackBrowser;

import java.util.ArrayList;

public class StackBrowserTest {

    private StackBrowser stackBrowser;

    @Before
    public void setUp() throws Exception {
        ArrayList<String> urls = new ArrayList<String>();
        urls.add("oocl.com");
        urls.add("taobao.com");
        urls.add("baidu.com");
        stackBrowser = new StackBrowser(10, urls);
    }

    @Test
    public void should_return_taobao_when_back_given_multiple_link_in_order() {
        stackBrowser.back();

        Assert.assertEquals(1, stackBrowser.getBackStack().size());
        Assert.assertEquals(2, stackBrowser.getForwardStack().size());
        Assert.assertEquals("taobao.com", stackBrowser.getForwardStack().peek());
    }

    @Test
    public void should_return_baidu_when_forward_given_back_to_taobao() {
        stackBrowser.back();
        stackBrowser.forward();

        Assert.assertEquals(0, stackBrowser.getBackStack().size());
        Assert.assertEquals(3, stackBrowser.getForwardStack().size());
        Assert.assertEquals("baidu.com", stackBrowser.getForwardStack().peek());
    }


    @Test
    public void should_return_taobao_when_back_given_new_link_joined() {
        //A,B,C,D

        //A,B,C   //D
        stackBrowser.back();
        //A,B,C,E //D
        stackBrowser.directTo("jindong.com");
        //A,B,C  //D,E
        stackBrowser.back();

        Assert.assertEquals(2, stackBrowser.getBackStack().size());
        Assert.assertEquals(2, stackBrowser.getForwardStack().size());
        Assert.assertEquals("taobao.com", stackBrowser.getForwardStack().peek());
    }

}