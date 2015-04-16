package mock_exam;

import sun.jvm.hotspot.types.JLongField;

/**
 * Created by liliya on 16/04/2015.
 */
public class LoggerExample {
    public static void main(String [] args){
        JLog log = new JLoggerToLogAdapter(new JLogger());
    }
    
}

interface JLog{
    void warning(String msg);
    void error(String msg);
    
}

class JLogger{
    void log(int level, String message){
        
        
    }
    
}

class JLoggerToLogAdapter implements JLog{
    
    private final JLogger example;
    
    public JLoggerToLogAdapter(JLogger log){
        this.example = log;
        
    }


    @Override
    public void warning(String msg) {
        example.log(10, msg);
    }

    @Override
    public void error(String msg) {
        example.log(5, "msg");
    }
}
