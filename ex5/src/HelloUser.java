public class HelloUser {
    public static void main(String[] args){
        if (args.length > 0 ){
            GetHello getHello = new GetHello(args[0], args[1]);
        }
        else {
            GetHello getHello = new GetHello();
        }
    }
}
