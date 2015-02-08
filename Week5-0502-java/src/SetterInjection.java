import com.sun.tools.classfile.Dependency;

/**
 * Created by liliya on 05/02/2015.
 */
public class SetterInjection {

    private Dependency dep;

    public void setMyDep(Dependency dep){
        this.dep = dep;
    }
}
