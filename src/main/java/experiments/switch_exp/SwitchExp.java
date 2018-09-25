package experiments.switch_exp;

public class SwitchExp {

    public static void switchWithFallThrough(String aCase) {
        switch(aCase) {
            case "foo":
            case "bar":
                System.out.println("Did something common for both go foo and bar");
                break;
            case "baz":
                System.out.println("Did something for baz");
                break;
            default:
                System.out.println("Nothing worked, so lets do to default");
        }
    }

    public static void main(String[] args) {

        SwitchExp.switchWithFallThrough("bar");
        SwitchExp.switchWithFallThrough("foo");
        SwitchExp.switchWithFallThrough("baz");
        SwitchExp.switchWithFallThrough("evil");
        
    }
}