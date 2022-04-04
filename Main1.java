class Main1
{
    public static boolean isAlpha(String s) {
        return s != null && s.matches("^[a-zA-Z' ']*$");
    }
 
    public static void main(String[] args)
    {
        String s = "prem";
        System.out.println("IsAlpha: " + isAlpha(s));
    }
}