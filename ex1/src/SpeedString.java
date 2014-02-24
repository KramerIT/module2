public class SpeedString {
    public static void main(String[] args){
        String string = "123";
        StringBuilder stringBuilder = new StringBuilder("123");

        System.out.println(string);
        System.out.println(stringBuilder);

        long time = System.currentTimeMillis();
        System.out.println(time);
        for (int i = 0; i < 10000; i++){
            string += i*10 + "abc";
        }
        time = System.currentTimeMillis();
        System.out.println(time);
        for (int i = 0; i < 10000; i++){
            stringBuilder.append(i*10 + "abc");
        }
        time = System.currentTimeMillis();
        System.out.println(time);
    }
}
