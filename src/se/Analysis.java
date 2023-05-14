package se;

public class Analysis {
    String string;
    String str = "\\r\\n";
    String numString = "([0-9]+\\.[0-9]{3})";
    Analysis() {
    };

    public Analysis(String string) {
        this.string = string;
    }

    public void Process() {
        
        while (true) {
            
            if (string.matches(str)) {
                System.out.println("继续解析<CR><LF>前面是否包含高度值");
                if (string.matches(numString)) {
                    System.out.println("取出高度值，并把解析内容用<CR><LF>后面内容替换");
                    System.out.println("转到1");
                }else {
                    System.out.println("把解析内容用<CR><LF>后面内容替换");
                    System.out.println("转到1");
                }
            }else {
                System.out.println("清空");
                return ;
            }
            int index = string.indexOf(str);
            string = string.substring(index);
        }
    }
}
